package org.boksan.model;

public class PageDTO {
	
	// ����������
	private int startPage;
	// ��������
	private int endPage;
	// ����
	private boolean prev;
	// ����
	private boolean next;
	// ��ü �Ǽ�
	private int total;
	//PageDTOŬ������ Criteria Ŭ������ ���Խ��� �����ϰ��� �ϴ� ���� ����
	private Criteria cri;
	
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public PageDTO(Criteria cri, int total) {
		this.cri=cri;
		this.total=total;
		// ����ڰ� ������ ��������ȣ
		this.endPage=(int)(Math.ceil(cri.getPagenum() / 10.0))*10;
		
		this.startPage=this.endPage-9;
		System.out.println(this.endPage);
		// ��ü�Ǽ� / �������� �� �Խ��� ����
		System.out.println(total);
		int realEnd = (int)(Math.ceil(total*1.0/cri.getAmount()));
		System.out.println(realEnd);
		// endPage������ ����Ǿ� �ִ� ������ realEnd���� �� ������
		if(realEnd < this.endPage) {
			//realEnd���� endPage������ ����.
			this.endPage=realEnd;
		}
		
		// 2) ����, ���� ��ư ��� ó��
		//����
		this.prev = this.startPage > 1;
		//����
		this.next = this.endPage < realEnd;
	}
	
	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
}
