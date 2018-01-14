package infomodule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infomodule.pojo.Account;
import infomodule.pojo.Bill;
import infomodule.pojo.PageBean;
import util.JDBCUtil;

public class BillDao {
	
Connection connection=JDBCUtil.getConnection();
	
	public int insertBill(Bill bill){
		String sql="insert into Bill values(?,?,?,?,?)";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bill.getId());
			preparedStatement.setString(2, bill.getMUID());
			preparedStatement.setString(3, bill.getCUID());
			preparedStatement.setInt(4, bill.getCallDuration());
			preparedStatement.setDouble(5, bill.getTelephoneCharge());
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteBillByID(String id){
		String sql="delete from Bill where id=?";
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
	
	public int updateBillByID(Bill bill){
		String sql="update Bill set MUID=?,CUID=?,callDuration=?,telephoneCharge=? where id=?";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bill.getMUID());
			preparedStatement.setString(2, bill.getCUID());
			preparedStatement.setInt(3, bill.getCallDuration());
			preparedStatement.setDouble(4, bill.getTelephoneCharge());
			preparedStatement.setString(5, bill.getId());
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Bill> findAllBills(String MUID){
		String sql="select * from Bill where MUID=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<Bill> bills=new ArrayList<Bill>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, MUID);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Bill bill=new Bill();
				bill.setId(resultSet.getString("id"));
				bill.setMUID(resultSet.getString("MUID"));
				bill.setCUID(resultSet.getString("CUID"));
				bill.setCallDuration(resultSet.getInt("callDuration"));
				bill.setTelephoneCharge(resultSet.getDouble("telephoneCharge"));
				bills.add(bill);
			}
			return bills;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Bill findBillByID(String id){
		String sql="select * from Bill where id=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Bill bill=new Bill();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				bill.setId(resultSet.getString("id"));
				bill.setMUID(resultSet.getString("MUID"));
				bill.setCUID(resultSet.getString("CUID"));
				bill.setCallDuration(resultSet.getInt("callDuration"));
				bill.setTelephoneCharge(resultSet.getDouble("telephoneCharge"));
			}
			return bill;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public PageBean pageQuery(int currentPage,int pageSize){
		PageBean pageBean=new PageBean();
		List<Bill> bills=new ArrayList<Bill>();
		//计算当前页的第一条记录
		int pageBegin=pageBean.countOffset(currentPage,pageSize);
		String sql="select * from bill order by id asc limit ?,?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, pageBegin);
			preparedStatement.setInt(2, pageSize);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Bill bill=new Bill();
				bill.setId(resultSet.getString("id"));
				bill.setMUID(resultSet.getString("MUID"));
				bill.setCUID(resultSet.getString("CUID"));
				bill.setCallDuration(resultSet.getInt("callDuration"));
				bill.setTelephoneCharge(resultSet.getDouble("telephoneCharge"));
				bills.add(bill);
			}
			//prepareCall方法 用于执行数据库的存储过程 
			//有点:存储过程只在创造时进行编译，以后每次执行存储过程都不需再重新编译，而一般SQL语句每执行一次就编译一次,所以使用存储过程可提高数据库执行速度。
			preparedStatement=connection.prepareCall("select count(*) from bill");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				pageBean.setAllRow(resultSet.getInt(1));
			}
			//计算总页数
			int totalPage=pageBean.countTotalPage(pageSize, pageBean.getAllRow());
			pageBean.setList(bills);
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
}
