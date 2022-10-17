package org.boksan.service;


import java.util.ArrayList;

import org.boksan.dao.StockDao;
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
	
	public ArrayList<b_stockDTO> DeletePalletSelect(String data){
		System.out.println("서비스단" + data);
		return sdao.DeletePalletSelect(data);
		
	}
	
	
}
