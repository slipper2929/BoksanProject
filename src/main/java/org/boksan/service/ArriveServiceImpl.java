package org.boksan.service;

import java.util.ArrayList;

import org.boksan.dao.ArriveDao;
import org.boksan.model.Arrive_palletDTO;
import org.boksan.model.Arrive_totalDTO;
import org.boksan.model.Criteria;
import org.boksan.model.b_arriveDTO;
import org.boksan.model.b_stockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArriveServiceImpl implements ArriveService{

	@Autowired
	ArriveDao adao;
	
	//입고대기목록
	public ArrayList<b_arriveDTO> arrive_list_select(Criteria cri){
		
		return adao.arrive_list_select(cri);
		
	}
	
	//입고대기목록_파레트_select
	public ArrayList<Arrive_palletDTO> arrive_list_select_pallet(){
		
		return adao.arrive_list_select_pallet();
		
	}
	
	//페이징 처리를 위한 전체건수
	public int getTotalCount(Criteria cri) {
		
		return adao.getTotalCount(cri);
		
	}
	
	//상품별 총 대기목록
	public ArrayList<Arrive_totalDTO> arrive_total_list(){
		
		return adao.arrive_total_list();
		
	}
	
	//입고대기목록_검증 insert
	public void Arrive_insert(b_stockDTO sdto) {
		
		adao.Arrive_insert(sdto);
		
	}
}
