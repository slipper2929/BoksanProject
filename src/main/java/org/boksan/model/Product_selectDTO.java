package org.boksan.model;

public class Product_selectDTO {
	
	private int product_code;
	private String product_name;
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
	@Override
	public String toString() {
		return "Product_selectDTO [product_code=" + product_code + ", product_name=" + product_name + "]";
	}
	
	
}
