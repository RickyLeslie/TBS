package infomodule.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import infomodule.dao.AccountDao;
import infomodule.pojo.Account;
import infomodule.pojo.PageBean;
import jxl.write.WriteException;
import util.ExcelUtil;

public class AccountService {
	
	AccountDao accountDao=new AccountDao();
	
	public int insert(Account account){
		int resultSet=0;
		resultSet=accountDao.insertAccount(account);
		return resultSet;
	}
	
	public int delete(String id){
		int resultSet=0;
		resultSet=accountDao.deleteAccountByID(id);
		return resultSet;
	}
	
	public int update(Account account){
		int resultSet=0;
		resultSet=accountDao.updateAccountByID(account);
		return resultSet;
	}
	
	public List<Account> getAllAccountsByCus_id(String cus_id){
		List<Account> accounts=new ArrayList<Account>();
		accounts=accountDao.findAllAccountsByCus_id(cus_id);
		if(accounts!=null){
			return accounts;
		}
		return null;
	}
	
	public List<Account> getAllAccounts(){
		List<Account> accounts=new ArrayList<Account>();
		accounts=accountDao.findAllAccounts();
		if(accounts!=null){
			return accounts;
		}
		return null;
	} 
	
	public Account query(String id){
		Account account=new Account();
		account=accountDao.findAccountByID(id);
		if(account!=null){
			return account;
		}
		return null;
	}
	
	//消费
	//分页查询
	public PageBean pageQuery(int currentPage,int pageSize){
		PageBean pageBean=new PageBean();
		pageBean=accountDao.pageQuery(currentPage, pageSize);
		if(pageBean!=null){
			return pageBean;
		}
		return null;
	}
	
	//批量删除
	//导入Excel文件
	public void excelRead(){
		File file=new File("C:/Users/Kaka/Desktop/Account.xls");
		ArrayList<Account> accounts=(ArrayList<Account>) this.getAllAccounts();
		accounts=ExcelUtil.excelRead(file);
		System.out.println(accounts);
	}
	
	//导出Excel文件
	public void excelWrite() throws IOException{
		File file=new File("C:/Users/Kaka/Desktop/Account.xls");
		file.createNewFile();
		System.out.println(file.exists());
		ArrayList<Account> accounts=(ArrayList<Account>) this.getAllAccounts();
		try {
			ExcelUtil.excelWrite(file, accounts);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file.getAbsolutePath());
	}
}
