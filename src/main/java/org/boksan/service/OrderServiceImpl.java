package org.boksan.service;

import javax.servlet.http.HttpSession;

import org.boksan.dao.ArriveDao;
import org.boksan.dao.OrderDao;
import org.boksan.model.b_arriveDTO;
import org.boksan.model.b_empDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.model.statementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao odao;
	
	@Autowired
	ArriveDao adao;
	
	//발주신청버튼
	public void order_insert(HttpSession session, b_arriveDTO adto) {
		
		b_empDTO user = (b_empDTO) session.getAttribute("member");
		
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
		
		statementDTO stdto = new statementDTO();
		b_stockDTO sdto = new b_stockDTO();
		sdto.setProduct_code(adto.getProduct_code());
		
		stdto.setEmp_code(user.getEmp_code());
		stdto.setEmp_name(user.getName());
		stdto.setEmp_tel(user.getTel());
		stdto.setProduct_code(adto.getProduct_code());
		
		statementDTO product_select = adao.statement_product_select(sdto);
		
		stdto.setProduct_name(product_select.getProduct_name());
		stdto.setProduct_country(product_select.getProduct_country());
		stdto.setProduct_business(product_select.getProduct_business());
		stdto.setProduct_price(product_select.getProduct_price()*adto.getArrive_num());
		stdto.setQuantity(adto.getArrive_num());
		System.out.println("stdto임");
		System.out.println(stdto);
		odao.statement_order_insert(stdto);
		
		
	}
	
	
}
