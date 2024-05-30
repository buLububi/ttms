package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Schedule;

public interface iScheduleDAO
{
    public int insert(Schedule sche);

    public int update(Schedule sche);

    public int delete(int ID);

    public List<Schedule> select(int studioid);
    
    public List<Schedule> selectAll();
}