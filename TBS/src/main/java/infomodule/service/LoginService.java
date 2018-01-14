package infomodule.service;

import infomodule.dao.PhoneDao;
import infomodule.dao.StaffDao;
import infomodule.pojo.Phone;
import infomodule.pojo.Staff;

public class LoginService {
	
	StaffDao staffDao=new StaffDao();
	PhoneDao phoneDao=new PhoneDao();
	
	public Staff login(String id,String password){
		System.out.println(id+" "+password);
		Staff staff=new Staff();
		staff=staffDao.findStaffByID(id);
		System.out.println(staff);
		if(password.equals(staff.getPassword())){
			return staff;
		}
		return null;
	}
	
	public Phone phoneLogin(String telephonr,String password){
		System.out.println(telephonr+" "+password);
		Phone phone=new Phone();
		phone=phoneDao.findPhoneByID(telephonr);
		System.err.println(phone);
		if(password.equals(phone.getPassword())){
			return phone;
		}
		return null;
	}
	
	
	
}
