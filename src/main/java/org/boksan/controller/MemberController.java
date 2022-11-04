package org.boksan.controller;

import javax.servlet.http.HttpSession;

//import javax.inject.Inject;

import org.boksan.model.b_empDTO;
import org.boksan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {
	@Autowired
	MemberService mservice;
	
	//@Inject
	BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
	
	//ȸ�����Կ�û
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinInsert(b_empDTO edto) {
		
		String inputPass = edto.getPassword();
		String password = pwdEncoder.encode(inputPass);
		edto.setPassword(password);
		
		mservice.MemberInsert(edto);
		return "index";
	}
	
	//�α���
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(b_empDTO edto, HttpSession session, RedirectAttributes rttr) {
		session.getAttribute("member");
		b_empDTO Login = mservice.Login(edto);
		boolean pwdMatch = pwdEncoder.matches(edto.getPassword(), Login.getPassword());
		
		if(Login != null && pwdMatch == true) {
			session.setAttribute("member", Login);
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}
		
		return "redirect:/";
	}
	
	//�α׾ƿ�
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session){
		
		//session.invalidate();
		
		return "redirect:/";
	}
	
	//���̵� �ߺ� üũ
	
	
	// �н����� üũ
//	@ResponseBody
//	@RequestMapping(value="/passChk", method = RequestMethod.POST)
//	public boolean passChk(b_empDTO edto){
//
//		b_empDTO Login = mservice.Login(edto);
//		boolean pwdChk = pwdEncoder.matches(edto.getPassword(), Login.getPassword());
//		return pwdChk;
//	}
	
}
