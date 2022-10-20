package org.boksan.model;

public class b_arriveDTO {
	
	private int product_code;
	private int arrive_num;
	
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
	@Override
	public String toString() {
		return "b_arriveDTO [product_code=" + product_code + ", arrive_num=" + arrive_num + "]";
	}
	
	
}
