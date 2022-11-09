package org.boksan.model;

import java.util.ArrayList;
import java.util.List;

public class b_releaseDTO {
	
	private int release_code;
	
	private int product_code;
	
	private String product_name;
	
	private int release_num;
	
	private String situation;
	
	private List<b_releaseDTO> release_insert_list;
	
	private int res;
	
	private String release_time;
	
	private int emp_code;
	
	private String name;
	
	
	

	public String getRelease_time() {
		return release_time;
	}

	public void setRelease_time(String release_time) {
		this.release_time = release_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}

	public int getRelease_code() {
		return release_code;
	}

	public void setRelease_code(int release_code) {
		this.release_code = release_code;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

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
		return "b_releaseDTO [release_code=" + release_code + ", product_code=" + product_code + ", product_name="
				+ product_name + ", release_num=" + release_num + ", situation=" + situation + ", release_insert_list="
				+ release_insert_list + ", res=" + res + ", release_time=" + release_time + ", emp_code=" + emp_code
				+ ", name=" + name + "]";
	}

	

	

	

	
	
	
	
}
