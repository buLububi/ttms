package xupt.se.ttms.model;

public class SaleSche {
	private String schedule_time = "";
	private String studio_name="" ;
	private float schedule_price = 0;
	private int studio_id = 0;
	
	
	public SaleSche(String schedule_time, String studio_name, float schedule_price, int studio_id) {
		this.setSchedule_time(schedule_time);
		this.setStudio_name(studio_name);
		this.setSchedule_price(schedule_price);
		this.setStudio_id(studio_id);
}
	public SaleSche() {
		
	}
	public String getSchedule_time() {
		return schedule_time;
	}
	public void setSchedule_time(String schedule_time) {
		this.schedule_time = schedule_time;
	}
	public String getStudio_name() {
		return studio_name;
	}
	public void setStudio_name(String studio_name) {
		this.studio_name = studio_name;
	}
	public float getSchedule_price() {
		return schedule_price;
	}
	public void setSchedule_price(float schedule_price) {
		this.schedule_price = schedule_price;
	}
	public int getStudio_id() {
		return studio_id;
	}
	public void setStudio_id(int studio_id) {
		this.studio_id = studio_id;
	}
	
	


}

	