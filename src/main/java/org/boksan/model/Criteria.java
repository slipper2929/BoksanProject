package org.boksan.model;

public class Criteria {
	
	// �˻� ����(����, ����...)
	private String type;
	// �˻���(Ű����)
	private String keyword;
	// pagenum
	private int pagenum;
	// �������� �� �����ִ� �Ǽ�
	private int amount;
	
	private String pcategory;
	
	//�����ڸ� �̿��� �ʱ�ȭ
	Criteria(){
		this(1,20);
	}
	
	Criteria(int pagenum, int amount){
		this.pagenum=pagenum;
		this.amount=amount;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getPcategory() {
		return pcategory;
	}

	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}

	@Override
	public String toString() {
		return "Criteria [type=" + type + ", keyword=" + keyword + ", pagenum=" + pagenum + ", amount=" + amount + "]";
	}
}
