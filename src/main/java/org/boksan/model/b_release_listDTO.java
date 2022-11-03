package org.boksan.model;

public class b_release_listDTO {

	private String release_list_code;
	
	private int product_code;
	
	private String product_name;
	
	private int release_num;
	
	private String house_address;
	
	private int release_code;
	
	private String release_state;
	
	private int cumsum_num_check;
	

	public int getCumsum_num_check() {
		return cumsum_num_check;
	}

	public void setCumsum_num_check(int cumsum_num_check) {
		this.cumsum_num_check = cumsum_num_check;
	}

	public String getRelease_list_code() {
		return release_list_code;
	}

	public void setRelease_list_code(String release_list_code) {
		this.release_list_code = release_list_code;
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

	public int getRelease_num() {
		return release_num;
	}

	public void setRelease_num(int release_num) {
		this.release_num = release_num;
	}

	public String getHouse_address() {
		return house_address;
	}

	public void setHouse_address(String house_address) {
		this.house_address = house_address;
	}

	public int getRelease_code() {
		return release_code;
	}

	public void setRelease_code(int release_code) {
		this.release_code = release_code;
	}

	public String getRelease_state() {
		return release_state;
	}

	public void setRelease_state(String release_state) {
		this.release_state = release_state;
	}

	@Override
	public String toString() {
		return "b_release_listDTO [release_list_code=" + release_list_code + ", product_code=" + product_code
				+ ", product_name=" + product_name + ", release_num=" + release_num + ", house_address=" + house_address
				+ ", release_code=" + release_code + ", release_state=" + release_state + ", cumsum_num_check="
				+ cumsum_num_check + "]";
	}

	
	
	

	
	
}
