package infomodule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infomodule.pojo.Industry;
import util.JDBCUtil;

public class industryDao {
	
	Connection connection = JDBCUtil.getConnection();
	/**
	 * 查询
	 * @param id
	 * @return 返回List对象
	 */
	public List<Industry> findAllPost(){
		String sql = "SELECT * FROM industry ";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Industry> industries = new ArrayList<Industry>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Industry industry = new Industry();
				industry.setId(resultSet.getString("id"));
				industry.setIndustryName(resultSet.getString("industryName"));
				industries.add(industry);
			}
			return industries;
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

}
