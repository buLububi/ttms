package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iSaleCountDAO;
import xupt.se.ttms.model.saleCount;

public class SaleCountSrv {
	private iSaleCountDAO tmDAO=DAOFactory.creatSaleCountDAO();
	
	
	
	public List<saleCount> Fetch(String condt){
		return tmDAO.select(condt);		
	}
	
	public List<saleCount> FetchAll(){
		return tmDAO.select("");		
	}

	
}