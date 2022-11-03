package org.boksan.model;

public class house_functionDTO {
	
	private int house_function;
	
	private String function_name;

	public int getHouse_function() {
		return house_function;
	}

	public void setHouse_function(int house_function) {
		this.house_function = house_function;
	}

	public String getFunction_name() {
		return function_name;
	}

	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}

	@Override
	public String toString() {
		return "house_functionDTO [house_function=" + house_function + ", function_name=" + function_name + "]";
	}

}
