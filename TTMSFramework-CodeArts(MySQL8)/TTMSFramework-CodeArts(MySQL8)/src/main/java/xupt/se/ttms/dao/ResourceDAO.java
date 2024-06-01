package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iResourceDAO;
import xupt.se.ttms.model.Resource;
import xupt.se.util.DBUtil;

public class ResourceDAO implements  iResourceDAO
{
    @SuppressWarnings("finally")
    @Override
    public int insert(Resource stu)
    {
        int result=0;
        
        try
        {
        
        	String sql="insert into resource(res_parent, res_name, res_URL)"
                            + " values('" + stu.getRes_parent() + "', '" + stu.getRes_name() + "', '" + stu.getRes_URL() + "' )";
        
        	DBUtil db=new DBUtil();
            db.openConnection();
            ResultSet rst=db.getInsertObjectIDs(sql);
            if(rst != null && rst.first())
            {
                stu.setRes_id(rst.getInt(1));
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
    public int update(Resource stu)
    {
        int result=0;
        try
        {
            String sql="update resource set" + " res_parent ='" + stu.getRes_parent() + "', " + " res_name = '"
                    + stu.getRes_name() + "', " + " res_URL = '" + stu.getRes_URL() + "'";
            sql+=" where res_id = " + stu.getRes_id();
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
            String sql="delete from  resource where res_id = " + ID;
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
    public List<Resource> select(String sched)
    {
        DBUtil db=null;
        String sql;
        List<Resource> stuList=null;
        stuList=new LinkedList<Resource>();
        
        try
        { 
        	if (sched.equals("")) {
            	sql="select * from resource";
        	}else {
        		String res_name=String.valueOf(sched);
            	sql="select * from resource where res_name ='" + res_name+"'" ;
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
                	Resource stu=new Resource();
                    stu.setRes_id(rst.getInt("res_id"));
                    stu.setRes_parent(rst.getString("res_parent"));
                    stu.setRes_name(rst.getString("res_name"));
                    stu.setRes_URL(rst.getString("res_URL"));
                    
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
