package xupt.se.ttms.dao;

import java.sql.ResultSet;

import java.util.LinkedList;
import java.util.List;

//import xupt.se.ttms.idao.iAdminDAO;
import xupt.se.ttms.idao.iSaleScheDAO;
//import xupt.se.ttms.model.Admin;
import xupt.se.ttms.model.SaleSche;
import xupt.se.util.DBUtil;

public class SaleScheDAO implements iSaleScheDAO
{
	@SuppressWarnings("finally")
	public String selectplayid(int condt)
	{
		DBUtil db = null;
		String result = "";
		try
		{
			String sql = "select  s1. sched_time,s2.studio_name, s1.sched_ticket_price  from schedule s1, studio s2 where  s1.play_id = 2 and s1.studio_id = s2.studio_id = " + condt;
			db = new DBUtil();
			if(!db.openConnection())
			{
				System.out.print("fail to connect database   1234567xwl");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			if(rst != null)
			{
				while(rst.next())
				{
					result = rst.getNString("studio_name");
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
	public List<SaleSche> select(String play_id) {
		DBUtil db=null;
        List<SaleSche> saleScheList=null;
        saleScheList=new LinkedList<SaleSche>();
        try
        {
        	play_id.trim();
            String sql=
            "select  s1. sched_time,s2.studio_name, s1.sched_ticket_price, s2.studio_id  from schedule s1, studio s2 where play_id like '%" + play_id + "%' and s1.studio_id = s2.studio_id";
            db=new DBUtil();
            if(!db.openConnection())
            {
                System.out.print("fail to connect database  xwl123");
                return null;
            }
            ResultSet rst=db.execQuery(sql);
            if(rst != null)
            {
            	//System.out.println("124567");
                while(rst.next())
                {
                	System.out.println("here");
                	//System.out.println(rst.getString("studio_name"));
                    SaleSche salesche =new SaleSche();
                    salesche.setStudio_name(rst.getString("studio_name"));
                    salesche.setSchedule_time(rst.getString("sched_time"));
                    salesche.setSchedule_price(rst.getFloat("sched_ticket_price"));
                    salesche.setStudio_id(rst.getInt("studio_id"));
                    saleScheList.add(salesche);
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
            return saleScheList;
        }
    }
}