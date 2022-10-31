package org.boksan.service;

import org.boksan.dao.OrderDao;
import org.boksan.model.b_arriveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao odao;
	//발주신청버튼
	public void order_insert(b_arriveDTO adto) {
		
		int select_num = odao.pallet_in_ratio_select(adto);
		System.out.println("상품허용중량 : ");
		System.out.println(select_num);
		
		if(adto.getArrive_num() > select_num) {
			
			int minus_num;
			
			while(true) {
				
				if(select_num >= adto.getArrive_num()) {
					odao.order_insert(adto);
					break;
				}
				
				minus_num = adto.getArrive_num() - select_num;
				adto.setArrive_num(select_num);
				odao.order_insert(adto);
				adto.setArrive_num(minus_num);
				
			}
			 
		} else {
			odao.order_insert(adto);
		}
		
	}
	
	
}
