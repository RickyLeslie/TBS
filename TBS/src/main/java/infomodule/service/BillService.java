package infomodule.service;

import java.util.ArrayList;
import java.util.List;

import infomodule.dao.BillDao;
import infomodule.pojo.Account;
import infomodule.pojo.Bill;
import infomodule.pojo.PageBean;

public class BillService {
	
	BillDao billDao=new BillDao();
	
	public int insert(Bill bill){
		int resultSet =0;
		resultSet=billDao.insertBill(bill);
		return resultSet;
	}
	
	public int delete(String id){
		int resultSet=0;
		resultSet=billDao.deleteBillByID(id);
		return resultSet;
	}
	
	public int update(Bill bill){
		int resultSet=0;
		resultSet=billDao.updateBillByID(bill);
		return resultSet;
	}
	
	public Bill query(String id){
		Bill bill=new Bill();
		bill=billDao.findBillByID(id);
		if(bill!=null){
			return bill;
		}
		return null;
	}
	
	public List<Bill> getAllBills(String MUID){
		List<Bill> bills=new ArrayList<Bill>();
		bills=billDao.findAllBills(MUID);
		if(bills!=null){
			return bills;
		}
		return null;
	}
	
	public Bill getBill(String id){
		Bill bill=new Bill();
		bill=billDao.findBillByID(id);
		return bill;
	}
	
	public PageBean pageQuery(int currentPage,int pageSize){
		PageBean pageBean=new PageBean();
		pageBean=billDao.pageQuery(currentPage, pageSize);
		if(pageBean!=null){
			return pageBean;
		}
		return null;
	}
	
	public double consume(int time){
		return (time/60+1)*0.15;
	}

}
