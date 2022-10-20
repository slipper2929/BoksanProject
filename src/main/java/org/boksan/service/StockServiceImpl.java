package org.boksan.service;


import java.util.ArrayList;
import java.util.Map;

import org.boksan.dao.StockDao;
import org.boksan.model.Criteria;
import org.boksan.model.b_stockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockDao sdao;
	
	public void PalletInsert(b_stockDTO sdto) {
		
		for(int i = 0; i < sdto.getPallet_count(); i++) {
			sdao.PalletInsert(sdto);	
		}
		
	}
	
	//빈 파레트 조회
	
	public ArrayList<b_stockDTO> DeletePalletSelect(String data){
		System.out.println("서비스단" + data);
		return sdao.DeletePalletSelect(data);
		
	}
	
	//파레트 삭제
	public void pallet_delete(b_stockDTO sdto) {
		
		for(int i = 0; i < sdto.getPallet_num_list().size(); i++) {
			sdto.setPallet_num(sdto.getPallet_num_list().get(i).getPallet_num());
			sdao.pallet_delete(sdto);
		}
		
	}
	
	//이동지시 리스트
	public ArrayList<b_stockDTO> moveList(Criteria cri){
		return sdao.moveList(cri);
	}
	
	//이동지시 -> 이동목록 insert
	public void move_change(Map<String, Object> map) {
		sdao.move_change(map);
	}
	
	public int getTotalCountMo(Criteria cri) {
		return sdao.getTotalCountMo(cri);
	}
	
	public int getTotalCountMol(Criteria cri) {
		return sdao.getTotalCountMol(cri);
	}
	
	public ArrayList<b_stockDTO> move_list(Criteria cri){
		return sdao.move_list(cri);
	}
	
	public ArrayList<String> movement(Criteria cri){
		return sdao.movement(cri);
	}
	
	public void move_compare(b_stockDTO sdto) {
		
		sdao.move_compare(sdto);
		System.out.println(sdto.getPallet_num());
		sdao.move_delete(sdto);
	}
	
	
}
