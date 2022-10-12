package org.boksan.model;

public class Product_groupDTO {
	
	private int product_group_code;
	private String product_group_name;
	public int getProduct_group_code() {
		return product_group_code;
	}
	public void setProduct_group_code(int product_group_code) {
		this.product_group_code = product_group_code;
	}
	public String getProduct_group_name() {
		return product_group_name;
	}
	public void setProduct_group_name(String product_group_name) {
		this.product_group_name = product_group_name;
	}
	@Override
	public String toString() {
		return "Product_groupDTO [product_group_code=" + product_group_code + ", product_group_name="
				+ product_group_name + "]";
	}
	
}
