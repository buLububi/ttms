package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iEmpDAO;
import xupt.se.ttms.model.Emp;
import xupt.se.util.DBUtil;

public class EmpDAO implements iEmpDAO
{
    @SuppressWarnings("finally")
    @Override
    
    public int insert(Emp employee)
    {
    	int result=0;
        try
        {
        	
            String sql="insert into employee(emp_no, emp_name, emp_gender, emp_telnum, emp_email, emp_pwd)"
                    + " values('" + employee.getEmp_no() + "', '"+ employee.getEmp_name() + "'," + employee.getEmp_gender() + ", '" + employee.getEmp_telnum() + "', '"
                    + employee.getEmp_email() + "','" + employee.getEmp_pwd() +"' )";
            DBUtil db=new DBUtil();
            db.openConnection();
            ResultSet rst=db.getInsertObjectIDs(sql);
            if(rst != null && rst.first())
            {
                employee.setEmp_id(rst.getInt(1));
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
    public int update(Emp employee)
    {
    	int result=0;
        try
        {
        	String sql="update employee set" + " emp_no ='" + employee.getEmp_no() + "'," + " emp_name = '"
                    + employee.getEmp_name() + "'," + " emp_gender = "
                    + employee.getEmp_gender() + "," + " emp_telnum = '"
                    + employee.getEmp_telnum() + "'," + " emp_email = '"
        			+ employee.getEmp_email() + "'," + "emp_pwd = '" 
                    + employee.getEmp_pwd() + "'";
            sql+=" where emp_id = " + employee.getEmp_id();
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
    public int delete(int emp_id)
    {
        int result=0;
        try
        {
            String sql="delete from  employee where emp_id = " + emp_id;
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
    public String selectemp_id(int condt)
    {
        DBUtil db=null;
        String result="";
        try
        {
            String sql="select emp_name from employee  where emp_id= " + condt;
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
                    result=rst.getString("emp_name");
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
    public List<Emp> select(String emp_name)
    {
        DBUtil db=null;
        List<Emp> employeeList=null;
        employeeList=new LinkedList<Emp>();
        try
        {
            emp_name.trim();
            String sql="select * from employee where emp_name like '%" + emp_name + "%'";
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
                    Emp employee=new Emp();
                    employee.setEmp_id(rst.getInt("emp_id"));
                    employee.setDict_id(rst.getInt("dict_id"));
                    employee.setEmp_no(rst.getString("emp_no"));
                    employee.setEmp_name(rst.getString("emp_name"));
                    employee.setEmp_gender(rst.getInt("emp_gender"));
                    employee.setEmp_telnum(rst.getString("emp_telnum"));
                    employee.setEmp_email(rst.getString("emp_email"));
                    employee.setEmp_pwd(rst.getString("emp_pwd"));
                    employeeList.add(employee);
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
            return employeeList;
        }
    }
    public Emp  Loginselect(String emp_name)
    {
        DBUtil db=null;
        Emp employee=new Emp();
        try
        {
            emp_name.trim();
            String sql="select * from employee where emp_name like '%" + emp_name + "%'";
            db=new DBUtil();
            if(!db.openConnection())
            {
                System.out.print("fail to connect database");
              
            }
            ResultSet rst=db.execQuery(sql);
            if(rst != null)
            {
                while(rst.next())
                {
                   
                    employee.setEmp_id(rst.getInt("emp_id"));
                    employee.setDict_id(rst.getInt("dict_id"));
                    employee.setEmp_no(rst.getString("emp_no"));
                    employee.setEmp_name(rst.getString("emp_name"));
                    employee.setEmp_gender(rst.getInt("emp_gender"));
                    employee.setEmp_telnum(rst.getString("emp_telnum"));
                    employee.setEmp_email(rst.getString("emp_email"));
                    employee.setEmp_pwd(rst.getString("emp_pwd"));
                  
                }
            }
            db.close(rst);
            db.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
            return  employee;
        
    }

}
