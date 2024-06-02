package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iticketMangDAO;
import xupt.se.ttms.model.ticketMang;
import xupt.se.util.DBUtil;

public class TicketMangDAO implements iticketMangDAO
{
    
    @SuppressWarnings("finally")
    @Override
    public List<ticketMang> select(String sched)
    {
        DBUtil db=null;
        String sql="";
        List<ticketMang> stuList=null;
        stuList=new LinkedList<ticketMang>();
        
        try
        { 
        	if (sched.equals("")) {
            	sql="select * from ticketMang";
        	}else {
        		String play_name=String.valueOf(sched);
            	sql="select * from ticketMang where play_name ='" + play_name+"'" ;
            }
            db=new DBUtil();
            if(!db.openConnection())
            {
                System.out.print("fail to connect database");
                return null;
            }
			ResultSet rst=db.execQuery(sql);
            if(rst != null)
            {
                while(rst.next())
                {
                    ticketMang stu=new ticketMang();
                    stu.setPlay_name(rst.getString("play_name"));
                    stu.setRevenue_per_play(rst.getDouble("revenue_per_play"));
                    
                    stuList.add(stu);
                }
            }
            db.close(rst);
            db.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return stuList;
        }
    }

}
