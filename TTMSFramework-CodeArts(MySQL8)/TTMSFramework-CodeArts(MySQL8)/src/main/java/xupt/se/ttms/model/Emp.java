package xupt.se.ttms.model;

public class Emp {
	
	private int emp_id=0;
	private int dict_id=0;
	private String emp_no="";
	private String emp_name="";
	private int emp_gender;
	private String emp_telnum="";
	private String emp_email="";
	private String emp_pwd="";
	
	public Emp() {
		emp_id=0;
	}
	
	public Emp(int emp_id, int dict_id, String emp_no, String emp_name, int emp_gender, String emp_telnum,
			String emp_email, String emp_pwd) {
		super();
		this.emp_id = emp_id;
		this.dict_id = dict_id;
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.emp_gender = emp_gender;
		this.emp_telnum = emp_telnum;
		this.emp_email = emp_email;
		this.emp_pwd = emp_pwd;
	}
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getDict_id() {
		return dict_id;
	}
	public void setDict_id(int dict_id) {
		this.dict_id = dict_id;
	}
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(int emp_gender) {
		this.emp_gender = emp_gender;
	}
	public String getEmp_telnum() {
		return emp_telnum;
	}
	public void setEmp_telnum(String emp_telnum) {
		this.emp_telnum = emp_telnum;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_pwd() {
		return emp_pwd;
	}
	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}
	
}
