package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iTicketDAO;
import xupt.se.ttms.model.Ticket;
import xupt.se.util.DBUtil;

public class TicketDAO implements iTicketDAO
{
    @SuppressWarnings("finally")
    @Override
    public int insert(Ticket stu)
    {
        int result=0;
        
        try
        {
        
        	String sql="insert into ticket(seat_id, sched_id, ticket_price, ticket_status ,ticket_locktime)"
                            + " values(" + stu.getSeat_id() + ", " + stu.getSched_id() + ", " + stu.getTicket_price() + ", "
                            + stu.getTicket_status() + ",'"+stu.getTicket_locktime()+"' )";
        
        	DBUtil db=new DBUtil();
            db.openConnection();
            ResultSet rst=db.getInsertObjectIDs(sql);
            if(rst != null && rst.first())
            {
                stu.setTicket_id(rst.getInt(1));
            }
            db.close(rst);
            db.close();
            result=1;
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
    public int update(Ticket stu)
    {
        int result=0;
        try
        {
            String sql="update ticket set" + " seat_id =" + stu.getSeat_id() + ", " + " sched_id = "
                    + stu.getSched_id() + ", " + " ticket_price = " + stu.getTicket_price() + ", "
                    + " ticket_status = " + stu.getTicket_status() + ", "+"ticket_locktime='"+stu.getTicket_locktime()+"'";
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

    @Override
    public int delete(int ID)
    {
        int result=0;
        try
        {
            String sql="delete from  ticket where ticket_id = " + ID;
            DBUtil db=new DBUtil();
            db.openConnection();
            result=db.execCommand(sql);
            db.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    @SuppressWarnings("finally")
    public int selectstudioid(int condt)
    {
        DBUtil db=null;
        int result=0;
        try
        {
            String sql="select studio_id from schedule  where sched_id= " + condt;
            db=new DBUtil();
            if(!db.openConnection())
            {
                System.out.print("fail to connect database");
                return 0;
            }
            ResultSet rst=db.execQuery(sql);
            if(rst != null)
            {
                while(rst.next())
                {
                    result=rst.getInt("studio_id");
                    System.out.println(result);
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
            return result;
        }
    }

    @SuppressWarnings("finally")
    public String selectticketid(int condt)
    {
        DBUtil db=null;
        String result="";
        try
        {
            String sql="select sched_id from ticket  where ticket_id= " + condt;
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
                    result=rst.getString("sched_id");
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
            return result;
        }
    }

    @SuppressWarnings("finally")
    @Override
    public List<Ticket> select(String sched)
    {
        DBUtil db=null;
        String sql;
        List<Ticket> stuList=null;
        stuList=new LinkedList<Ticket>();
        
        try
        { 
        	if (sched.equals("")) {
            	sql="select * from ticket";
        	}else {
        		int sched_id=Integer.valueOf(sched);
            	sql="select * from ticket where sched_id =" + sched_id ;
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
                    Ticket stu=new Ticket();
                    stu.setTicket_id(rst.getInt("ticket_id"));
                    stu.setSeat_id(rst.getInt("seat_id"));
                    stu.setSched_id(rst.getInt("sched_id"));
                    stu.setTicket_price(rst.getDouble("ticket_price"));
                    stu.setTicket_status(rst.getInt("ticket_status"));
                    stu.setTicket_locktime(rst.getString("ticket_locktime"));
                    
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
