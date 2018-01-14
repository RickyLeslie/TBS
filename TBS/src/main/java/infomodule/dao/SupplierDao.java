package infomodule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import infomodule.pojo.Supplier;
import util.JDBCUtil;

public class SupplierDao {
	
	Connection connection = JDBCUtil.getConnection();

	public Supplier selectcusByTelephone(String telephone){
		String sql = "SELECT * FROM supplier WHERE telephone=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Supplier supplier = new Supplier();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, telephone);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				supplier.setId(resultSet.getString("id"));
				supplier.setSupplierName(resultSet.getString("supplierName"));
				supplier.setTelephone(resultSet.getString("telephone"));
			}
			return supplier;
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
		return null;
	}

	public int deleteByTelephone(String telephone){
		String sql = "DELETE from supplier WHERE telephone=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, telephone);
			int resultSet = 0;
			resultSet = preparedStatement.executeUpdate();
			return resultSet;
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
		return 0;
	}
	
	//分页查询
}
