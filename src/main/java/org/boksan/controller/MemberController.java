package org.boksan.controller;

import org.boksan.model.b_empDTO;
import org.boksan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Autowired
	MemberService mservice;
	
	//ȸ�����Կ�û
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinInsert(b_empDTO edto) {
		mservice.MemberInsert(edto);
		return "index";
	}
}
