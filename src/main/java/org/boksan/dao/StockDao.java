package org.boksan.dao;


import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.b_houseDTO;
import org.boksan.model.b_stockDTO;

public interface StockDao {
	
	//파레트 추가
	public void PalletInsert(b_stockDTO sdto);
	//삭제할 파레트 찾기
	public ArrayList<b_stockDTO> DeletePalletSelect(String data);
	//파레트 삭제
	public void pallet_delete(b_stockDTO sdto);
	//이동지시 리스트
	public ArrayList<b_stockDTO> moveList(Criteria cri);
	
	
	
	//이동지시 -> 이동목록 insert
	public void move_change(Map<String, Object> map);
	
	//페이징 처리를 위한 전체건수 이동지시
	public int getTotalCountMo(Criteria cri);
	//페이징 처리를 위한 전체건수 이동목록
	public int getTotalCountMol(Criteria cri);
	
	//이동목록 리스트
	public ArrayList<b_stockDTO> move_list(Criteria cri);
	//이동목록 이동할주소
	public ArrayList<String> movement(Criteria cri);
	//이동목록 주소 확인버튼
	public void move_compare(b_stockDTO sdto);
	//이동목록 확인버튼 누르면 이동목록 리스트에서 삭제
	public void move_delete(b_stockDTO sdto);
	//이동목록 주소 동일한지 확인
	public String changeHouse(String data);
	//로케이션별 위치조회
	public ArrayList<b_stockDTO> location_select(Criteria cri);		
	//페이징 처리를 위한 전체건수 로케이션별
	public int getTotalCountLI(Criteria cri);
	
}
