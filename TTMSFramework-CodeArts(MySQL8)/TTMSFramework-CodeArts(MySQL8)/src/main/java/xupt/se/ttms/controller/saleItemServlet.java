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

import xupt.se.ttms.model.saleItem;
import xupt.se.ttms.service.saleItemSrv;

@WebServlet("/saleItemServlet")
public class saleItemServlet extends HttpServlet
{
    private static final long serialVersionUID=1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String type=request.getParameter("type");

        // 根据请求操作类型，执行相应的增、删、该、查
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
        saleItem stu=null;
        int sale_item_id=0;
        try
        {

        	int ticket_id = Integer.valueOf(request.getParameter("ticket_id"));
        	int sale_ID = Integer.valueOf(request.getParameter("sale_ID"));
        	double sale_item_price=Double.valueOf(request.getParameter("sale_item_price"));

        	 stu = new saleItem(sale_item_id, ticket_id, sale_ID, sale_item_price);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new saleItemSrv().add(stu) == 1)
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
            int sale_item_id=Integer.valueOf(request.getParameter("sale_item_id"));
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.write("" + new saleItemSrv().delete(sale_item_id));
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
        saleItem stu=null;
        int sale_item_id=0;
        try
        {
            sale_item_id=Integer.valueOf(request.getParameter("sale_item_id"));
            int ticket_id=Integer.valueOf(request.getParameter("ticket_id"));
            int sale_ID=Integer.valueOf(request.getParameter("sale_ID"));
            double sale_item_price=Double.valueOf(request.getParameter("sale_item_price"));
            stu=new saleItem(sale_item_id, ticket_id, sale_ID, sale_item_price);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new saleItemSrv().modify(stu) == 1)
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
        String sched=request.getParameter("ticket_id");

        List<saleItem> result=null;
        if(sched != null && sched.length() > 0)
            result=new saleItemSrv().Fetch(sched);
        else
            result=new saleItemSrv().FetchAll();
        String jsonStr="";
        try
        {
            JSONArray array=new JSONArray();
            JSONObject json;
            for(saleItem s : result)
            {
                json=new JSONObject();
                json.put("sale_item_id", s.getSale_item_id());
                json.put("ticket_id", s.getTicket_id());
                json.put("sale_ID", s.getSale_ID());
                json.put("sale_item_price", s.getSale_item_price());
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