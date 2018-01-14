package infomodule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import infomodule.pojo.Staff;
import infomodule.pojo.StaffLog;
import util.JDBCUtil;

public class StaffLogDao {
	
	Connection connection=JDBCUtil.getConnection();
	
	public int InsertStaffLog(StaffLog log){
		String sql="insert into stafflog(staff_id,log_type,log_object,log_text) values(?,?,?,?,?)";
		SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dia_time = adf.format(new Date());
		int resultSet=0;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, log.getStaff_id());
			preparedStatement.setString(2, log.getLog_type());
			preparedStatement.setString(3, dia_time);
			preparedStatement.setString(4, log.getLog_object());
			preparedStatement.setString(5, log.getLog_text());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteStaffLogDaoByID(String id){
		String sql="delete from stafflog where id = ?";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(id));
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
