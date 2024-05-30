package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iEmpDAO;
import xupt.se.ttms.model.Emp;

public class EmpSrv {
	
	private iEmpDAO empDAO=DAOFactory.creatEmpDAO();
	
	public int add(Emp emp){
		return empDAO.insert(emp); 		
	}
	
	public int modify(Emp emp){
		return empDAO.update(emp); 		
	}
	
	public int delete(int ID){
		return empDAO.delete(ID); 		
	}
	
	public List<Emp> Fetch(String condt){
		return empDAO.select(condt);		
	}
	
	public List<Emp> FetchAll(){
		return empDAO.select("");		
	}

}
