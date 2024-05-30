package xupt.se.ttms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import xupt.se.ttms.model.Emp;
import xupt.se.ttms.service.EmpSrv;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet
{
    private static final long serialVersionUID=1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String type=request.getParameter("type");

      //根据请求操作类型，执行相应的增、删、该、查
        if(type.equalsIgnoreCase("add"))
            add(request, response);
        else if(type.equalsIgnoreCase("delete"))
            delete(request, response);
        else if(type.equalsIgnoreCase("update"))
            update(request, response);
        else if(type.equalsIgnoreCase("search"))
            search(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Emp employee=null;
        int emp_id=0; 
        try
        {	
        	
        	int dict_id=Integer.valueOf(request.getParameter("dict_id"));
        	String emp_no=request.getParameter("emp_no");
            String emp_name=request.getParameter("emp_name");
            int emp_gender=Integer.valueOf(request.getParameter("emp_gender"));
            String emp_telnum=request.getParameter("emp_telnum");
            String emp_email=request.getParameter("emp_email");
            String emp_pwd=request.getParameter("emp_pwd");
            employee=new Emp(emp_id, dict_id, emp_no, emp_name, emp_gender,emp_telnum,emp_email,emp_pwd);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new EmpSrv().add(employee) == 1)
                out.write("数据添加成功");
            else
                out.write("数据添加失败，请重试");

            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("操作错误，请重试");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            int emp_id=Integer.valueOf(request.getParameter("emp_id"));
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.write("" + new EmpSrv().delete(emp_id));
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("操作错误，请重试");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Emp employee=null;
        int emp_id=0;
        try
        {
            emp_id=Integer.valueOf(request.getParameter("emp_id"));
            int dict_id=Integer.valueOf(request.getParameter("dict_id"));
        	String emp_no=request.getParameter("emp_no");
            String emp_name=request.getParameter("emp_name");
            int emp_gender=Integer.valueOf(request.getParameter("emp_gender"));
            String emp_telnum=request.getParameter("emp_telnum");
            String emp_email=request.getParameter("emp_email");
            String emp_pwd=request.getParameter("emp_pwd");
            employee=new Emp(emp_id, dict_id, emp_no, emp_name, emp_gender,emp_telnum,emp_email,emp_pwd);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new EmpSrv().modify(employee) == 1)
                out.write("数据修改成功");
            else
                out.write("数据修改失败，请重试");

            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("操作错误，请重试");
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        String emp_name=request.getParameter("emp_name");
        List<Emp> result=null;
        if(emp_name != null && emp_name.length() > 0)
            result=new EmpSrv().Fetch(emp_name);
        else
            result=new EmpSrv().FetchAll();
        String jsonStr="";
        try
        {
            JSONArray array=new JSONArray();
            JSONObject json;
            for(Emp s : result)
            {	
            	
                json=new JSONObject();
                json.put("emp_id", s.getEmp_id());
                json.put("dict_id", s.getDict_id());
                json.put("emp_no", s.getEmp_no());
                json.put("emp_name", s.getEmp_name());
                json.put("emp_gender", s.getEmp_gender());
                json.put("emp_telnum", s.getEmp_telnum());
                json.put("emp_email", s.getEmp_email());
                json.put("emp_pwd", s.getEmp_pwd());
                array.put(json);
            }
            jsonStr=array.toString();
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
        finally
        {
            out.println(jsonStr);
            out.flush();
            out.close();
        }
        // System.out.print(jsonStr);
    }

}
