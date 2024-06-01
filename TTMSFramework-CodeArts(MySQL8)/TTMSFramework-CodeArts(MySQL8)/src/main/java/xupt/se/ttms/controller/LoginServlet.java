package xupt.se.ttms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xupt.se.ttms.model.Emp;
import xupt.se.ttms.service.EmpSrv;
import xupt.se.ttms.service.LoginSrv;

public class LoginServlet extends HttpServlet{

	   private static final long serialVersionUID=1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {
	        doPost(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {
	    	  try
	          {	
	          	
	              String emp_name=request.getParameter("emp_name");
	              String emp_pwd=request.getParameter("emp_pwd");
	              LoginSrv loginSrv =new LoginSrv();
	              Emp employee =loginSrv.login(emp_name,emp_pwd);
	              if(employee!=null)
	              {
	            	  HttpSession session =request.getSession();
	                  session.setAttribute("employee",employee);
	                  response.sendRedirect(request.getContextPath()+"/admin/studio/index.html");
	              }
	              else
	              {
	            	  
	              }
	              

	       
	          }
	          catch(Exception e)
	          {
	        	  
	          }

	  
	    }


}
