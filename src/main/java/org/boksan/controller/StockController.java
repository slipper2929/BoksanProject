package org.boksan.controller;



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
		return "pallet";
	
	}
}
