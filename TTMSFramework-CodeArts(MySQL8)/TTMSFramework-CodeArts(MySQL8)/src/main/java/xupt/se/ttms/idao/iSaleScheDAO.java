package xupt.se.ttms.idao;

import java.util.List;


import xupt.se.ttms.model.SaleSche;

public interface iSaleScheDAO
{
    //public int insert(Admin admin);
		
	public List<SaleSche> select(String play_id);

	//public int insert(Admin admin);
}

