package org.boksan.model;

public class house_functionDTO {
	
	private int function_code;
	
	private String function_name;

	public int getHouse_function() {
		return function_code;
	}

	public int getFunction_code() {
		return function_code;
	}

	public void setFunction_code(int function_code) {
		this.function_code = function_code;
	}

	public String getFunction_name() {
		return function_name;
	}

	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}

	@Override
	public String toString() {
		return "house_functionDTO [function_code=" + function_code + ", function_name=" + function_name + "]";
	}

	

	

}
