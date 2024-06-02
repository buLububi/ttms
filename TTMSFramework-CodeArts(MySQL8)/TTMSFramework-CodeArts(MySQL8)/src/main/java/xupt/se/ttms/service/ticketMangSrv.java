package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iticketMangDAO;
import xupt.se.ttms.model.ticketMang;

public class ticketMangSrv {
	private iticketMangDAO tmDAO=DAOFactory.creatTicketMangDAO();
	
	
	
	public List<ticketMang> Fetch(String condt){
		return tmDAO.select(condt);		
	}
	
	public List<ticketMang> FetchAll(){
		return tmDAO.select("");		
	}

	
}