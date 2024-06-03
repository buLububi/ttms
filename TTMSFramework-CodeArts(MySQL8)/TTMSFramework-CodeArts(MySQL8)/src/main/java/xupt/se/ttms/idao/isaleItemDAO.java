package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.saleItem;

public interface isaleItemDAO {
	
	public int insert(saleItem stu);

    public int update(saleItem stu);

    public int delete(int ID);
    
	public List<saleItem> select(String name);
}
