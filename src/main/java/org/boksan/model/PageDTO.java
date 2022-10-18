package org.boksan.model;

public class PageDTO {
	
	// 시작페이지
	private int startPage;
	// 끝페이지
	private int endPage;
	// 이전
	private boolean prev;
	// 다음
	private boolean next;
	// 전체 건수
	private int total;
	//PageDTO클래스에 Criteria 클래스를 포함시켜 제장하고자 하는 변수 선언
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
		// 사용자가 선택한 페이지번호
		this.endPage=(int)(Math.ceil(cri.getPagenum() / 10.0))*10;
		
		this.startPage=this.endPage-9;
		System.out.println(this.endPage);
		// 전체건수 / 한페이지 당 게시판 갯수
		System.out.println(total);
		int realEnd = (int)(Math.ceil(total*1.0/cri.getAmount()));
		System.out.println(realEnd);
		// endPage변수에 저장되어 있는 값보다 realEnd값이 더 작으면
		if(realEnd < this.endPage) {
			//realEnd값을 endPage변수에 저장.
			this.endPage=realEnd;
		}
		
		// 2) 이전, 다음 버튼 어떤식 처리
		//이전
		this.prev = this.startPage > 1;
		//다음
		this.next = this.endPage < realEnd;
	}
	
	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
}
