package org.boksan.service;

import javax.servlet.http.HttpSession;

import org.boksan.model.b_arriveDTO;

public interface OrderService {
	//���ֽ�û��ư
	public void order_insert(HttpSession session, b_arriveDTO adto);

}
