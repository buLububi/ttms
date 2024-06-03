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

import xupt.se.ttms.model.checkTicket;
import xupt.se.ttms.service.CheckTicketSrv;

@WebServlet("/CheckTicketServlet")
public class CheckTicketServlet extends HttpServlet
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
        
        
         if(type.equalsIgnoreCase("update"))
            update(request, response);
        else if(type.equalsIgnoreCase("search"))
            search(request, response);
        
    }

    
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        checkTicket stu=null;
        int ticket_id=0;
        try
        {
            ticket_id=Integer.valueOf(request.getParameter("ticket_id"));
            int seat_id=Integer.valueOf(request.getParameter("seat_id"));
            int sched_id=Integer.valueOf(request.getParameter("sched_id"));
            double ticket_price=Double.valueOf(request.getParameter("ticket_price"));
            int studio_id=Integer.valueOf(request.getParameter("studio_id"));
            int seat_row=Integer.valueOf(request.getParameter("seat_row"));
            int seat_column=Integer.valueOf(request.getParameter("seat_column"));
            String play_name=request.getParameter("play_name");
            int play_length=Integer.valueOf(request.getParameter("play_length"));
            String sched_time=request.getParameter("sched_time");
            int ticket_status=Integer.valueOf(request.getParameter("ticket_status"));
            stu=new checkTicket(ticket_id, seat_id, sched_id, ticket_price, studio_id, seat_row, seat_column, play_name, play_length, sched_time, ticket_status);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new CheckTicketSrv().modify(stu) == 1)
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
        String sched=request.getParameter("play_name");
        
        List<checkTicket> result=null;
        if(sched != null && sched.length() > 0)
            result=new CheckTicketSrv().Fetch(sched);
        else
            result=new CheckTicketSrv().FetchAll();
        String jsonStr="";
        try
        {
            JSONArray array=new JSONArray();
            JSONObject json;
            for(checkTicket s : result)
            {
                json=new JSONObject();
                json.put("ticket_id", s.getTicket_id());
                json.put("seat_id", s.getSeat_id());
                json.put("sched_id", s.getSched_id());
                json.put("ticket_price", s.getTicket_price());
                json.put("studio_id", s.getStudio_id());
                json.put("seat_row", s.getSeat_row());
                json.put("seat_column", s.getSeat_column());
                json.put("play_name", s.getPlay_name());
                json.put("play_length", s.getPlay_length());
                json.put("sched_time", s.getSched_time());
                json.put("ticket_status", s.getTicket_status());
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
