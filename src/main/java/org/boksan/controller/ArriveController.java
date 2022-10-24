package org.boksan.controller;

import org.boksan.model.b_stockDTO;
import org.boksan.service.ArriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArriveController {
	
	@Autowired
	ArriveService aservice;
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String Arrive_insert(b_stockDTO sdto) {
		
		System.out.println("dddddddddd");
		System.out.println(sdto.toString());
		
		
		aservice.Arrive_insert(sdto);
		
		return "redirect:/arrive_list";
		
	}
}
