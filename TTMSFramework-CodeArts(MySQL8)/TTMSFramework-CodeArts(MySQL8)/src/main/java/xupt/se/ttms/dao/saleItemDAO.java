package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iTicketDAO;
import xupt.se.ttms.idao.isaleItemDAO;
import xupt.se.ttms.model.Ticket;
import xupt.se.ttms.model.saleItem;
import xupt.se.util.DBUtil;

public class saleItemDAO implements isaleItemDAO
{
    @SuppressWarnings("finally")
    @Override
    public int insert(saleItem stu)
    {
        int result=0;
        
        try
        {
        
        	String sql="insert into sale_item(ticket_id, sale_ID, sale_item_price)"
                            + " values(" + stu.getTicket_id() + ", " + stu.getSale_ID() + ", " + stu.getSale_item_price() + " )";
        
        	DBUtil db=new DBUtil();
            db.openConnection();
            ResultSet rst=db.getInsertObjectIDs(sql);
            if(rst != null && rst.first())
            {
                stu.setSale_item_id(rst.getInt(1));
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
    public int update(saleItem stu)
    {
        int result=0;
        try
        {
            String sql="update sale_item set" + " ticket_id =" + stu.getTicket_id() + ", " + " sale_ID = "
                    + stu.getSale_ID() + ", " + " sale_item_price = " + stu.getSale_item_id() + "";
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
            String sql="delete from  sale_item where ticket_id = " + ID;
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
            String sql="select ticket_id from ticket  where ticket_id= " + condt;
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
                    result=rst.getString("ticket_id");
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
    public List<saleItem> select(String sched)
    {
        DBUtil db=null;
        String sql;
        List<saleItem> stuList=null;
        stuList=new LinkedList<saleItem>();
        
        try
        { 
        	if (sched.equals("")) {
            	sql="select * from sale_item";
        	}else {
        		int ticket_id=Integer.valueOf(sched);
            	sql="select * from sale_item where ticket_id =" + ticket_id ;
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
                    saleItem stu=new saleItem();
                    stu.setSale_item_id(rst.getInt("sale_item_id"));
                    stu.setTicket_id(rst.getInt("ticket_id"));
                    stu.setSale_ID(rst.getInt("sale_ID"));
                    stu.setSale_item_price(rst.getDouble("sale_item_price"));
                    
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
