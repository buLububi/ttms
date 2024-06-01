/**
 * 
 */
package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Role;



public interface iRoleDAO
{
    public int insert(Role stu);

    public int update(Role stu);

    public int delete(int ID);

    public List<Role> select(String roleName);
}
