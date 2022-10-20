package org.boksan.controller;

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
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order_insert(b_arriveDTO adto) {
		
		
		oservice.recipe_add_insert(adto);
		
		return "order";
	}
}
