package org.boksan.model;

import java.util.ArrayList;
import java.util.List;

public class b_releaseDTO {
	
	private int product_code;
	
	private String product_name;
	
	private int release_num;
	
	private String situation;
	
	private List<b_releaseDTO> release_insert_list;
	
	

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
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

	public List<b_releaseDTO> getRelease_insert_list() {
		return release_insert_list;
	}

	public void setRelease_insert_list(List<b_releaseDTO> release_insert_list) {
		this.release_insert_list = release_insert_list;
	}

	@Override
	public String toString() {
		return "b_releaseDTO [product_code=" + product_code + ", product_name=" + product_name + ", release_num="
				+ release_num + ", release_insert_list=" + release_insert_list + "]";
	}

	

	
	
	
	
}
