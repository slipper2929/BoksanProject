package org.boksan.service;

import java.util.ArrayList;


import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_productDTO;
import org.boksan.model.b_stockDTO;

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
	public ArrayList<b_productDTO> piproduct_select(Criteria cri);
	//��ǰ��ȸ ����Ʈ ����
	public void update_product(b_productDTO pdto);
	//��ǰ��ȸ ����Ʈ ������ ��ǰ�з��ڵ� selectBox
	public ArrayList<Product_groupDTO> gproduct_select(Criteria cri);
	//��ǰ��ȸ ����Ʈ ����
	public void product_list_delete(b_productDTO pdto);
	//����¡ ó���� ���� ��ü�Ǽ� ��ǰ��ȸ
	public int getTotalCountPI(Criteria cri);
	//��ǰ����ȸ
	public ArrayList<b_stockDTO> pplist_select(Criteria cri);
	//����¡ ó���� ���� ��ü�Ǽ� ��ǰ����ȸ	
	public int getTotalCountPP(Criteria cri);
	
	//��ǰ ������ ��ȸ
	public ArrayList<b_productDTO> product_country_select();
	
	//��ǰ ��ü ��ȸ
	public ArrayList<b_productDTO> product_business_select();
	
	//������ ���
	public String country_insert(String data);
	
	//��ü ���
	public String business_insert(String business_name_data, String business_tel_data);
	
	//��ǰ��ȸ ������ �����ڽ� ��ȸ
	public ArrayList<b_productDTO> cproduct_select();
	
	//��ǰ��ȸ ��ü �����ڽ� ��ȸ
	public ArrayList<b_productDTO> bproduct_select();
	
}
