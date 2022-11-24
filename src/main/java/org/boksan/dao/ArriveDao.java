package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.Arrive_palletDTO;
import org.boksan.model.Arrive_totalDTO;
import org.boksan.model.Criteria;
import org.boksan.model.b_arriveDTO;
import org.boksan.model.b_houseDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.model.statementDTO;

public interface ArriveDao {

	//입고대기목록
	public ArrayList<b_arriveDTO> arrive_list_select(Criteria cri);
	
	//입고대기리스트_파레트번호 가져오기
	public ArrayList<Arrive_palletDTO> arrive_list_select_pallet();
	
	//페이징 처리를 위한 전체건수
	public int getTotalCount(Criteria cri);
	
	//상품별 총 대기목록
	public ArrayList<Arrive_totalDTO> arrive_total_list();
	
	//입고대기목록_검증 insert
	public void Arrive_insert(b_stockDTO sdto);
	
	//입고대기목록_검증 후 delete
	public void Arrive_delete(int arrive_code);
	
	//입고대기목록 insert
	public void Arrive_list_insert(b_arriveDTO adto);
	
	//입출고목록 insert를 위한 product select
	public statementDTO statement_product_select(b_stockDTO sdto);
	
	//입출고목록 insert
	public void statement_arrive_insert(statementDTO stdto);
	
	//입고시 창고 now_quantity+1
	public void house_quantity_plus_update(b_houseDTO hdto);
}
