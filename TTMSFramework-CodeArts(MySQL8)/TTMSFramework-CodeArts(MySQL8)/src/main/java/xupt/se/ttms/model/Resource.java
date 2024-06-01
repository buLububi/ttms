package xupt.se.ttms.model;

public class Resource {
	private int res_id=0;
	private String res_parent="";
	private String res_name="";
	private String res_URL="";
	public Resource(){
		int res_id=0;
	}
	public Resource(int res_id, String res_parent, String res_name, String res_URL) {
		super();
		this.res_id = res_id;
		this.res_parent = res_parent;
		this.res_name = res_name;
		this.res_URL = res_URL;
	}
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}
	public String getRes_parent() {
		return res_parent;
	}
	public void setRes_parent(String res_parent) {
		this.res_parent = res_parent;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getRes_URL() {
		return res_URL;
	}
	public void setRes_URL(String res_URL) {
		this.res_URL = res_URL;
	}
	
}
