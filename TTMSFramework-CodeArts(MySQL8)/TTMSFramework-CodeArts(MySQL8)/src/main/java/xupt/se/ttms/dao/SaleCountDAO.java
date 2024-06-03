package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iSaleCountDAO;
import xupt.se.ttms.model.saleCount;
import xupt.se.util.DBUtil;

public class SaleCountDAO implements iSaleCountDAO
{
    
    @SuppressWarnings("finally")
    @Override
    public List<saleCount> select(String sched)
    {
        DBUtil db=null;
        String sql="";
        List<saleCount> stuList=null;
        stuList=new LinkedList<saleCount>();
        
        try
        { 
        	if (sched.equals("")) {
            	sql="select * from employee_sales_performance";
        	}else {
        		String emp_name=String.valueOf(sched);
            	sql="select * from employee_sales_performance where emp_name ='" + emp_name+"'" ;
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
                	saleCount stu=new saleCount();
                    stu.setEmp_name(rst.getString("emp_name"));
                    stu.setSales_performance(rst.getDouble("sales_performance"));
                    
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
