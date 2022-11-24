package org.boksan.model;

public class b_houseDTO {
	
	private String house_code;
	
	private int house_function;
	
	private int out_num;
	
	private String in_num;
	
	private String detail_position;
	
	private int product_code;
	
	private String product_name;
	
	private String pallet_num;
	
	private int stock_num;
	
	private int max_quantity;
	
	private int now_quantity;
	
	private String country_name;
	
	private String business_name;
	
	private house_functionDTO house_functiondto;

	public String getHouse_code() {
		return house_code;
	}

	public void setHouse_code(String house_code) {
		this.house_code = house_code;
	}

	public int getHouse_function() {
		return house_function;
	}

	public void setHouse_function(int house_function) {
		this.house_function = house_function;
	}

	public int getOut_num() {
		return out_num;
	}

	public void setOut_num(int out_num) {
		this.out_num = out_num;
	}

	public String getIn_num() {
		return in_num;
	}

	public void setIn_num(String in_num) {
		this.in_num = in_num;
	}

	public String getDetail_position() {
		return detail_position;
	}

	public void setDetail_position(String detail_position) {
		this.detail_position = detail_position;
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

	public String getPallet_num() {
		return pallet_num;
	}

	public void setPallet_num(String pallet_num) {
		this.pallet_num = pallet_num;
	}

	public int getStock_num() {
		return stock_num;
	}

	public void setStock_num(int stock_num) {
		this.stock_num = stock_num;
	}

	public int getMax_quantity() {
		return max_quantity;
	}

	public void setMax_quantity(int max_quantity) {
		this.max_quantity = max_quantity;
	}

	public int getNow_quantity() {
		return now_quantity;
	}

	public void setNow_quantity(int now_quantity) {
		this.now_quantity = now_quantity;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public house_functionDTO getHouse_functiondto() {
		return house_functiondto;
	}

	public void setHouse_functiondto(house_functionDTO house_functiondto) {
		this.house_functiondto = house_functiondto;
	}

	@Override
	public String toString() {
		return "b_houseDTO [house_code=" + house_code + ", house_function=" + house_function + ", out_num=" + out_num
				+ ", in_num=" + in_num + ", detail_position=" + detail_position + ", product_code=" + product_code
				+ ", product_name=" + product_name + ", pallet_num=" + pallet_num + ", stock_num=" + stock_num
				+ ", max_quantity=" + max_quantity + ", now_quantity=" + now_quantity + ", country_name=" + country_name
				+ ", business_name=" + business_name + ", house_functiondto=" + house_functiondto + "]";
	}

	

	
}
