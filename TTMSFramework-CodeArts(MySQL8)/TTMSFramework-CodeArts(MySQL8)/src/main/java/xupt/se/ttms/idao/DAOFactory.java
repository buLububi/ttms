package xupt.se.ttms.idao;

import xupt.se.ttms.dao.CusDAO;
import xupt.se.ttms.dao.StudioDAO;

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
	
} 
 