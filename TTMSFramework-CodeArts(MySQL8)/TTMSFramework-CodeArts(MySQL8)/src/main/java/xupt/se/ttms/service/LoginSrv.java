package xupt.se.ttms.service;

import xupt.se.ttms.dao.EmpDAO;
import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iEmpDAO;
import xupt.se.ttms.model.Emp;
import xupt.se.util.DBUtil;

public class LoginSrv {
	private iEmpDAO EmpDAO = DAOFactory.creatEmpDAO();
	public Emp login(String emp_name,String emp_pwd)
	{
		 DBUtil db=null;
		 Emp employee = null;
	        try {
	        	 db=new DBUtil();
	             if(!db.openConnection())
	             {
	                 System.out.print("fail to connect database");
	                 return null;
	             }
	            Emp temp=EmpDAO.Loginselect(emp_name);
	            if(temp!=null){
	                if(temp.getEmp_pwd().equals(emp_pwd)){
	                    employee=temp;
	                    System.out.println("登录成功！");
	                }else {
	                    System.out.println("登录失败！");
	                }
	            
	            }
	            db.close();
	        } 
	       
	        catch (Exception e) {
	      
	            e.printStackTrace();
	        }
	        return employee;
	    }
		
	}

