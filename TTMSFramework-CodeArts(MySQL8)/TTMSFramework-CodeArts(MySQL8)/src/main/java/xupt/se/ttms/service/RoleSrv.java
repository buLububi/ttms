package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iRoleDAO;
import xupt.se.ttms.model.Role;

public class RoleSrv {
	private iRoleDAO roleDAO=DAOFactory.creatRoleDAO();
	
	public int add(Role role){
		return roleDAO.insert(role); 		
	}
	
	public int modify(Role role){
		return roleDAO.update(role); 		
	}
	
	public int delete(int ID){
		return roleDAO.delete(ID); 		
	}
	
	public List<Role> Fetch(String condt){
		return roleDAO.select(condt);		
	}
	
	public List<Role> FetchAll(){
		return roleDAO.select("");		
	}

	
}