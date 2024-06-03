package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iCheckTicketDAO;
import xupt.se.ttms.model.checkTicket;
import xupt.se.util.DBUtil;

public class CheckTicketDAO implements iCheckTicketDAO
{
    
    @SuppressWarnings("finally")
    @Override
    public int update(checkTicket stu)
    {
        int result=0;
        try
        {
        	
            String sql="update pending_tickets set" +"ticket_id="+ stu.getTicket_id()+",seat_id="+stu.getSeat_id()+",sched_id"+stu.getSched_id()+",ticket_price="+stu.getTicket_price()+",studio_id="+stu.getStudio_id()+",seat_row="+stu.getSeat_row()+",seat_column="+stu.getSeat_column()+",play_name='"+stu.getPlay_name()+"',play_length="+stu.getPlay_length()+",sched_time='"+stu.getSched_time()+ "',ticket_status="+stu.getTicket_status()+"";
            sql+=" where ticket_id = " + stu.getTicket_id();
            DBUtil db=new DBUtil();
            db.openConnection();
            result=db.execCommand(sql);
            db.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return result;
        }
    }

   
    @SuppressWarnings("finally")
    @Override
    public List<checkTicket> select(String sched)
    {
        DBUtil db=null;
        String sql;
        List<checkTicket> stuList=null;
        stuList=new LinkedList<checkTicket>();
        
        try
        { 
        	if (sched.equals("")) {
            	sql="select * from pending_tickets";
        	}else {
        		String play_name=String.valueOf(sched);
            	sql="select * from pending_tickets where play_name ='" + play_name+"'" ;
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
                    checkTicket stu=new checkTicket();
                    stu.setTicket_id(rst.getInt("ticket_id"));
                    stu.setSeat_id(rst.getInt("seat_id"));
                    stu.setSched_id(rst.getInt("sched_id"));
                    stu.setTicket_price(rst.getDouble("ticket_price"));
                    stu.setStudio_id(rst.getInt("studio_id"));
                    stu.setSeat_row(rst.getInt("seat_row"));
                    stu.setSeat_column(rst.getInt("seat_column"));
                    stu.setPlay_name(rst.getString("play_name"));
                    stu.setPlay_length(rst.getInt("play_length"));
                    stu.setSched_time(rst.getString("sched_time"));
                    stu.setTicket_status(rst.getInt("ticket_status"));
                    
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
