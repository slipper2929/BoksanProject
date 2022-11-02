package org.boksan.model;

public class b_empDTO {
	
	//emp_code
	private int emp_code;
	
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
	
	private b_deptDTO b_dept;
	
	private b_approveDTO b_approve;
	

	public b_approveDTO getB_approve() {
		return b_approve;
	}

	public void setB_approve(b_approveDTO b_approve) {
		this.b_approve = b_approve;
	}

	public b_deptDTO getB_dept() {
		return b_dept;
	}

	public void setB_dept(b_deptDTO b_dept) {
		this.b_dept = b_dept;
	}

	//getter and setter
	public int getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}
	
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
		return "b_empDTO [emp_code=" + emp_code + ", name=" + name + ", socialnum=" + socialnum + ", address=" + address
				+ ", dept_code=" + dept_code + ", id=" + id + ", password=" + password + "]";
	}
	
	
}
