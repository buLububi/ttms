package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iCusDAO;
import xupt.se.ttms.model.Cus;

public class CusSrv {
	private iCusDAO cusDAO=DAOFactory.creatCusDAO();
	
	public int add(Cus cus){
		return cusDAO.insert(cus); 		
	}
	
	public int modify(Cus cus){
		return cusDAO.update(cus); 		
	}
	
	public int delete(int ID){
		return cusDAO.delete(ID); 		
	}
	
	public List<Cus> Fetch(String condt){
		return cusDAO.select(condt);		
	}
	
	public List<Cus> FetchAll(){
		return cusDAO.select("");		
	}
}
