package org.boksan.controller;

import javax.servlet.http.HttpSession;

import org.boksan.model.b_releaseDTO;
import org.boksan.model.b_release_listDTO;
import org.boksan.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReleaseController {

	@Autowired
	ReleaseService rservice;
	
	//����û
	@RequestMapping(value = "/release", method = RequestMethod.POST)
	public String release_insert(b_releaseDTO rdto) {
		
		rservice.release_insert(rdto);
		
		return "redirect:/release_state_inquiry";
		
	}
	
	//����û��ϸ���Ʈinsert
	@RequestMapping(value = "/release_pay", method = RequestMethod.POST)
	public String release_order_list_insert(b_release_listDTO rldto) {
		System.out.println("��Ʈ�ѷ��� �ѿ��� rldto : ");
		System.out.println(rldto);
		
		System.out.println("���񽺴� ������ : ");
		rservice.release_order_list_insert(rldto);
		
		return "redirect:/release_pay";
	}
	
	//��� update
	@RequestMapping(value = "/release_stock_update", method = RequestMethod.POST)
	public String release_stock_update(HttpSession session, b_release_listDTO rldto) {
		
		System.out.println(rldto);
		
		rservice.release_stock_update(session, rldto);
		
		return "redirect:/release_order_list";
	}
	
	//����������������� �����ϱ�
	@RequestMapping(value = "/release_pay_order", method = RequestMethod.POST)
	public String release_pay_order(
				HttpSession session,
				@RequestParam(value="order_num_count") int order_num_count,
				@RequestParam(value="product_code") int product_code
			) {
			
			rservice.release_pay_order(session, order_num_count, product_code);
		
		return "redirect:/release_pay";
	}
}
