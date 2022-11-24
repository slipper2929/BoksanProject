package org.boksan.model;

public class state_stockDTO {
	
	private int state_num;
	
	private int product_code;
	
	private String arrive_date;
	
	private int stock_num;
	
	private String house_code;
	
	private String product_barcode;

	public int getState_num() {
		return state_num;
	}

	public void setState_num(int state_num) {
		this.state_num = state_num;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public String getArrive_date() {
		return arrive_date;
	}

	public void setArrive_date(String arrive_date) {
		this.arrive_date = arrive_date;
	}

	public int getStock_num() {
		return stock_num;
	}

	public void setStock_num(int stock_num) {
		this.stock_num = stock_num;
	}

	public String getHouse_code() {
		return house_code;
	}

	public void setHouse_code(String house_code) {
		this.house_code = house_code;
	}

	public String getProduct_barcode() {
		return product_barcode;
	}

	public void setProduct_barcode(String product_barcode) {
		this.product_barcode = product_barcode;
	}

	@Override
	public String toString() {
		return "state_stockDTO [state_num=" + state_num + ", product_code=" + product_code + ", arrive_date="
				+ arrive_date + ", stock_num=" + stock_num + ", house_code=" + house_code + ", product_barcode="
				+ product_barcode + "]";
	}
	
}
