package org.boksan.model;

public class materiaDTO {
	
	private int product_code;
	
	private int material_num;
	
	private String product_name;

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

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	@Override
	public String toString() {
		return "materiaDTO [product_code=" + product_code + ", material_num=" + material_num + ", product_name="
				+ product_name + "]";
	}

	
	
}
