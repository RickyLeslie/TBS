package infomodule.service;

import java.util.ArrayList;
import java.util.List;

import infomodule.dao.StaffDao;
import infomodule.pojo.Staff;

public class StaffService {
	
	StaffDao staffDao=new StaffDao();
	
	public int insert(Staff staff){
		int resultSet=0;
		resultSet=staffDao.insertStaff(staff);
		return resultSet;
	}
	
	public int delete(String id){
		int resultSet=0;
		resultSet=staffDao.deleteStaffByID(id);
		return resultSet;
	}
	
	public int update(Staff staff){
		int resultSet=0;
		resultSet=staffDao.updateStaff(staff);
		return resultSet;
	}
	
	public List<Staff> getAllStaffs(){
		List<Staff> staffs=new ArrayList<Staff>();
		staffs=staffDao.findAllStaffs();
		if(staffs!=null){
			return staffs;
		}
		return null;
	}
	
	public Staff getStaff(String id){
		Staff Staff=new Staff();
		Staff=staffDao.findStaffByID(id);
		if(Staff!=null){
			return Staff;
		}
		return null;
	}
	
}
