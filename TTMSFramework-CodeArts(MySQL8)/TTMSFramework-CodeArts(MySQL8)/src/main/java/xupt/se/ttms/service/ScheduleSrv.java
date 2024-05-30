package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iScheduleDAO;
import xupt.se.ttms.model.Schedule;

public class ScheduleSrv {
	private iScheduleDAO scheDAO=DAOFactory.creatScheduleDAO();
	
	public int add(Schedule sche){
		return scheDAO.insert(sche);     //scheDAO.insert(sche)=1		
	}
	
	public int modify(Schedule sche){
		return scheDAO.update(sche); 		
	}
	
	public int delete(int id){
		return scheDAO.delete(id); 		
	}
	
	public List<Schedule> Fetch(int condt){
		return scheDAO.select(condt);		
	}
	
	public List<Schedule> FetchAll(){
		return scheDAO.selectAll();		
	}
}