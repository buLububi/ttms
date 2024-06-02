package xupt.se.ttms.model;

public class ticketMang {
	private String play_name="";
	private double revenue_per_play=0.0;
	
	public ticketMang() {
		play_name="";
	}

	public ticketMang( String play_name, double revenue_per_play) {
		super();
		this.play_name = play_name;
		this.revenue_per_play = revenue_per_play;
	}

	

	public String getPlay_name() {
		return play_name;
	}

	public void setPlay_name(String play_name) {
		this.play_name = play_name;
	}

	public double getRevenue_per_play() {
		return revenue_per_play;
	}

	public void setRevenue_per_play(double revenue_per_play) {
		this.revenue_per_play = revenue_per_play;
	}
	
}
