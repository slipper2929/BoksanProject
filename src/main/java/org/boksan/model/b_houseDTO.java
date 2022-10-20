package org.boksan.model;

public class b_houseDTO {
	
	private String house_code;
	
	private int house_function;
	
	private int out_num;
	
	private String in_num;
	
	private String detail_position;

	public String getHouse_code() {
		return house_code;
	}

	public void setHouse_code(String house_code) {
		this.house_code = house_code;
	}

	public int getHouse_function() {
		return house_function;
	}

	public void setHouse_function(int house_function) {
		this.house_function = house_function;
	}

	public int getOut_num() {
		return out_num;
	}

	public void setOut_num(int out_num) {
		this.out_num = out_num;
	}

	public String getIn_num() {
		return in_num;
	}

	public void setIn_num(String in_num) {
		this.in_num = in_num;
	}

	public String getDetail_position() {
		return detail_position;
	}

	public void setDetail_position(String detail_position) {
		this.detail_position = detail_position;
	}

	@Override
	public String toString() {
		return "b_houseDTO [house_code=" + house_code + ", house_function=" + house_function + ", out_num=" + out_num
				+ ", in_num=" + in_num + ", detail_position=" + detail_position + "]";
	}
}
