package org.boksan.model;

public class Arrive_palletDTO {
	
	private int product_code;
	private String pallet_num;
	

	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public String getPallet_num() {
		return pallet_num;
	}
	public void setPallet_num(String pallet_num) {
		this.pallet_num = pallet_num;
	}
	
	@Override
	public String toString() {
		return "TestDTO [product_code=" + product_code + ", pallet_num=" + pallet_num + "]";
	}

}
