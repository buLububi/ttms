package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iSaleDAO;
import xupt.se.ttms.model.Sale;
import xupt.se.util.DBUtil;

public class SaleDAO implements iSaleDAO
{
    @SuppressWarnings("finally")
    @Override
    
    public int insert(Sale sal)
    {

        int result=0;
        try
        {

        	String sql="insert into sale(emp_id, cus_id, sale_time, sale_payment, sale_change, sale_type, sale_status, sale_sort )"
                    + " values(" 
        			+ sal.getEmpId() + ", " 
                    + sal.getCusId() + ", '" 
                    + sal.getTime() + "', "
                    + sal.getPayment()+ ", " 
        			+ sal.getChange() + ", " 
                    + sal.getType()+ ", " 
        			+ sal.getStatus()+ ", " 
                    + sal.getSort() + " )";
            DBUtil db=new DBUtil();
            db.openConnection();
            ResultSet rst=db.getInsertObjectIDs(sql);
            if(rst != null && rst.first())
            {
                sal.setSaleId(rst.getInt(1));
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
    public int update(Sale sal)
    {
        int result=0;
        try
        {
            String sql="update sale set " 
            		+ " emp_id =" + sal.getEmpId() + "," 
            		+ " cus_id = "+ sal.getCusId() + "," 
            		+ " sale_time = '" + sal.getTime() + "',"
                    + " sale_payment =" + sal.getPayment() + ","
                    + " sale_change =" + sal.getChange() + "," 
                    + " sale_type = "+ sal.getType() + "," 
                    + " sale_status = " + sal.getStatus() + ","
                    + " sale_sort = " + sal.getSort() + "";
            sql+=" where sale_ID = " + sal.getSaleId();
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
            String sql="delete from  sale where sale_ID = " + ID;
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
            String sql="select emp_id from sale  where sale_ID= " + condt;
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
                	result=rst.getInt("emp_id");
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
    public List<Sale> select(String cus_id)
    {
        DBUtil db=null;
        List<Sale> salList=null;
        salList=new LinkedList<Sale>();
        try
        {
        	cus_id.trim();
            String sql="select * from sale where cus_id like '%" + cus_id + "%'";
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
                    Sale sal=new Sale();
                    sal.setSaleId(rst.getInt("sale_ID"));
                    sal.setEmpId(rst.getInt("emp_id"));
                    sal.setCusId(rst.getInt("cus_id"));
                    sal.setTime(rst.getString("sale_time"));
                    sal.setPayment(rst.getDouble("sale_payment"));
                    sal.setChange(rst.getDouble("sale_change"));
                    sal.setType(rst.getInt("sale_type"));
                    sal.setStatus(rst.getInt("sale_status"));
                    sal.setSort(rst.getInt("sale_sort"));
                    salList.add(sal);
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
            return salList;
        }
    }

}
