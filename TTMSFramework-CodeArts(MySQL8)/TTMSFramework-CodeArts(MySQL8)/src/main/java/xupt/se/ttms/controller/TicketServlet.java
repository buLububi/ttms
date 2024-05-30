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

import xupt.se.ttms.model.Ticket;
import xupt.se.ttms.service.TicketSrv;

@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet
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
        Ticket stu=null;
        int ticket_id=0;
        try
        {
        	
        	int seat_id = Integer.valueOf(request.getParameter("seat_id"));
        	int sched_id = Integer.valueOf(request.getParameter("sched_id"));
        	// Java 中没有 smallint 类型，这里假设 ticket_price 是 float 或者 int
        	// 如果 ticket_price 是来自数据库的 decimal 类型，建议使用 BigDecimal
        	double ticket_price=Double.valueOf(request.getParameter("ticket_price"));
        	int ticket_status = Integer.valueOf(request.getParameter("ticket_status"));
        	// Java 中没有 decimal 类型，如果 ticket_status 是小数，建议使用 float 或 double
        	String ticket_locktime = request.getParameter("ticket_locktime");

        	// 假设 Ticket 类的构造函数接受的参数顺序与 Cus 类似
        	 stu = new Ticket(ticket_id, seat_id, sched_id, ticket_price, ticket_status, ticket_locktime);
        	
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new TicketSrv().add(stu) == 1)
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
            int ticket_id=Integer.valueOf(request.getParameter("ticket_id"));
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.write("" + new TicketSrv().delete(ticket_id));
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
        Ticket stu=null;
        int ticket_id=0;
        try
        {
            ticket_id=Integer.valueOf(request.getParameter("ticket_id"));
            int seat_id=Integer.valueOf(request.getParameter("seat_id"));
            int sched_id=Integer.valueOf(request.getParameter("sched_id"));
            double ticket_price=Double.valueOf(request.getParameter("ticket_price"));
            int ticket_status=Integer.valueOf(request.getParameter("ticket_status"));
            String ticket_locktime=request.getParameter("ticket_locktime");
            stu=new Ticket(ticket_id, seat_id, sched_id, ticket_price, ticket_status,ticket_locktime);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new TicketSrv().modify(stu) == 1)
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
        String sched=request.getParameter("sched_id");
        
        List<Ticket> result=null;
        if(sched != null && sched.length() > 0)
            result=new TicketSrv().Fetch(sched);
        else
            result=new TicketSrv().FetchAll();
        String jsonStr="";
        try
        {
            JSONArray array=new JSONArray();
            JSONObject json;
            for(Ticket s : result)
            {
                json=new JSONObject();
                json.put("ticket_id", s.getTicket_id());
                json.put("seat_id", s.getSeat_id());
                json.put("sched_id", s.getSched_id());
                json.put("ticket_price", s.getTicket_price());
                json.put("ticket_status", s.getTicket_status());
                json.put("ticket_locktime", s.getTicket_locktime());
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
