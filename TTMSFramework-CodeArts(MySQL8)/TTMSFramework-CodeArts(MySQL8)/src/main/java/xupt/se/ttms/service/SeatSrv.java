package xupt.se.ttms.service;

import java.util.List;


import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iSeatDAO;
import xupt.se.ttms.model.Seat;

public class SeatSrv {
	private iSeatDAO seatDAO=DAOFactory.creatSeatDAO();
	
	public int add(Seat seat){
		return seatDAO.insert(seat); 		
	}
	
	public int modify(Seat seat){
		return seatDAO.update(seat); 		
	}
	
	public int delete(int ID){
		return seatDAO.delete(ID); 		
	}
	
	public List<Seat> Fetch(int condt){
		return seatDAO.select(condt);		
	}
	
	public List<Seat> FetchAll(){
		return seatDAO.select(0);		
	}
}
