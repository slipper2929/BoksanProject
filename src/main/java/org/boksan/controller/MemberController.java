package org.boksan.controller;

//import javax.inject.Inject;

import org.boksan.model.b_empDTO;
import org.boksan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Autowired
	MemberService mservice;
	
	//@Inject
	BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
	
	//회원가입요청
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinInsert(b_empDTO edto) {
		
		String inputPass = edto.getPassword();
		String password = pwdEncoder.encode(inputPass);
		edto.setPassword(password);
		
		mservice.MemberInsert(edto);
		return "index";
	}
}
