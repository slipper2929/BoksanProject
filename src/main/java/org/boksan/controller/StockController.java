package org.boksan.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.boksan.model.b_movement_orderDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StockController {
	
	@Autowired
	StockService sservice;
	
	
	//�ķ�Ʈ�߰�
	@RequestMapping(value="/pallet", method=RequestMethod.POST)
	public String PostPallet(b_stockDTO sdto){
		sservice.PalletInsert(sdto);
		return "redirect:/pallet";
	
	}
	
	//�ķ�Ʈ����
	@RequestMapping(value="/pallet_delete", method=RequestMethod.POST)
	public String pallet_delete(b_stockDTO sdto) {
		System.out.println("����Ʈ:"+sdto.getPallet_num_list().get(0).getPallet_num());
		//System.out.println("����Ʈ:"+sdto.getPallet_num_list().get(1).getPallet_num());
		//System.out.println("����Ʈ:"+sdto[1].getPallet_num());
		sservice.pallet_delete(sdto);
		
		return "redirect:/pallet";
	}

	
	//�̵���� �߰�
	@RequestMapping(value="/move_order/update" , method=RequestMethod.POST)
	public String move_change(@RequestParam("pallet_num") String pallet_num, @RequestParam("movement_address") String movement_address) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("pallet_num", pallet_num);
		map.put("movement_address", movement_address);
		
		
		System.out.println("�ķ�Ʈ ��:" + pallet_num);
		System.out.println("â����� :" + movement_address);
		sservice.move_change(map);
		
		return "redirect:/move_order";
	}
	
	//�̵���� Ȯ�ι�ư
	@RequestMapping(value="/move_order_compare", method=RequestMethod.POST)
	public String moveCompare(b_stockDTO sdto,b_movement_orderDTO modto) {
		sservice.move_compare(sdto);
		sservice.move_delete(modto);
		return "redirect:/move_order_list";
	}
	
	
}
