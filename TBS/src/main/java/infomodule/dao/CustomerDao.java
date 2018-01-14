package infomodule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infomodule.pojo.Customer;
import infomodule.pojo.PageBean;
import util.JDBCUtil;

public class CustomerDao {
	
	Connection connection=JDBCUtil.getConnection();
	
	public int insertCustomer(Customer customer){
		String sql="insert into customer values(?,?,?,?,?,?)";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getId());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getCustomerType());
			preparedStatement.setString(4, customer.getLocation());
			preparedStatement.setString(5, customer.getManager());
			preparedStatement.setString(6, customer.getIndustry());
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteCustomer(String id){
		String sql="delete from customer where id=?";
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
	
	public int updateCustomer(Customer customer){
		String sql="update customer set customerName=?,customerType=?,location=?,manager=?,industry=? where id=?";
		PreparedStatement preparedStatement=null;
		int resultSet=0;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getCustomerType());
			preparedStatement.setString(3, customer.getLocation());
			preparedStatement.setString(4, customer.getManager());
			preparedStatement.setString(5, customer.getIndustry());
			preparedStatement.setString(6, customer.getId());
			resultSet=preparedStatement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Customer> findAllCustomers(){
		String sql="select * from customer";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<Customer> customers = new ArrayList<Customer>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Customer customer=new Customer();
				customer.setId(resultSet.getString("id"));
				customer.setCustomerName(resultSet.getString("customerName"));
				customer.setCustomerType(resultSet.getString("customerType"));
				customer.setLocation(resultSet.getString("location"));
				customer.setManager(resultSet.getString("manager"));
				customer.setIndustry(resultSet.getString("industry"));
				customers.add(customer);
			}
			return customers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Customer findCustomerByID(String id){
		String sql="select * from customer where id=?";
		PreparedStatement preparedStatement=null;
		Customer customer=new Customer();
		ResultSet resultSet = null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				customer.setId(resultSet.getString("id"));
				customer.setCustomerName(resultSet.getString("customerName"));
				customer.setCustomerType(resultSet.getString("customerType"));
				customer.setLocation(resultSet.getString("location"));
				customer.setManager(resultSet.getString("manager"));
				customer.setIndustry(resultSet.getString("industry"));
			}
			return customer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//分页查询
	public PageBean pageQery(int currentPage,int pageSize){
		String sql="select * from customer order by id limit ?,?";
		PageBean pageBean=new PageBean();
		System.out.println("dao");
		ArrayList<Customer> customers=new ArrayList<Customer>();
		//计算当前页的第一条记录
		int pageBegin=pageBean.countTotalPage(pageSize, pageSize);
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, pageBegin);
			preparedStatement.setInt(2, pageSize);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Customer customer=new Customer();
				customer.setId(resultSet.getString("id"));
				customer.setCustomerName(resultSet.getString("customerName"));
				customer.setCustomerType(resultSet.getString("customerType"));
				customer.setLocation(resultSet.getString("location"));
				customer.setManager(resultSet.getString("manager"));
				customer.setIndustry(resultSet.getString("industry"));
				customers.add(customer);
			}
			preparedStatement=connection.prepareCall("select count(*) from customer");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				pageBean.setAllRow(resultSet.getInt(1));
			}
			//计算总页数
			int totalPage=pageBean.countTotalPage(pageSize, pageBean.getAllRow());
			pageBean.setList(customers);
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
