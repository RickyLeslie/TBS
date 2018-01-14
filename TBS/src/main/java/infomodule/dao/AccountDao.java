package infomodule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infomodule.pojo.Account;
import infomodule.pojo.PageBean;
import util.JDBCUtil;

public class AccountDao {
	
	Connection connection=JDBCUtil.getConnection();
	
	public int insertAccount(Account account){
		String sql="insert into account values(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, account.getId());
			preparedStatement.setString(2, account.getCustomer_id());
			preparedStatement.setString(3, account.getBankAccount());
			preparedStatement.setString(4, account.getOpenBank());
			preparedStatement.setDouble(5, account.getReadyAmount());
			preparedStatement.setDouble(6, account.getCostAmount());
			preparedStatement.setDouble(7, account.getCostMonthAmount());
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteAccountByID(String id){
		String sql="delete from account where id=?";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateAccountByID(Account account){
		String sql="update account set bankAccount=?,openBank=?,readyAmount=?,costAmount=?,costMonthAmount=? where id=?";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, account.getBankAccount());
			preparedStatement.setString(2, account.getOpenBank());
			preparedStatement.setDouble(3, account.getReadyAmount());
			preparedStatement.setDouble(4, account.getCostAmount());
			preparedStatement.setDouble(5, account.getCostMonthAmount());
			preparedStatement.setString(6, account.getId());
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Account> findAllAccountsByCus_id(String customer_id){
		String sql="select * from account where customer_id=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<Account> accounts=new ArrayList<Account>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, customer_id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Account account=new Account();
				account.setId(resultSet.getString("id"));
				account.setCustomer_id(resultSet.getString("customer_id"));
				account.setBankAccount(resultSet.getString("bankAccount"));
				account.setOpenBank(resultSet.getString("openBank"));
				account.setReadyAmount(resultSet.getDouble("readyAmount"));
				account.setCostAmount(resultSet.getDouble("costAmount"));
				account.setCostMonthAmount(resultSet.getDouble("costMonthAmount"));
				accounts.add(account);
			}
			return accounts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Account> findAllAccounts(){
		String sql="select * from account";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<Account> accounts=new ArrayList<Account>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Account account=new Account();
				account.setId(resultSet.getString("id"));
				account.setCustomer_id(resultSet.getString("customer_id"));
				account.setBankAccount(resultSet.getString("bankAccount"));
				account.setOpenBank(resultSet.getString("openBank"));
				account.setReadyAmount(resultSet.getDouble("readyAmount"));
				account.setCostAmount(resultSet.getDouble("costAmount"));
				account.setCostMonthAmount(resultSet.getDouble("costMonthAmount"));
				accounts.add(account);
			}
			return accounts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Account findAccountByID(String id){
		String sql="select * from account where id=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Account account=new Account();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				account.setId(resultSet.getString("id"));
				account.setCustomer_id(resultSet.getString("customer_id"));
				account.setBankAccount(resultSet.getString("bankAccount"));
				account.setOpenBank(resultSet.getString("openBank"));
				account.setReadyAmount(resultSet.getDouble("readyAmount"));
				account.setCostAmount(resultSet.getDouble("costAmount"));
				account.setCostMonthAmount(resultSet.getDouble("costMonthAmount"));
			}
			return account;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//分页查询
	public PageBean pageQuery(int currentPage,int pageSize){
		PageBean pageBean=new PageBean();
		List<Account> accounts=new ArrayList<Account>();
		//计算当前页的第一条记录
		int pageBegin=pageBean.countOffset(currentPage,pageSize);
		String sql="select * from account order by id asc limit ?,?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, pageBegin);
			preparedStatement.setInt(2, pageSize);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Account account=new Account();
				account.setId(resultSet.getString("id"));
				account.setCustomer_id(resultSet.getString("customer_id"));
				account.setBankAccount(resultSet.getString("bankAccount"));
				account.setOpenBank(resultSet.getString("openBank"));
				account.setReadyAmount(resultSet.getDouble("readyAmount"));
				account.setCostAmount(resultSet.getDouble("costAmount"));
				account.setCostMonthAmount(resultSet.getDouble("costMonthAmount"));
				accounts.add(account);
			}
			//prepareCall方法 用于执行数据库的存储过程 
			//有点:存储过程只在创造时进行编译，以后每次执行存储过程都不需再重新编译，而一般SQL语句每执行一次就编译一次,所以使用存储过程可提高数据库执行速度。
			preparedStatement=connection.prepareCall("select count(*) from account");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				pageBean.setAllRow(resultSet.getInt(1));
			}
			//计算总页数
			int totalPage=pageBean.countTotalPage(pageSize, pageBean.getAllRow());
			pageBean.setList(accounts);
			pageBean.setCurrentPage(currentPage);
			pageBean.setPageSize(pageSize);
			pageBean.setTotalPage(totalPage);
			return pageBean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//批量删除
	public void batchDelete(){
		
	}
	
}
