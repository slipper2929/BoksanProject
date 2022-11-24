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
	
	private int product_group_code;
	
	private String product_group_name;
	
	private List<b_stockDTO> pallet_num_list;
	
	private b_productDTO moveList;
	
	private b_productDTO b_productdto;
	
	private b_movement_orderDTO b_movement_orderdto;
	
	private b_houseDTO b_housedto;
	
	private Criteria criteria;
	
	private String product_name;
	
	private String country_name;
	
	private String business_name;
	
	private String movement_address;
	

	public String getMovement_address() {
		return movement_address;
	}

	public void setMovement_address(String movement_address) {
		this.movement_address = movement_address;
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

	public int getPallet_count() {
		return pallet_count;
	}

	public void setPallet_count(int pallet_count) {
		this.pallet_count = pallet_count;
	}

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

	public List<b_stockDTO> getPallet_num_list() {
		return pallet_num_list;
	}

	public void setPallet_num_list(List<b_stockDTO> pallet_num_list) {
		this.pallet_num_list = pallet_num_list;
	}

	public b_productDTO getMoveList() {
		return moveList;
	}

	public void setMoveList(b_productDTO moveList) {
		this.moveList = moveList;
	}

	public b_productDTO getB_productdto() {
		return b_productdto;
	}

	public void setB_productdto(b_productDTO b_productdto) {
		this.b_productdto = b_productdto;
	}

	public b_movement_orderDTO getB_movement_orderdto() {
		return b_movement_orderdto;
	}

	public void setB_movement_orderdto(b_movement_orderDTO b_movement_orderdto) {
		this.b_movement_orderdto = b_movement_orderdto;
	}

	public b_houseDTO getB_housedto() {
		return b_housedto;
	}

	public void setB_housedto(b_houseDTO b_housedto) {
		this.b_housedto = b_housedto;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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

	@Override
	public String toString() {
		return "b_stockDTO [pallet_num=" + pallet_num + ", product_code=" + product_code + ", arrive_date="
				+ arrive_date + ", stock_num=" + stock_num + ", house_code=" + house_code + ", product_barcode="
				+ product_barcode + ", pallet_count=" + pallet_count + ", product_group_code=" + product_group_code
				+ ", product_group_name=" + product_group_name + ", pallet_num_list=" + pallet_num_list + ", moveList="
				+ moveList + ", b_productdto=" + b_productdto + ", b_movement_orderdto=" + b_movement_orderdto
				+ ", b_housedto=" + b_housedto + ", criteria=" + criteria + ", product_name=" + product_name
				+ ", country_name=" + country_name + ", business_name=" + business_name + ", movement_address="
				+ movement_address + "]";
	}

	
	
	


	









	

	

	

	



	

	


}
