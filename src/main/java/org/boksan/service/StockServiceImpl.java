package org.boksan.service;


import java.util.ArrayList;
import java.util.Map;

import org.boksan.dao.StockDao;
import org.boksan.model.Criteria;
import org.boksan.model.b_houseDTO;
import org.boksan.model.b_movement_orderDTO;
import org.boksan.model.b_stockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockDao sdao;
	
	//재고조회
	public ArrayList<b_stockDTO> stock(Criteria cri){
		return sdao.stock(cri);
	}
	//상품총재고
	public ArrayList<b_stockDTO> stockAll(){
		return sdao.stockAll();
	}
	public int getTotalCountS(Criteria cri) {
		return sdao.getTotalCountS(cri);
	}
	//파레트 추가
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
	//페이징 처리를 위한 전체건수 이동지시
	public int getTotalCountMo(Criteria cri) {
		return sdao.getTotalCountMo(cri);
	}
	//페이징 처리를 위한 전체건수 이동목록
	public int getTotalCountMol(Criteria cri) {
		return sdao.getTotalCountMol(cri);
	}
	//이동목록 리스트
	public ArrayList<b_stockDTO> move_list(Criteria cri){
		return sdao.move_list(cri);
	}
	//이동목록 이동할주소
	public ArrayList<String> movement(Criteria cri){
		return sdao.movement(cri);
	}
	
	//이동목록 주소 확인버튼
	public void move_compare(b_stockDTO sdto) {
		sdao.move_compare(sdto);
		String num = sdto.getHouse_code();
		String move = sdto.getMovement_address();
		System.out.println(num);
		System.out.println(move);
		System.out.println(sdto.getPallet_num());
		sdao.move_quantity_plus(move);
		sdao.move_quantity_minus(num);
		
	}
	 //이동목록 확인버튼 누르면 이동목록 리스트에서 삭제
	public void move_delete(b_movement_orderDTO modto) {
		sdao.move_delete(modto);
	}
	//이동목록 주소 동일한지 확인
	public String changeHouse(String data){
		return sdao.changeHouse(data);
	}
	
	//로케이션별 위치조회
	public ArrayList<b_stockDTO> location_select(Criteria cri){
		return sdao.location_select(cri);
	}
			
	//페이징 처리를 위한 전체건수 로케이션별
	public int getTotalCountLI(Criteria cri) {
		return sdao.getTotalCountLI(cri);
	}
	
	
}
