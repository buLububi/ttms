package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iSeatDAO;
import xupt.se.ttms.model.Seat;
import xupt.se.util.DBUtil;

public class SeatDAO implements iSeatDAO{

	@SuppressWarnings("finally")
	@Override
	public int insert(Seat seat) {
		int result=0;
        try
        {
            String sql="insert into seat(seat_id, studio_id, seat_row, seat_column )"
                    + " values(" + seat.getSeat_id() + ", " + seat.getStudio_id() + ", " + seat.getSeat_row() + ", "
                    + seat.getSeat_column() + " )";
            DBUtil db=new DBUtil();
            db.openConnection();
            ResultSet rst=db.getInsertObjectIDs(sql);
            if(rst != null && rst.first())
            {
                seat.setSeat_id(rst.getInt(1));
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
	public int update(Seat seat) {
		int result=0;
        try
        {
            String sql="update seat set " + " seat_id =" + seat.getSeat_id() + ", " + " studio_id = "
                    + seat.getStudio_id() + ", " + " seat_column = " + seat.getSeat_column() + ", "
                    + " seat_row = " + seat.getSeat_row();
            sql+=" where studio_id = " + seat.getStudio_id();
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
	public int delete(int ID) {
		int result=0;
        try
        {
            String sql="delete from  seat where seat_id = " + ID;
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
	@Override
	public List<Seat> select(int seat_id) {
		DBUtil db=null;
        List<Seat> seatList=null;
        seatList=new LinkedList<Seat>();
        try
        {
            String sql="select * from seat where seat_id = " + seat_id ;
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
                    Seat seat=new Seat();
                    seat.setSeat_id(rst.getInt("seat_id"));
                    seat.setStudio_id(rst.getInt("studio_id"));
                    seat.setSeat_row(rst.getInt("seat_row"));
                    seat.setSeat_column(rst.getInt("seat_column"));
                    seatList.add(seat);
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
            return seatList;
        }
	}
	
	@SuppressWarnings("finally")
    public String selectseat(int condt)
    {
        DBUtil db=null;
        String result="";
        try
        {
            String sql="select seat_id from seat  where seat_id= " + condt;
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
                    result=rst.getString("seat_id");
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
}

	

	

