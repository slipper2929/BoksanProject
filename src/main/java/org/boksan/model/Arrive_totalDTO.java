package org.boksan.model;

public class Arrive_totalDTO {
	
	private int product_code;
	private String product_name;
	private String product_group_name;
	private String business_name;
	private String business_code;
	private String country_code;
	private String country_name;
	private int price;
	private int arrive_num_total;
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
	public String getProduct_group_name() {
		return product_group_name;
	}
	public void setProduct_group_name(String product_group_name) {
		this.product_group_name = product_group_name;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getArrive_num_total() {
		return arrive_num_total;
	}
	public void setArrive_num_total(int arrive_num_total) {
		this.arrive_num_total = arrive_num_total;
	}
	@Override
	public String toString() {
		return "Arrive_totalDTO [product_code=" + product_code + ", product_name=" + product_name
				+ ", product_group_name=" + product_group_name + ", business_name=" + business_name + ", business_code="
				+ business_code + ", country_code=" + country_code + ", country_name=" + country_name + ", price="
				+ price + ", arrive_num_total=" + arrive_num_total + "]";
	}
	
	
	
	

}
