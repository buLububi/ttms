/**
 * 
 */
package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Resource;

public interface iResourceDAO
{
    public int insert(Resource resource);

    public int update(Resource resource);

    public int delete(int ID);

    public List<Resource> select(String Name);
}
