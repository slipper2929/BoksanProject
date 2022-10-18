package org.boksan.controller;



import java.util.ArrayList;
import java.util.List;

import org.boksan.model.b_stockDTO;
import org.boksan.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StockController {
	
	@Autowired
	StockService sservice;
	
	@RequestMapping(value="/pallet", method=RequestMethod.POST)
	public String PostPallet(b_stockDTO sdto){
		sservice.PalletInsert(sdto);
		return "redirect:/pallet";
	
	}
	
	@RequestMapping(value="/pallet_delete", method=RequestMethod.POST)
	public String pallet_delete(b_stockDTO sdto) {
		System.out.println("리스트:"+sdto.getPallet_num_list().get(0).getPallet_num());
		System.out.println("리스트:"+sdto.getPallet_num_list().get(1).getPallet_num());
		//System.out.println("리스트:"+sdto[1].getPallet_num());
		sservice.pallet_delete(sdto);
		
		return "redirect:/pallet";
	}
}
