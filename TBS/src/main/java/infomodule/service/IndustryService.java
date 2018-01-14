package infomodule.service;

import java.util.List;

import infomodule.dao.industryDao;
import infomodule.pojo.Industry;

public class IndustryService {
	
	industryDao industryDao=new industryDao();
	
	public List<Industry> getAllIndustry(){
		List<Industry> list = null;
		list = industryDao.findAllPost();
		if(list!=null){
			return list;
		}else {
			return null;
		}
	}
	
}
