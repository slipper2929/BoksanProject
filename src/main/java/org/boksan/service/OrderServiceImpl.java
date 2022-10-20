package org.boksan.service;

import org.boksan.dao.OrderDao;
import org.boksan.model.b_arriveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao odao;
	
	public void recipe_add_insert(b_arriveDTO adto) {
		
		odao.recipe_add_insert(adto);
		
	}
	
	
}
