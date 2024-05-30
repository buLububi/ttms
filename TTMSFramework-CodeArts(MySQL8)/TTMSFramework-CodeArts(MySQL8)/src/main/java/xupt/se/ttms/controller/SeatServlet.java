package xupt.se.ttms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import xupt.se.ttms.model.Seat;
import xupt.se.ttms.service.SeatSrv;

public class SeatServlet extends HttpServlet{
	
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
        Seat seat=null;
       
        try
        {
        	int seat_id=Integer.valueOf(request.getParameter("seat_id"));
        	int studio_id=Integer.valueOf(request.getParameter("studio_id"));
            int seat_row=Integer.valueOf(request.getParameter("seat_row"));
            int seat_column=Integer.valueOf(request.getParameter("seat_column"));
            seat=new Seat(seat_id,studio_id, seat_row, seat_column);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new SeatSrv().add(seat) == 1)
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
            int studio_id=Integer.valueOf(request.getParameter("studio_id"));
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.write("" + new SeatSrv().delete(studio_id));
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
        Seat seat=null;
        int seat_id=0,studio_id=0;
        try
        {
            seat_id=Integer.valueOf(request.getParameter("seat_id"));
            studio_id=Integer.valueOf(request.getParameter("studio_id"));
            int seat_row=Integer.valueOf(request.getParameter("seat_row"));
            int seat_column=Integer.valueOf(request.getParameter("seat_column"));
            seat=new Seat(seat_id,studio_id, seat_row, seat_column);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

            if(new SeatSrv().modify(seat) == 1)
                out.write("数据修改成功");
            else
                out.write("数据修改失败，请重试");

            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("鎿嶄綔閿欒锛岃閲嶈瘯");
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        /*String name=request.getParameter("name");*/
        int studio_id=Integer.valueOf(request.getParameter("studio_id"));
        List<Seat> result=null;
        if(studio_id> 0)
            result=new SeatSrv().Fetch(studio_id);
        else
            result=new SeatSrv().FetchAll();
        String jsonStr="";
        try
        {
            JSONArray array=new JSONArray();
            JSONObject json;
            for(Seat s : result)
            {
                json=new JSONObject();
                json.put("seat_id", s.getSeat_id());
                json.put("studio_id", s.getStudio_id());
                json.put("seat_row", s.getSeat_row());
                json.put("seat_column", s.getSeat_column());
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
