package org.boksan.model;

public class statementDTO {
	
	private String statement_code;
	
	private String classification;
	
	private int emp_code;
	
	private String emp_name;
	
	private String emp_tel;
	
	private String date;
	
	private int product_code;
	
	private String product_name;
	
	private String product_country;
	
	private String product_business;
	
	private int product_price;
	
	private int quantity;

	public String getStatement_code() {
		return statement_code;
	}

	public void setStatement_code(String statement_code) {
		this.statement_code = statement_code;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public int getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_tel() {
		return emp_tel;
	}

	public void setEmp_tel(String emp_tel) {
		this.emp_tel = emp_tel;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_country() {
		return product_country;
	}

	public void setProduct_country(String product_country) {
		this.product_country = product_country;
	}

	public String getProduct_business() {
		return product_business;
	}

	public void setProduct_business(String product_business) {
		this.product_business = product_business;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "statementDTO [statement_code=" + statement_code + ", classification=" + classification + ", emp_code="
				+ emp_code + ", emp_name=" + emp_name + ", emp_tel=" + emp_tel + ", date=" + date + ", product_code="
				+ product_code + ", product_name=" + product_name + ", product_country=" + product_country
				+ ", product_business=" + product_business + ", product_price=" + product_price + ", quantity="
				+ quantity + "]";
	}

	public Object get(String string) {
		// TODO Auto-generated method stub
		return null;
	}



	
	
}
