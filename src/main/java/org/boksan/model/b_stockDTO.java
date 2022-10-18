package org.boksan.model;

import java.util.ArrayList;
import java.util.List;

public class b_stockDTO {
	private String pallet_num;
	
	private int product_code;
	
	private int pallet_count;
	
	private String product_name;
	
	private int product_group_code;
	
	private List<b_stockDTO> pallet_num_list;
	

	
	


	
	


	


	public void setPallet_num_list(ArrayList<b_stockDTO> pallet_num_list) {
		this.pallet_num_list = pallet_num_list;
	}

	public int getProduct_group_code() {
		return product_group_code;
	}

	public void setProduct_group_code(int product_group_code) {
		this.product_group_code = product_group_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPallet_count() {
		return pallet_count;
	}

	public void setPallet_count(int pallet_count) {
		this.pallet_count = pallet_count;
	}

	public String getPallet_num() {
		return pallet_num;
	}

	public void setPallet_num(String pallet_num) {
		this.pallet_num = pallet_num;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public List<b_stockDTO> getPallet_num_list() {
		return pallet_num_list;
	}

	public void setPallet_num_list(List<b_stockDTO> pallet_num_list) {
		this.pallet_num_list = pallet_num_list;
	}

	@Override
	public String toString() {
		return "b_stockDTO [pallet_num=" + pallet_num + ", product_code=" + product_code + ", pallet_count="
				+ pallet_count + ", product_name=" + product_name + ", product_group_code=" + product_group_code
				+ ", pallet_num_list=" + pallet_num_list + "]";
	}

	

	



	

	


}
