package org.boksan.model;

public class b_productDTO {
	
	private int product_code;
	
	private String product_name;
	
	private int price;
	
	private String place;
	
	private String business_name;
	
	private int pallet_in_ratio;
	
	private int product_group_code;
	
	private Product_groupDTO product_groupdto;
	


	

	public Product_groupDTO getProduct_groupdto() {
		return product_groupdto;
	}

	public void setProduct_groupdto(Product_groupDTO product_groupdto) {
		this.product_groupdto = product_groupdto;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public int getPallet_in_ratio() {
		return pallet_in_ratio;
	}

	public void setPallet_in_ratio(int pallet_in_ratio) {
		this.pallet_in_ratio = pallet_in_ratio;
	}

	public int getProduct_group_code() {
		return product_group_code;
	}

	public void setProduct_group_code(int product_group_code) {
		this.product_group_code = product_group_code;
	}

	@Override
	public String toString() {
		return "b_productDTO [product_code=" + product_code + ", product_name=" + product_name + ", price=" + price
				+ ", place=" + place + ", business_name=" + business_name + ", pallet_in_ratio=" + pallet_in_ratio
				+ ", product_group_code=" + product_group_code + "]";
	}
	
}
