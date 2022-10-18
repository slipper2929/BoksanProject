package org.boksan.service;


import java.util.ArrayList;

import org.boksan.model.b_stockDTO;

public interface StockService {
	
	public void PalletInsert(b_stockDTO sdto);
	
	public ArrayList<b_stockDTO> DeletePalletSelect(String data);
	
	public void pallet_delete(b_stockDTO sdto);
	
}
