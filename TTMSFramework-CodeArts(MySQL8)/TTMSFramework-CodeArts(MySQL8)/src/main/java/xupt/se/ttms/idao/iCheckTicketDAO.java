/**
 * 
 */
package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.checkTicket;

public interface iCheckTicketDAO
{

    public int update(checkTicket stu);


    public List<checkTicket> select(String name);
}
