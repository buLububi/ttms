package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Sale;

public interface iSaleDAO {
	
	public int insert(Sale sal);
	
	public int update(Sale sal);
	
	public int delete(int id);
	
	public List<Sale> select(String cus_id);
	
}
