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

import xupt.se.ttms.model.Sale;
import xupt.se.ttms.service.SaleSrv;

@WebServlet("/SaleServlet")
public class SaleServlet extends HttpServlet
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
        Sale sal=null;
        int sale_ID=0;
        try
        {
        	int emp_id=Integer.valueOf(request.getParameter("emp_id"));
        	int cus_id=Integer.valueOf(request.getParameter("cus_id"));
            String sale_time=request.getParameter("sale_time");
            double sale_payment=Double.valueOf(request.getParameter("sale_payment"));
            double sale_change=Double.valueOf(request.getParameter("sale_change"));
            int sale_type=Integer.valueOf(request.getParameter("sale_type"));
            int sale_status=Integer.valueOf(request.getParameter("sale_status"));
            int sale_sort=Integer.valueOf(request.getParameter("sale_sort"));
            sal=new Sale(sale_ID, emp_id, cus_id, sale_time, sale_payment,sale_change,sale_type,sale_status,sale_sort);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new SaleSrv().add(sal) == 1)
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
            int sale_ID=Integer.valueOf(request.getParameter("sale_ID"));
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.write("" + new SaleSrv().delete(sale_ID));
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
        Sale sal=null;
        int sale_ID=0;
        try
        {
        	sale_ID=Integer.valueOf(request.getParameter("sale_ID"));
        	int emp_id=Integer.valueOf(request.getParameter("emp_id"));
        	int cus_id=Integer.valueOf(request.getParameter("cus_id"));
            String sale_time=request.getParameter("sale_time");
            double sale_payment=Double.valueOf(request.getParameter("sale_payment"));
            double sale_change=Double.valueOf(request.getParameter("sale_change"));
            int sale_type=Integer.valueOf(request.getParameter("sale_type"));
            int sale_status=Integer.valueOf(request.getParameter("sale_status"));
        	int sale_sort=Integer.valueOf(request.getParameter("sale_sort"));
            sal=new Sale(sale_ID, emp_id, cus_id, sale_time, sale_payment,sale_change,sale_type,sale_status,sale_sort);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new SaleSrv().modify(sal) == 1)
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
        String cus_id=request.getParameter("cus_id");
        List<Sale> result=null;
        if(cus_id != null && cus_id.length() > 0)
            result=new SaleSrv().Fetch(cus_id);
        else
            result=new SaleSrv().FetchAll();
        String jsonStr="";
        try
        {
            JSONArray array=new JSONArray();
            JSONObject json;
            for(Sale s : result)
            {
                json=new JSONObject();
                json.put("sale_ID", s.getSaleId());
                json.put("emp_id", s.getEmpId());
                json.put("cus_id", s.getCusId());
                json.put("sale_time", s.getTime());
                json.put("sale_payment", s.getPayment());
                json.put("sale_change", s.getChange());
                json.put("sale_type", s.getType());
                json.put("sale_status", s.getStatus());
                json.put("sale_sort", s.getSort());
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
         System.out.print(jsonStr);
    }

}
