package org.boksan.model;

import java.util.List;

public class Recipe_addDTO {
	
	private int recipe_code;
	private String product_name;
	private int gross_weight;
	private String content;
	private String production_date;
	private int emp_code;
	
	private int product_code;
	private int material_num;
	private String material_name;
	private String maker_name;
	
	private List<Recipe_addDTO> product_code_list;
	private List<Recipe_addDTO> material_num_list;
	
	public List<Recipe_addDTO> getProduct_code_list() {
		return product_code_list;
	}
	public void setProduct_code_list(List<Recipe_addDTO> product_code_list) {
		this.product_code_list = product_code_list;
	}
	public List<Recipe_addDTO> getMaterial_num_list() {
		return material_num_list;
	}
	public void setMaterial_num_list(List<Recipe_addDTO> material_num_list) {
		this.material_num_list = material_num_list;
	}
	
	public int getRecipe_code() {
		return recipe_code;
	}
	public void setRecipe_code(int recipe_code) {
		this.recipe_code = recipe_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getGross_weight() {
		return gross_weight;
	}
	public void setGross_weight(int gross_weight) {
		this.gross_weight = gross_weight;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getProduction_date() {
		return production_date;
	}
	public void setProduction_date(String production_date) {
		this.production_date = production_date;
	}
	public int getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public int getMaterial_num() {
		return material_num;
	}
	public void setMaterial_num(int material_num) {
		this.material_num = material_num;
	}
	
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}
	

	public String getMaker_name() {
		return maker_name;
	}
	public void setMaker_name(String maker_name) {
		this.maker_name = maker_name;
	}
	@Override
	public String toString() {
		return "Recipe_addDTO [recipe_code=" + recipe_code + ", product_name=" + product_name + ", gross_weight="
				+ gross_weight + ", content=" + content + ", production_date=" + production_date + ", emp_code="
				+ emp_code + ", product_code=" + product_code + ", material_num=" + material_num
				+ ", product_code_list=" + product_code_list + ", material_num_list=" + material_num_list + "]";
	}
	
	
	
	
	
	
}
