package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.isaleItemDAO;
import xupt.se.ttms.model.Ticket;
import xupt.se.ttms.model.saleItem;

public class saleItemSrv {
	private isaleItemDAO saleItemDAO=DAOFactory.creatSaleItemDAO();
	
	public int add(saleItem stu){
		return saleItemDAO.insert(stu); 		
	}
	
	public int modify(saleItem stu){
		return saleItemDAO.update(stu); 		
	}
	
	public int delete(int ID){
		return saleItemDAO.delete(ID); 		
	}
	public List<saleItem> Fetch(String name){
		return saleItemDAO.select(name);		
	}
	
	public List<saleItem> FetchAll(){
		return saleItemDAO.select("");		
	}

}
