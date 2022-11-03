package org.boksan.controller;

import org.boksan.model.b_deptDTO;
import org.boksan.model.b_houseDTO;
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
	}
	
	//부서추가등록
	@RequestMapping(value="/manager_dept_group", method= RequestMethod.POST)
	public String dept_group_add(b_deptDTO ddto) {
		mgservice.dept_group_add(ddto);
		return "manager_dept_group";
	}
	
	//창고등록
	@RequestMapping(value="/manager_house_add", method = RequestMethod.POST)
	public String manager_house_add(b_houseDTO hdto) {
		mgservice.manager_house_add(hdto);
		return "manager_house_add";
	}
}
