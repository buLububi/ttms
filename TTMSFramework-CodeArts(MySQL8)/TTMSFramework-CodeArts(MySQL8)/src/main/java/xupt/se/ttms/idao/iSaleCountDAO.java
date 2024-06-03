/**
 * 
 */
package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.saleCount;



public interface iSaleCountDAO
{
    

    public List<saleCount> select(String roleName);
}
