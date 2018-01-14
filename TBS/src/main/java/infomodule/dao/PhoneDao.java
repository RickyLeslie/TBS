package infomodule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infomodule.pojo.PageBean;
import infomodule.pojo.Phone;
import util.JDBCUtil;

public class PhoneDao {
	
Connection connection=JDBCUtil.getConnection();
	
	public int insertPhone(Phone phone){
		String sql="insert into Phone values(?,?,?)";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, phone.getTelephone());
			preparedStatement.setString(2, phone.getAddress());
			preparedStatement.setString(3, phone.getBankAccount());
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deletePhoneByID(String telephone){
		String sql="delete from Phone where telephone=?";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, telephone);
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updatePhoneByID(Phone phone){
		String sql="update Phone set address=?,bankAccount=? where telephone=?";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, phone.getAddress());
			preparedStatement.setString(2, phone.getBankAccount());
			preparedStatement.setString(3, phone.getTelephone());
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Phone> findAllPhonesByBankAccount(String bankAccount){
		String sql="select * from Phone where bankAccount=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<Phone> phones=new ArrayList<Phone>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bankAccount);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Phone phone=new Phone();
				phone.setTelephone(resultSet.getString("telephone"));
				phone.setAddress(resultSet.getString("address"));
				phone.setBankAccount(resultSet.getString("bankAccount"));
				phones.add(phone);
			}
			return phones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Phone> findAllPhones(){
		String sql="select * from Phone";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<Phone> phones=new ArrayList<Phone>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Phone phone=new Phone();
				phone.setTelephone(resultSet.getString("telephone"));
				phone.setAddress(resultSet.getString("address"));
				phone.setBankAccount(resultSet.getString("bankAccount"));
				phones.add(phone);
			}
			return phones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Phone findPhoneByID(String telephone){
		String sql="select * from Phone where telephone=?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Phone phone=new Phone();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, telephone);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				phone.setTelephone(resultSet.getString("telephone"));
				phone.setAddress(resultSet.getString("address"));
				phone.setBankAccount(resultSet.getString("bankAccount"));
				phone.setPassword(resultSet.getString("password"));
			}
			return phone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//分页查询
	public PageBean pageQuery(int currentPage,int pageSize){
		PageBean pageBean=new PageBean();
		String sql="select * from Phone order by telephone asc limit ?,?";
		ArrayList<Phone> phones=new ArrayList<Phone>();
		//计算当前页的第一条记录
		int pageBegin=pageBean.countOffset(currentPage, pageSize);
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, pageBegin);
			preparedStatement.setInt(2, pageSize);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Phone phone=new Phone();
				phone.setTelephone(resultSet.getString("telephone"));
				phone.setAddress(resultSet.getString("address"));
				phone.setBankAccount(resultSet.getString("bankAccount"));
				phones.add(phone);
			}
			preparedStatement=connection.prepareCall("select count(*) from phone");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				pageBean.setAllRow(resultSet.getInt(1));
			}
			//计算总页数
			int totalPage=pageBean.countTotalPage(pageSize, pageBean.getAllRow());
			pageBean.setList(phones);
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
