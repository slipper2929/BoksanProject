package org.boksan.service;

import java.util.ArrayList;

import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_productDTO;

public interface ProductService {
	
	public ArrayList<Product_groupDTO> product_group_select();
	
	public void ProductInsert(b_productDTO pdto);
	
	public void Product_group_addInsert(Product_groupDTO pgdto);
	
	//ajax 상품 가격 select
	public String price_select(String data);
	
	public ArrayList<b_productDTO> piproduct_select();
	
}
