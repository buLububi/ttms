package xupt.se.ttms.model;

public class saleItem {
	private int sale_item_id=0;
	private int ticket_id=0;
	private int sale_ID=0;
	private double sale_item_price=0.0;
	public saleItem() {
		sale_item_id=0;
	}
	
	public saleItem(int sale_item_id, int ticket_id, int sale_ID, double sale_item_price) {
		super();
		this.sale_item_id = sale_item_id;
		this.ticket_id = ticket_id;
		this.sale_ID = sale_ID;
		this.sale_item_price = sale_item_price;
	}
	public int getSale_item_id() {
		return sale_item_id;
	}
	public void setSale_item_id(int sale_item_id) {
		this.sale_item_id = sale_item_id;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public int getSale_ID() {
		return sale_ID;
	}
	public void setSale_ID(int sale_ID) {
		this.sale_ID = sale_ID;
	}
	public double getSale_item_price() {
		return sale_item_price;
	}
	public void setSale_item_price(double sale_item_price) {
		this.sale_item_price = sale_item_price;
	}
	
	
}
