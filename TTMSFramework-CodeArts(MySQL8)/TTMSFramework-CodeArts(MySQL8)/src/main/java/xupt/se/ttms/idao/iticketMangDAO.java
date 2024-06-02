/**
 * 
 */
package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.ticketMang;



public interface iticketMangDAO
{
    

    public List<ticketMang> select(String roleName);
}
