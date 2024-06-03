package xupt.se.ttms.model;

public class caiCount {
	private String play_type="";
	private String play_language="";
	private double revenue_per_type_language=0.0;
	
	public caiCount() {
		play_type="";
	}

	public caiCount(String play_type, String play_language, double revenue_per_type_language) {
		super();
		this.play_type = play_type;
		this.play_language = play_language;
		this.revenue_per_type_language = revenue_per_type_language;
	}

	public String getPlay_type() {
		return play_type;
	}

	public void setPlay_type(String play_type) {
		this.play_type = play_type;
	}

	public String getPlay_language() {
		return play_language;
	}

	public void setPlay_language(String play_language) {
		this.play_language = play_language;
	}

	public double getRevenue_per_type_language() {
		return revenue_per_type_language;
	}

	public void setRevenue_per_type_language(double revenue_per_type_language) {
		this.revenue_per_type_language = revenue_per_type_language;
	}

	
}
