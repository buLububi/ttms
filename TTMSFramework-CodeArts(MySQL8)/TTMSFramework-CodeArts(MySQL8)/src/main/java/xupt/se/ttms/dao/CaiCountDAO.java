package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iCaiCountDAO;
import xupt.se.ttms.model.caiCount;
import xupt.se.util.DBUtil;

public class CaiCountDAO implements iCaiCountDAO
{
    
    @SuppressWarnings("finally")
    @Override
    public List<caiCount> select(String sched)
    {
        DBUtil db=null;
        String sql="";
        List<caiCount> stuList=null;
        stuList=new LinkedList<caiCount>();
        
        try
        { 
        	if (sched.equals("")) {
            	sql="select * from play_revenue_by_type_and_language";
        	}else {
        		String play_language=String.valueOf(sched);
            	sql="select * from play_revenue_by_type_and_language where play_language ='" + play_language+"'" ;
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
                	caiCount stu=new caiCount();
                    stu.setPlay_type(rst.getString("play_type"));
                    stu.setPlay_language(rst.getString("play_language"));
                    stu.setRevenue_per_type_language(rst.getDouble("revenue_per_type_language"));
                    
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
