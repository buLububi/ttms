package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iRoleDAO;
import xupt.se.ttms.model.Role;
import xupt.se.util.DBUtil;

public class RoleDAO implements iRoleDAO {
	@SuppressWarnings("finally")
    @Override
    public int insert(Role stu)
    {
        int result=0;
        
        try
        {
        
        	String sql="insert into roles(role_name)"
                      + " values('"  + stu.getRole_name() +"' )";
        
        	DBUtil db=new DBUtil();
            db.openConnection();
            ResultSet rst=db.getInsertObjectIDs(sql);
            if(rst != null && rst.first())
            {
                stu.setRole_id(rst.getInt(1));
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
    public int update(Role stu)
    {
        int result=0;
        try
        {
            String sql="update roles set " + " role_name ='" + stu.getRole_name() +"'";
            sql+=" where role_id = " + stu.getRole_id();
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
            String sql="delete from  roles where role_id = " + ID;
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
    public List<Role> select(String sched)
    {
        DBUtil db=null;
        String sql;
        List<Role> stuList=null;
        stuList=new LinkedList<Role>();
        
        try
        { 
        	if (sched.equals("")) {
            	sql="select * from roles";
        	}else {
        		String role_name=String.valueOf(sched);
            	sql="select * from roles where role_name ='" + role_name+"'" ;
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
                    Role stu=new Role();
                    stu.setRole_id(rst.getInt("role_id"));
                    stu.setRole_name(rst.getString("role_name"));
                    
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
