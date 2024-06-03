package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iCaiCountDAO;
import xupt.se.ttms.model.caiCount;

public class CaiCountSrv {
	private iCaiCountDAO tmDAO=DAOFactory.creatCaiCountDAO();
	
	
	
	public List<caiCount> Fetch(String condt){
		return tmDAO.select(condt);		
	}
	
	public List<caiCount> FetchAll(){
		return tmDAO.select("");		
	}

	
}