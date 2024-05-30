package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Emp;

public interface iEmpDAO {
	
	public int insert(Emp emp);

    public int update(Emp emp);

    public int delete(int ID);

    public List<Emp> select(String emp_name);
    public Emp  Loginselect(String emp_name);
	
}
