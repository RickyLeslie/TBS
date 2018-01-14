package infomodule.service;

import java.util.ArrayList;
import java.util.List;

import infomodule.dao.CustomerDao;
import infomodule.pojo.Customer;
import infomodule.pojo.PageBean;

public class CustomerService {
	
	CustomerDao customerDao=new CustomerDao();
	
	public int insert(Customer customer){
		int resultSet=0;
		resultSet=customerDao.insertCustomer(customer);
		return resultSet;
	}
	
	public int delete(String id){
		int resultSet=0;
		resultSet=customerDao.deleteCustomer(id);
		return resultSet;
	}
	
	public int update(Customer customer){
		int resultSet=0;
		resultSet=customerDao.updateCustomer(customer);
		return resultSet;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers=new ArrayList<Customer>();
		customers=customerDao.findAllCustomers();
		if(customers!=null){
			return customers;
		}
		return null;
	}
	
	public Customer query(String id){
		Customer customer=new Customer();
		customer=customerDao.findCustomerByID(id);
		if(customer!=null){
			return customer;
		}
		return null;
	}
	
	//分页查询
	public PageBean pageQuery(int currentPage,int pageSize){
		if(customerDao.pageQery(currentPage, pageSize)!=null){
			return customerDao.pageQery(currentPage, pageSize);
		}
		return null;
	}
	//批量删除

}
