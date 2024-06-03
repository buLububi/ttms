package xupt.se.ttms.model;

public class checkTicket {
	private int ticket_id=0;
	private int seat_id=0;
	private int sched_id=0;
	private double ticket_price=0.0;
	private int studio_id=0;
	private int seat_row=0;
	private int seat_column=0;
	private String play_name="";
	private int play_length=0;
	private String sched_time="";
	private int ticket_status=0;
	public checkTicket() {
		ticket_id=0;
	}
	public int getTicket_status() {
		return ticket_status;
	}
	public void setTicket_status(int ticket_status) {
		this.ticket_status = ticket_status;
	}
	public checkTicket(int ticket_id, int seat_id, int sched_id, double ticket_price, int studio_id, int seat_row,
			int seat_column, String play_name, int play_length, String sched_time,int ticket_status) {
		super();
		this.ticket_id = ticket_id;
		this.seat_id = seat_id;
		this.sched_id = sched_id;
		this.ticket_price = ticket_price;
		this.studio_id = studio_id;
		this.seat_row = seat_row;
		this.seat_column = seat_column;
		this.play_name = play_name;
		this.play_length = play_length;
		this.sched_time = sched_time;
		this.ticket_status=ticket_status;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	public int getSched_id() {
		return sched_id;
	}
	public void setSched_id(int sched_id) {
		this.sched_id = sched_id;
	}
	public double getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}
	public int getStudio_id() {
		return studio_id;
	}
	public void setStudio_id(int studio_id) {
		this.studio_id = studio_id;
	}
	public int getSeat_row() {
		return seat_row;
	}
	public void setSeat_row(int seat_row) {
		this.seat_row = seat_row;
	}
	public int getSeat_column() {
		return seat_column;
	}
	public void setSeat_column(int seat_column) {
		this.seat_column = seat_column;
	}
	public String getPlay_name() {
		return play_name;
	}
	public void setPlay_name(String play_name) {
		this.play_name = play_name;
	}
	public int getPlay_length() {
		return play_length;
	}
	public void setPlay_length(int play_length) {
		this.play_length = play_length;
	}
	public String getSched_time() {
		return sched_time;
	}
	public void setSched_time(String sched_time) {
		this.sched_time = sched_time;
	}
	
}
