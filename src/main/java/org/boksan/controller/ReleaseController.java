package org.boksan.controller;

import java.util.ArrayList;

import org.boksan.model.b_releaseDTO;
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
}
