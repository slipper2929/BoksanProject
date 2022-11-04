package org.boksan.dao;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.b_releaseDTO;
import org.boksan.model.b_release_listDTO;
import org.boksan.model.materiaDTO;

public interface ReleaseDao {

	//총중량 select
	public int gross_weight_select(Map<String, Object> objdata);
	
	//출고요청 레시피기준 조회(release.js)
	public ArrayList<materiaDTO> release_recipe_select(Map<String, Object> objdata);
	
	//출고요청 insert
	public void release_insert(b_releaseDTO rdto);
	
	//출고요청처리현황 select
	public ArrayList<b_releaseDTO> release_state_inquiry_select(Criteria cri);
	
	//페이징 처리를 위한 전체건수
	public int getTotalCount(Criteria cri);
	
	//출고요청결제 select
	public ArrayList<b_releaseDTO> release_pay_select(Criteria cri);
	
	//페이징 처리를 위한 전체건수
	public int getTotalCount_pay(Criteria cri);
	
	//출고요청목록을 위한 파레트목록 select
	public ArrayList<b_release_listDTO> getPalletList(b_release_listDTO rldto);
	
	//출고요청목록 insert
	public void release_order_list_insert(b_release_listDTO rldto);
	
	//출고요청처리현황 update
	public void release_update(b_release_listDTO rldto);
	
	//출고요청결제 취소
	public void release_cancel(int data);
	
	//출고지시목록
	public ArrayList<b_release_listDTO> release_order_list(Criteria cri);
	
	//페이징 처리를 위한 전체건수(출고지시목록)
	public int getTotalCount_order(Criteria cri);
	
	//pallet_num select
	public int pallet_num_select(String pallet_num);
	
	//재고 update
	public void release_stock_update(b_release_listDTO rldto);
	
	//재고 update(파레트넘이랑 출고)
	public void release_stock_update_zero(b_release_listDTO rldto);
	
	//release_list 삭제
	public void release_list_delete(b_release_listDTO rldto);
	
	//release 삭제를 위한 release_list 조회
	public int release_list_check(b_release_listDTO rldto);
	
	//release 삭제
	public void release_delete(b_release_listDTO rldto);
}
