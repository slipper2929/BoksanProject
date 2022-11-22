package org.boksan.dao;

import org.boksan.model.b_arriveDTO;
import org.boksan.model.statementDTO;

public interface OrderDao {
	
	//상품허용중량 체크
	public int pallet_in_ratio_select(b_arriveDTO adto);
	
	//발주신청버튼
	public void order_insert(b_arriveDTO adto);
	
	//입출고목록 insert
	public void statement_order_insert(statementDTO stdto);
	
	
}
