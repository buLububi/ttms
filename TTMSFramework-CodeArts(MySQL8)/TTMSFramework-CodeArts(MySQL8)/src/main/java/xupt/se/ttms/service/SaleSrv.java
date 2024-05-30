package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iSaleDAO;
import xupt.se.ttms.model.Sale;

public class SaleSrv {
	private iSaleDAO salDAO=DAOFactory.creatSaleDAO();
	
	public int add(Sale sal){
		return salDAO.insert(sal); 		
	}
	
	public int modify(Sale sal){
		return salDAO.update(sal); 		
	}
	
	public int delete(int ID){
		return salDAO.delete(ID); 		
	}
	
	public List<Sale> Fetch(String cus_id){
		return salDAO.select(cus_id);		
	}
	
	public List<Sale> FetchAll(){
		return salDAO.select("");		
	}
}