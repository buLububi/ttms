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

import xupt.se.ttms.model.SaleSche;
import xupt.se.ttms.service.SaleScheSrv;

@WebServlet("/saleScheServlet")
public class saleScheServlet extends HttpServlet
{
    private static final long serialVersionUID=1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	
    	response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        String playid=request.getParameter("playid");
        List<SaleSche> result=null;
        //List<Admin> result1=null;
        if(playid != null && playid.length() > 0 ) {
            result=new SaleScheSrv().Fetch(playid);
        	//result1=new AdminSrv().Fetch(pwd);
        }
        else {
        	result=new SaleScheSrv().FetchAll();
        	//result1=new AdminSrv().FetchAll();
        }
            
        
        String jsonStr="";
        try
        {
            JSONArray array=new JSONArray();
            JSONObject json;
            for(SaleSche s : result )
            {	
                json=new JSONObject();
                json.put("studio_name", s.getStudio_name());
                json.put("schedule_price", s.getSchedule_price());
                json.put("schedule_time", s.getSchedule_time());
                json.put("studio_id", s.getStudio_id());
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

            if(result == null || result.size()==0 ) {
            	System.out.println("--------------");
            	out.write("0");
            }else {
            	//out.write("1");
                out.println(jsonStr);

            }
            out.flush();
            out.close();
        }
         System.out.print(jsonStr);
    }
   }