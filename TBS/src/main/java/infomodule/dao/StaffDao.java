package infomodule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infomodule.pojo.Staff;
import sun.print.resources.serviceui;
import util.JDBCUtil;

public class StaffDao {
	
	Connection connection=JDBCUtil.getConnection();
	
	public int insertStaff(Staff staff){
		String sql="insert into staff values(?,?,?)";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, staff.getId());
			preparedStatement.setString(2, staff.getStaffName());
			preparedStatement.setString(3, staff.getPassword());
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteStaffByID(String id){
		String sql="delete from staff where id = ?";
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
	
	public int updateStaff(Staff staff){
		String sql="update staff set staffName=?,password=? where id=?";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, staff.getStaffName());
			preparedStatement.setString(2, staff.getPassword());
			preparedStatement.setString(3, staff.getId());
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Staff> findAllStaffs(){
		String sql="select * from staff";
		PreparedStatement preparedStatement=null;
		List<Staff> staffs=new ArrayList<Staff>();
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Staff staff=new Staff();
				staff.setId(resultSet.getString("id"));
				staff.setStaffName(resultSet.getString("staffName"));
				staff.setStaffName(resultSet.getString("password"));
				staffs.add(staff);
			}
			return staffs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Staff findStaffByID(String id){
		String sql="select * from staff where id =?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Staff staff=new Staff();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				staff.setId(resultSet.getString("id"));
				staff.setStaffName(resultSet.getString("staffName"));
				staff.setPassword(resultSet.getString("password"));
			}
			return staff;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement!=null){
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return staff;
	}
	
	//分页查询
	
}
