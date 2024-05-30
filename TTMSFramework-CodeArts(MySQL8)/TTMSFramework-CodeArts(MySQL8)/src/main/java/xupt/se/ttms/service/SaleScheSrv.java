package xupt.se.ttms.service;


import java.util.List;

//import xupt.se.ttms.dao.AdminDAO;
//import xupt.se.ttms.dao.UserDAO;
import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iSaleScheDAO;
import xupt.se.ttms.model.SaleSche;

public class SaleScheSrv {
	private iSaleScheDAO saleScheDAO = DAOFactory.creatSaleScheDAO();
	

	public List<SaleSche> Fetch(String condt){
		return saleScheDAO.select(condt);		
	}
	
	public List<SaleSche> FetchAll(){
		return saleScheDAO.select("");		
	}
}
