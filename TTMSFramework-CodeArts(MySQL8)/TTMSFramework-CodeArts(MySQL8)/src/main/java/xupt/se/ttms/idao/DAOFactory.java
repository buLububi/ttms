package xupt.se.ttms.idao;

import xupt.se.ttms.dao.CusDAO;
import xupt.se.ttms.dao.EmpDAO;
import xupt.se.ttms.dao.PlayDAO;
import xupt.se.ttms.dao.ResourceDAO;
import xupt.se.ttms.dao.RoleDAO;
import xupt.se.ttms.dao.SaleDAO;
import xupt.se.ttms.dao.SaleScheDAO;
import xupt.se.ttms.dao.ScheduleDAO;
import xupt.se.ttms.dao.SeatDAO;
import xupt.se.ttms.dao.StudioDAO;
import xupt.se.ttms.dao.TicketDAO;
import xupt.se.ttms.dao.TicketMangDAO;
import xupt.se.ttms.dao.saleItemDAO;

public class DAOFactory
{
    private static iStudioDAO stuDao;

    public static synchronized iStudioDAO creatStudioDAO()
    {
        if(null == stuDao)
            stuDao=new StudioDAO();
        return stuDao;
    }

private static iCusDAO cusDao;
    
    public static synchronized iCusDAO creatCusDAO()
    {
    	if(null == cusDao)
    		cusDao=new CusDAO();
    	return cusDao;
    }
	
    
    private static iEmpDAO empDao;
    public static synchronized iEmpDAO creatEmpDAO() 
    {
    	if(null == empDao)
    		empDao=new EmpDAO();
    	return empDao;
    }
    
private static iPlayDAO playDao;
    
    public static synchronized iPlayDAO creatPlayDAO()
    {
    	if(null == playDao)
    		playDao=new PlayDAO();
    	return playDao;
    }
    
    private static iSaleDAO salDao;
    public static synchronized iSaleDAO creatSaleDAO()
    {
        if(null == salDao)
            salDao=new SaleDAO();
        return salDao;
    }
    
    private static iTicketDAO ticketDao;
    public static synchronized iTicketDAO creatTicketDAO() 
    {
    	if(null == ticketDao)
    		ticketDao=new TicketDAO();
    	return ticketDao;
    }
    
    private static iScheduleDAO scheDao;
    public static synchronized iScheduleDAO creatScheduleDAO()
    {
        if(null == scheDao)
            scheDao=new ScheduleDAO();
        return scheDao;
    }
    
    private static iSeatDAO seatDao;
    public static synchronized iSeatDAO creatSeatDAO() 
    {
    	if(null == seatDao)
    		seatDao=new SeatDAO();
    	return seatDao;
    }
    
    private static iSaleScheDAO saleScheDAO;
    public static synchronized iSaleScheDAO creatSaleScheDAO() 
    {
    	if(null == saleScheDAO)
    		saleScheDAO=new SaleScheDAO();
    	return saleScheDAO;
    }
    
    private static isaleItemDAO saleItemDAO;
	public static isaleItemDAO creatSaleItemDAO() {
		if(null==saleItemDAO)
			saleItemDAO=new saleItemDAO();
		return saleItemDAO;
	}
	
	private static iRoleDAO roleDAO;
	public static iRoleDAO creatRoleDAO() {
		if(null==roleDAO)
			roleDAO=new RoleDAO();
		return roleDAO;
	}
	
	private static iResourceDAO resourceDAO;
    public static synchronized iResourceDAO creatResourceDAO() 
    {
    	if(null == resourceDAO)
    		resourceDAO=new ResourceDAO();
    	return resourceDAO;
    }
    
    private static iticketMangDAO tIticketMangDAO;
    public static synchronized iticketMangDAO creatTicketMangDAO() 
    {
    	if(null == tIticketMangDAO)
    		tIticketMangDAO=new TicketMangDAO();
    	return tIticketMangDAO;
    }
} 
 