package xupt.se.ttms.model;

public class saleCount {
	private String emp_name="";
	private double sales_performance=0.0;
	
	public saleCount() {
		emp_name="";
	}

	public saleCount(String emp_name, double sales_performance) {
		super();
		this.emp_name = emp_name;
		this.sales_performance = sales_performance;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public double getSales_performance() {
		return sales_performance;
	}

	public void setSales_performance(double sales_performance) {
		this.sales_performance = sales_performance;
	}
	
}
