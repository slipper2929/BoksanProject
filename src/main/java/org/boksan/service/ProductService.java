package org.boksan.service;

import java.util.ArrayList;

import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_productDTO;

public interface ProductService {
	
	//��ǰ�з� select box
	public ArrayList<Product_groupDTO> product_group_select();
	//��ǰ��� ��ư
	public void ProductInsert(b_productDTO pdto);
	//��ǰ�з��߰� ��ư
	public void Product_group_addInsert(Product_groupDTO pgdto);
	//���� ���󱸸ž�
	public String price_select(String data);
	//��ǰ��ȸ ����Ʈ
	public ArrayList<b_productDTO> piproduct_select();
	
}
