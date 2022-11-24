package org.boksan.dao;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.b_arriveDTO;
import org.boksan.model.b_empDTO;
import org.boksan.model.b_releaseDTO;
import org.boksan.model.b_release_listDTO;
import org.boksan.model.materiaDTO;
import org.boksan.model.statementDTO;

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
	
	//pallet_num select2
	public String pallet_num_select2(String pallet_num);
	
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
	
	//recipe select
	public ArrayList<String> recipe_select();
	
	//출고요청 회원정보를 조회
	public b_empDTO emp_select(String userId);
	
	//출고지시화면에서 발주하기 모달창 상품의 재고 select
	public String release_order(int data);
	
	//출고지시화면에서 발주하기 모달창 상품의 재고의 구매가 select
	public String release_order_price_select(int data);
	
	//출고지시화면에서 발주하기 모달창 상품의 재고 발주하기 insert
	public void release_pay_order(b_arriveDTO adto);
	
	//출고요청시 재고조회를 위한 그룹타입조회
	public String pc_group_type_select(String pc_arr);
	
	//출고요청시 해당 상품코드로 재고조회 true,false select
	public String pc_stock_check_select(Map<String, Object> map);
	
	//입출고목록select를 위한 product_code select
	public String statement_product_code_select(String release_list_code);
	
	//입출고목록 insert
	public void statement_release_insert(statementDTO stdto);
	
	//입출고목록(발주) insert
	public void statement_release_oder_insert(statementDTO stdto);
	
	//릴리즈리스트 마지막행 찾아서 프라이머리키 저장
	public String release_order_list_primary_select();
	
	//스테이트스톡(새거)에 insert(위에 코드에서 찾은 파레트넘으로 우리도 정보를 셀렉해서 새 테이블에 인설트해줄거임)
	public void state_stock_insert(String pallet_num2);
	
	//방금넣은친구 프라이머리키 가져오고(마지막행을 찾으면 위에 친구 찾을수있음)
	public String state_stock_primary_select();
	
	//그 프라이머리키를 릴리즈리스트에 업데이트
	public void release_list_state_update(Map<String,Object> map);
	
	//product_code가 null일때 state_num을 이용해서 product_code를 셀렉
	public String state_stock_product_code_select(int data);
	
	//state_stock delete
	public void state_stock_delete(int data);
}
