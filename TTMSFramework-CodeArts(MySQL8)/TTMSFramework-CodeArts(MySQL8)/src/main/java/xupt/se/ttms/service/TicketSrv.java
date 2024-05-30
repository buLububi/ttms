package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iTicketDAO;
import xupt.se.ttms.model.Ticket;

public class TicketSrv {
	private iTicketDAO stuDAO=DAOFactory.creatTicketDAO();
	
	public int add(Ticket stu){
		return stuDAO.insert(stu); 		
	}
	
	public int modify(Ticket stu){
		return stuDAO.update(stu); 		
	}
	
	public int delete(int ID){
		return stuDAO.delete(ID); 		
	}
	
	public List<Ticket> Fetch(String name){
		return stuDAO.select(name);		
	}
	
	public List<Ticket> FetchAll(){
		return stuDAO.select("");		
	}
}
