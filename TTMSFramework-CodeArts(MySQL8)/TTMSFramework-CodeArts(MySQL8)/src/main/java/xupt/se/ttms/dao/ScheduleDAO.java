package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iScheduleDAO;
import xupt.se.ttms.model.Schedule;
import xupt.se.util.DBUtil;

public class ScheduleDAO implements iScheduleDAO
{
    @SuppressWarnings("finally")
    @Override
    public int insert(Schedule sche)
    {
        int result=0;
        try
        {
            String sql="insert into schedule(studio_id, play_id, sched_time, sched_ticket_price)"
                    + " values(" + sche.getstudio_id() +", " + sche.getplay_id() + ", '"
                    + sche.gettime() + "'," + sche.getticket_price() +")";
            DBUtil db=new DBUtil();
            db.openConnection();
            ResultSet rst=db.getInsertObjectIDs(sql);
            if(rst != null && rst.first())
            {
                sche.setsched_id(rst.getInt(1));
            }
            db.close(rst);
            db.close();
            result=1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return result;
        }
    }

    @SuppressWarnings("finally")
    @Override
    public int update(Schedule sche)
    {
        int result=0;
        try
        {
            String sql="update schedule set " + " studio_id =" + sche.getstudio_id() + ", " + " play_id = "
                    + sche.getplay_id() + ", " + " sched_time = '" + sche.gettime() + "', "
                    + " sched_ticket_price = " + sche.getticket_price();
            sql+=" where sched_id = " + sche.getsched_id();
            DBUtil db=new DBUtil();
            db.openConnection();
            result=db.execCommand(sql);
            db.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return result;
        }
    }

    @Override
    public int delete(int id)
    {
        int result=0;
        try
        {
            String sql="delete from  schedule where sched_id = " + id;
            DBUtil db=new DBUtil();
            db.openConnection();
            result=db.execCommand(sql);
            db.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("finally")
    public int selectstudioid(int condt)
    {
        DBUtil db=null;
        int result=0;
        try
        {
            String sql="select studio_id from schedule  where sched_id= " + condt;
            db=new DBUtil();
            if(!db.openConnection())
            {
                System.out.print("fail to connect database");
                return result;
            }
            ResultSet rst=db.execQuery(sql);
            if(rst != null)
            {
                while(rst.next())
                {
                    result=rst.getInt("studio_id");
                }
            }
            db.close(rst);
            db.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return result;
        }
    }

    @SuppressWarnings("finally")
    @Override
    public List<Schedule> selectAll()
    {
        DBUtil db=null;
        List<Schedule> scheList=null;
        scheList=new LinkedList<Schedule>();
        try
        {
        	//studioid.trim();
        //    String sql="select * from schedule where studio_id like '%" + studioid + "%'";
            String sql="select * from schedule ";
        	db=new DBUtil();
            if(!db.openConnection())
            {
                System.out.print("fail to connect database");
                return null;
            }
            ResultSet rst=db.execQuery(sql);
            if(rst != null)
            {
                while(rst.next())
                {
                    Schedule stu=new Schedule();
                    stu.setsched_id(rst.getInt("sched_id"));
                    stu.setstudio_id(rst.getInt("studio_id"));
                    stu.setplay_id(rst.getInt("play_id"));
                    stu.settime(rst.getString("sched_time"));
                    stu.setticket_price(rst.getInt("sched_ticket_price"));
                    scheList.add(stu);
                }
            }
            db.close(rst);
            db.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return scheList;
        }
    }
    
    @SuppressWarnings("finally")
    @Override
    public List<Schedule> select(int studioid)
    {
        DBUtil db=null;
        List<Schedule> scheList=null;
        scheList=new LinkedList<Schedule>();
        try
        {
        	//studioid.trim();
        //    String sql="select * from schedule where studio_id like '%" + studioid + "%'";
            String sql="select * from schedule where studio_id= " + studioid;
        	db=new DBUtil();
            if(!db.openConnection())
            {
                System.out.print("fail to connect database");
                return null;
            }
            ResultSet rst=db.execQuery(sql);
            if(rst != null)
            {
                while(rst.next())
                {
                    Schedule stu=new Schedule();
                    stu.setsched_id(rst.getInt("sched_id"));
                    stu.setstudio_id(rst.getInt("studio_id"));
                    stu.setplay_id(rst.getInt("play_id"));
                    stu.settime(rst.getString("sched_time"));
                    stu.setticket_price(rst.getInt("sched_ticket_price"));
                    scheList.add(stu);
                }
            }
            db.close(rst);
            db.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return scheList;
        }
    }
}
