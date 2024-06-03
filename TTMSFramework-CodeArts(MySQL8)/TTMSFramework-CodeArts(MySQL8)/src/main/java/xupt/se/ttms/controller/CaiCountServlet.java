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

import xupt.se.ttms.model.caiCount;
import xupt.se.ttms.service.CaiCountSrv;

@WebServlet("/CaiCountServlet")
public class CaiCountServlet extends HttpServlet
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
         if(type.equalsIgnoreCase("search"))
            search(request, response);
        
    }

    
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        String sched=request.getParameter("play_language");
        
        List<caiCount> result=null;
        if(sched != null && sched.length() > 0)
            result=new CaiCountSrv().Fetch(sched);
        else
            result=new CaiCountSrv().FetchAll();
        String jsonStr="";
        try
        {
            JSONArray array=new JSONArray();
            JSONObject json;
            for(caiCount s : result)
            {
                json=new JSONObject();
                json.put("play_type", s.getPlay_type());
                json.put("play_language", s.getPlay_language());
                json.put("revenue_per_type_language", s.getRevenue_per_type_language());
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
