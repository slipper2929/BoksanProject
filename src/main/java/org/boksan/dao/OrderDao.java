package org.boksan.dao;

import org.boksan.model.b_arriveDTO;
import org.boksan.model.statementDTO;

public interface OrderDao {
	
	//��ǰ����߷� üũ
	public int pallet_in_ratio_select(b_arriveDTO adto);
	
	//���ֽ�û��ư
	public void order_insert(b_arriveDTO adto);
	
	//������� insert
	public void statement_order_insert(statementDTO stdto);
	
	
}
