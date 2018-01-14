package infomodule.service;

import java.util.ArrayList;
import java.util.List;

import infomodule.dao.PhoneDao;
import infomodule.pojo.PageBean;
import infomodule.pojo.Phone;

public class PhoneService {
	
	PhoneDao phoneDao=new PhoneDao();
	
	public int insert(Phone phone){
		int resultSet=0;
		resultSet=phoneDao.insertPhone(phone);
		return resultSet;
	}
	
	public int delete(String id){
		int resultSet=0;
		resultSet=phoneDao.deletePhoneByID(id);
		return resultSet;
	}
	
	public int update(Phone phone){
		int resultSet=0;
		resultSet=phoneDao.updatePhoneByID(phone);
		return resultSet;
	}
	
	public List<Phone> getAllPhonesByBankAccount(String bankAccount){
		List<Phone> phones=new ArrayList<Phone>();
		phones=phoneDao.findAllPhonesByBankAccount(bankAccount);
		if(phones!=null){
			return phones;
		}
		return null;
	}
	
	public List<Phone> getAllPhones(){
		List<Phone> phones=new ArrayList<Phone>();
		phones=phoneDao.findAllPhones();
		if(phones!=null){
			return phones;
		}
		return null;
	}
	
	public Phone query(String id){
		Phone phone=new Phone();
		phone=phoneDao.findPhoneByID(id);
		if(phone!=null){
			return phone;
		}
		return null;
	}
	
	//分页查询
	public PageBean pageQuery(int currentPage,int PageSize){
		if(phoneDao.pageQuery(currentPage, PageSize)!=null){
			return phoneDao.pageQuery(currentPage, PageSize);
		}
		return null;
	}
	
}
