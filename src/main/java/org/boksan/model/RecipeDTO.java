package org.boksan.model;

public class RecipeDTO {
	
	private int recipe_code;
	private String product_name;
	private int gross_weight;
	private String content;
	private String production_date;
	private int emp_code;
	
	private b_productDTO productdto;
	private materiaDTO materiadto;
	private b_empDTO empdto;
	public b_empDTO getEmpdto() {
		return empdto;
	}
	public void setEmpdto(b_empDTO empdto) {
		this.empdto = empdto;
	}
	public materiaDTO getMateriadto() {
		return materiadto;
	}
	public void setMateriadto(materiaDTO materiadto) {
		this.materiadto = materiadto;
	}
	public b_productDTO getProductdto() {
		return productdto;
	}
	public void setProductdto(b_productDTO productdto) {
		this.productdto = productdto;
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
	@Override
	public String toString() {
		return "RecipeDTO [recipe_code=" + recipe_code + ", product_name=" + product_name + ", gross_weight="
				+ gross_weight + ", content=" + content + ", production_date=" + production_date + ", emp_code="
				+ emp_code + "]";
	}
	
}
