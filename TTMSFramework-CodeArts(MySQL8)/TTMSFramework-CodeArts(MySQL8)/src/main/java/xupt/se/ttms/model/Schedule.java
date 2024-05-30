package xupt.se.ttms.model;

public class Schedule {
	private int sched_id=0      ; 
	private int studio_id=0 ;
	private int play_id=0 ;
	private String show_time="";
	private int ticket_price=0;
 //���
	
	public Schedule(){
		sched_id = 0;
	}

	public Schedule(int sched_id, int studio_id, int play_id, String show_time, int ticket_price) {
		super();
		this.sched_id = sched_id;
		this.studio_id = studio_id;
		this.play_id = play_id;
		this.show_time = show_time;
		this.ticket_price = ticket_price;
	}

	public int getsched_id() {
		return sched_id;
	}
	public void setsched_id(int id) {
		this.sched_id = id;
	}
	public void setstudio_id(int ID){
		this.studio_id=ID;
	}
	
	public int getstudio_id(){
		return studio_id;
	}
	
	public int getplay_id() {
		return play_id;
	}
	public void setplay_id(int id) {
		this.play_id = id;
	}
	public void setticket_price(int ID){
		this.ticket_price=ID;
	}
	
	public int getticket_price(){
		return ticket_price;
	}
	
	public void settime(String show_time){
		this.show_time=show_time;
	}
	
	public String gettime(){
		return show_time;
	}
	
}
