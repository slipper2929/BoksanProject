package org.boksan.controller;

import java.util.ArrayList;
import java.util.List;

import org.boksan.model.b_empDTO;
import org.boksan.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManagerController {
	
	@Autowired
	ManagerService mgservice;
	
	@RequestMapping(value="/emp_delete", method = RequestMethod.POST)
	public String emp_delete(@RequestParam(value="emp_code") String[] edto) {
		//System.out.println("모가올까요??");
		//System.out.println(edto[0]);
		//System.out.println(edto[1]);
		mgservice.emp_delete(edto);
		return "redirect:/manager_emp_inquiry";
		
		//submit 되기전에 체크된 것들 값 주기
	}
}
