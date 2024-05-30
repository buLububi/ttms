package xupt.se.ttms.model;

public class Sale {

	private int sale_ID=0;
	private int emp_id=0;
	private int cus_id=0;
	private String sale_time="" ;  
	private double sale_payment=0;
	private double sale_change=0;
	private int sale_type=0;
	private int sale_status=0;
	private int sale_sort=0;
	public Sale() {
		sale_ID=0;
	}
	
	public Sale(int sale_ID, int emp_id, int cus_id, String sale_time, double sale_payment, double sale_change, int sale_type,int sale_status,int sale_sort) {
		super();
		this.sale_ID = sale_ID;
		this.emp_id = emp_id;
		this.cus_id = cus_id;
		this.sale_time = sale_time;
		this.sale_payment = sale_payment;
		this.sale_change = sale_change;
		this.sale_type = sale_type;
		this.sale_status = sale_status;
		this.sale_sort = sale_sort;
	}

	public int getSaleId() {
		return sale_ID;
	}
	public void setSaleId(int sale_ID) {
		this.sale_ID = sale_ID;
	}
	public int getEmpId() {
		return emp_id;
	}
	public void setEmpId(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getCusId() {
		return cus_id;
	}
	public void setCusId(int cus_id) {
		this.cus_id = cus_id;
	}
	public String getTime() {
		return sale_time;
	}
	public void setTime(String sale_time) {
		this.sale_time = sale_time;
	}
	public double getPayment() {
		return sale_payment;
	}
	public void setPayment(double sale_payment) {
		this.sale_payment = sale_payment;
	}
	public double getChange() {
		return sale_change;
	}
	public void setChange(double sale_change) {
		this.sale_change = sale_change;
	}
	public int getType() {
		return sale_type;
	}
	public void setType(int sale_type) {
		this.sale_type = sale_type;
	}
	public int getStatus() {
		return sale_status;
	}
	public void setStatus(int sale_status) {
		this.sale_status = sale_status;
	}
	public int getSort() {
		return sale_sort;
	}
	public void setSort(int sale_sort) {
		this.sale_sort = sale_sort;
	}

	
	
}