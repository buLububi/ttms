package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iCusDAO;
import xupt.se.ttms.model.Cus;
import xupt.se.util.DBUtil;

public class CusDAO implements iCusDAO
{
    @SuppressWarnings("finally")
    @Override
    public int insert(Cus cus)
    {
        int result=0;
        try
        {
        	String sql="insert into customer(cus_name,cus_gender,cus_telnum,cus_email,cus_uid,cus_pwd,cus_balance,cus_paypwd)"
                    + " values('" + cus.getName() + "', " + cus.getGender() + ", '" + cus.getTelnum() + "', '"
                    + cus.getEmail()+ "', '" + cus.getUid() + "', '" + cus.getPwd()+ "', " + cus.getBalance()
                    + ", '" + cus.getPaypwd() + "' )";
            DBUtil db=new DBUtil();
            db.openConnection();
            ResultSet rst=db.getInsertObjectIDs(sql);
            if(rst != null && rst.first())
            {
                cus.setId(rst.getInt(1));
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
    public int update(Cus cus)
    {
        int result=0;
        try
        {
        	String sql="update customer set " + " cus_name ='" + cus.getName() + "', " + " cus_gender = "
                    + cus.getGender() + ", " + " cus_telnum = '" + cus.getTelnum() + "', "
                    + " cus_email = '" + cus.getEmail()+ "', cus_uid ='" + cus.getUid() + "', " + " cus_pwd = '"
                    + cus.getPwd() + "', " + " cus_balance = " + cus.getBalance() + ",cus_paypwd = '" + cus.getPaypwd() + "'";
            sql+=" where cus_id = " + cus.getId();
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
            String sql="delete from  customer where cus_id = " + ID;
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
    public String selectcusid(int condt)
    {
        DBUtil db=null;
        String result="";
        try
        {
            String sql="select cus_name from customer  where cus_id= " + condt;
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
                    result=rst.getString("cus_name");
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
    public List<Cus> select(String cusName)
    {
        DBUtil db=null;
        List<Cus> cusList=null;
        cusList=new LinkedList<Cus>();
        try
        {
            cusName.trim();
            String sql="select * from customer where cus_name like '%" + cusName + "%'";
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
                    Cus cus=new Cus();
                    cus.setId(rst.getInt("cus_id"));
                    cus.setName(rst.getString("cus_name"));
                    cus.setGender(rst.getInt("cus_gender"));
                    cus.setTelnum(rst.getString("cus_telnum"));
                    cus.setEmail(rst.getString("cus_email"));
                    cus.setUid(rst.getString("cus_uid"));
                    cus.setPwd(rst.getString("cus_pwd"));
                    cus.setBalance(rst.getInt("cus_balance"));
                    cus.setPaypwd(rst.getString("cus_paypwd"));
                    cusList.add(cus);
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
            return cusList;
        }
    }

}