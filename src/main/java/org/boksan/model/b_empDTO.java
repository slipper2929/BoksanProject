package org.boksan.model;

public class b_empDTO {
	
	//name
	private String name;
	
	//socialnum
	private String socialnum;
	
	//address
	private String address;
	
	//dept_code
	private int dept_code;
	
	//id
	private String id;
	
	//password
	private String password;

	
	//getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocialnum() {
		return socialnum;
	}

	public void setSocialnum(String socialnum) {
		this.socialnum = socialnum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDept_code() {
		return dept_code;
	}

	public void setDept_code(int dept_code) {
		this.dept_code = dept_code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "b_empDTO [name=" + name + ", socialnum=" + socialnum + ", address=" + address + ", dept_code="
				+ dept_code + ", id=" + id + ", password=" + password + "]";
	}
	
	
}
