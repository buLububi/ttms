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

import xupt.se.ttms.model.Schedule;
import xupt.se.ttms.model.Studio;
import xupt.se.ttms.service.ScheduleSrv;
import xupt.se.ttms.service.StudioSrv;

@SuppressWarnings("unused")
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet
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
        Schedule sche=null;
        int sched_id=0;
        try
        {
            String show_time=request.getParameter("time");
            int studio_id=Integer.valueOf(request.getParameter("studioid"));
            int play_id=Integer.valueOf(request.getParameter("playid"));
            int ticket_price=Integer.valueOf(request.getParameter("ticketprice"));
            sche=new Schedule(sched_id,studio_id,play_id, show_time, ticket_price);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new ScheduleSrv().add(sche) == 1)
                out.write("数据添加成功");
            else
                out.write("数据添加失败，请重试!!!");

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
            int id=Integer.valueOf(request.getParameter("sched_id"));
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.write("" + new ScheduleSrv().delete(id));
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
        Schedule stu=null;
        int id=0;
        try
        {
            id=Integer.valueOf(request.getParameter("schedid"));
            String show_time=request.getParameter("time");
            int studio_id=Integer.valueOf(request.getParameter("studioid"));
            int play_id=Integer.valueOf(request.getParameter("playid"));
            int ticket_price=Integer.valueOf(request.getParameter("ticketprice"));

            stu=new Schedule(id, studio_id,play_id, show_time, ticket_price);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new ScheduleSrv().modify(stu) == 1)
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
        List<Schedule> result=null; 
        int studio_id=Integer.valueOf(request.getParameter("studio_id"));
        if(studio_id==0)
            result=new ScheduleSrv().FetchAll();
        else
        	result=new ScheduleSrv().Fetch(studio_id);
      //   studio_id=Integer.valueOf(request.getParameter("studio_id"));        //1号
        //	result=new ScheduleSrv().Fetch(studio_id);
      //  else
        //    result=new ScheduleSrv().FetchAll(studio_id);
        	//如果当查询那栏里面的studio_id里面什么值也赋的话，“1号”语句就会发生错误（studio_id是int类型，空值的话显示错误），因此什么也没有查询出来，而当赋值之后也就正确了
        	//所以最笨的办法就是先让FetchAll运行一遍（try、catch、finally）接着再让Fetch运行一遍（try、catch、finally）
        String jsonStr="";
        try
        {
            JSONArray array=new JSONArray();
            JSONObject json;
            for(Schedule s : result)
            {
                json=new JSONObject();
                json.put("sched_id", s.getsched_id());
                json.put("studio_id", s.getstudio_id());
                json.put("play_id", s.getplay_id());
                json.put("show_time", s.gettime());
                json.put("ticket_price", s.getticket_price());
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
