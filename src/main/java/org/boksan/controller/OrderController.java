package org.boksan.controller;

import javax.servlet.http.HttpSession;

import org.boksan.model.b_arriveDTO;
import org.boksan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
	
	@Autowired
	OrderService oservice;
	
	//발주신청버튼
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order_insert(HttpSession session, b_arriveDTO adto) {
		
		
		oservice.order_insert(session, adto);
		
		return "redirect:/order";
	}
}
