package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Cus;


public interface iCusDAO {
	public int insert(Cus cus);

    public int update(Cus cus);

    public int delete(int ID);

    public List<Cus> select(String cusName);

}
