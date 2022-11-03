package org.boksan.controller;

import org.boksan.model.b_releaseDTO;
import org.boksan.model.b_release_listDTO;
import org.boksan.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReleaseController {

	@Autowired
	ReleaseService rservice;
	
	//출고요청
	@RequestMapping(value = "/release", method = RequestMethod.POST)
	public String release_insert(b_releaseDTO rdto) {
		
		rservice.release_insert(rdto);
		
		return "redirect:/release_state_inquiry";
		
	}
	
	//출고요청목록리스트insert
	@RequestMapping(value = "/release_pay", method = RequestMethod.POST)
	public String release_order_list_insert(b_release_listDTO rldto) {
		System.out.println("컨트롤러에 넘오온 rldto : ");
		System.out.println(rldto);
		
		System.out.println("서비스단 들어가는중 : ");
		rservice.release_order_list_insert(rldto);
		
		return "redirect:/release_pay";
	}
}
