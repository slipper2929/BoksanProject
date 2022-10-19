package org.boksan.service;


import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.b_stockDTO;

public interface StockService {
	
	public void PalletInsert(b_stockDTO sdto);
	
	public ArrayList<b_stockDTO> DeletePalletSelect(String data);
	
	public void pallet_delete(b_stockDTO sdto);
	
	public ArrayList<b_stockDTO> moveList(Criteria cri);
	
	//이동지시 -> 이동목록 insert
	public void move_change(Map<String, Object> map);
	
	public int getTotalCount(Criteria cri);
	
}
