package infomodule.service;

import infomodule.dao.StaffLogDao;
import infomodule.pojo.StaffLog;

public class StaffLogService {
	
	StaffLogDao staffLogDao=new StaffLogDao();
	
	public int insert(StaffLog log){
		int result=0;
		result=staffLogDao.InsertStaffLog(log);
		return 0;
	}
	
	public int delete(String id){
		int resultSet=0;
		resultSet=staffLogDao.deleteStaffLogDaoByID(id);
		return 0;
	}
	
	//分页查询
	//批量删除

}
