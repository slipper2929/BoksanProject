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
	public String Arrive_insert(b_stockDTO sdto, int arrive_code) {
		
		System.out.println("dddddddddd");
		System.out.println(sdto.toString());
		System.out.println(arrive_code);
		
		
		aservice.Arrive_insert(sdto, arrive_code);
		
		return "redirect:/arrive_list";
		
	}
}
