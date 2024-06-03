package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iCheckTicketDAO;
import xupt.se.ttms.model.checkTicket;

public class CheckTicketSrv {
	private iCheckTicketDAO stuDAO=DAOFactory.creatCheckTicketDAO();
	
	
	
	public int modify(checkTicket stu){
		return stuDAO.update(stu); 		
	}
	
	
	public List<checkTicket> Fetch(String name){
		return stuDAO.select(name);		
	}
	
	public List<checkTicket> FetchAll(){
		return stuDAO.select("");		
	}
}
