package org.boksan.model;

import java.util.ArrayList;
import java.util.List;

public class b_stockDTO {
	private String pallet_num;
	
	private int product_code;
	
	private String arrive_date;
	
	private int stock_num;
	
	private String house_code;
	
	private String product_barcode;
	
	private int pallet_count;
	
	private String product_name;
	
	private int product_group_code;
	
	private List<b_stockDTO> pallet_num_list;
	
	private b_productDTO moveList;
	
	




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

	public b_productDTO getMoveList() {
		return moveList;
	}

	public void setMoveList(b_productDTO moveList) {
		this.moveList = moveList;
	}

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
		return "b_stockDTO [pallet_num=" + pallet_num + ", product_code=" + product_code + ", arrive_date="
				+ arrive_date + ", stock_num=" + stock_num + ", house_code=" + house_code + ", product_barcode="
				+ product_barcode + ", pallet_count=" + pallet_count + ", product_name=" + product_name
				+ ", product_group_code=" + product_group_code + ", pallet_num_list=" + pallet_num_list + ", moveList="
				+ moveList + "]";
	}


	

	

	

	



	

	


}
