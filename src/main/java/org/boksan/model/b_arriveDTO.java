package org.boksan.model;

public class b_arriveDTO {
	
	private int arrive_code;
	private int product_code;
	private int arrive_num;
	private String product_name;
	
	
	
	public int getArrive_code() {
		return arrive_code;
	}
	public void setArrive_code(int arrive_code) {
		this.arrive_code = arrive_code;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public int getArrive_num() {
		return arrive_num;
	}
	public void setArrive_num(int arrive_num) {
		this.arrive_num = arrive_num;
	}
	
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	@Override
	public String toString() {
		return "b_arriveDTO [product_code=" + product_code + ", arrive_num=" + arrive_num + ", product_name="
				+ product_name + "]";
	}
	
	
	
	
}
