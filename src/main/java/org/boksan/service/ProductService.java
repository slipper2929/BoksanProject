package org.boksan.service;

import java.util.ArrayList;

import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_productDTO;

public interface ProductService {
	
	//상품분류 select box
	public ArrayList<Product_groupDTO> product_group_select();
	//상품등록 버튼
	public void ProductInsert(b_productDTO pdto);
	//상품분류추가 버튼
	public void Product_group_addInsert(Product_groupDTO pgdto);
	//발주 예상구매액
	public String price_select(String data);
	//상품조회 리스트
	public ArrayList<b_productDTO> piproduct_select();
	
}
