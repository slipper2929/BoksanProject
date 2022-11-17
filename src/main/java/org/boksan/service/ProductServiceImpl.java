package org.boksan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.boksan.dao.ProductDao;
import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_productDTO;
import org.boksan.model.b_stockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao pdao;
	
	
	//상품분류 select box
	public ArrayList<Product_groupDTO> product_group_select(){
		return pdao.product_group_select();
	}
	//상품등록 버튼
	public void ProductInsert(b_productDTO pdto) {
		pdao.ProductInsert(pdto);
	}
	//상품분류추가 버튼
	public void Product_group_addInsert(Product_groupDTO pgdto) {
		pdao.Product_group_addInsert(pgdto);
	}
	//발주 예상구매액
	public String price_select(String data) {
		
		return pdao.price_select(data);
		
	}
	//상품조회 리스트
	public ArrayList<b_productDTO> piproduct_select(Criteria cri){
		return pdao.piproduct_select(cri);
	}
	
	//상품조회 리스트 수정
	public void update_product(b_productDTO pdto) {
		System.out.println(pdto);
		pdao.update_product(pdto);
		
	}
	//상품조회 리스트 수정의 상품분류코드 selectBox
	public ArrayList<Product_groupDTO> gproduct_select(Criteria cri) {
		return pdao.gproduct_select(cri);
	}
	//상품조회 리스트 삭제
	public void product_list_delete(b_productDTO pdto) {
		pdao.product_list_delete(pdto);
	}
	//페이징 처리를 위한 전체건수 상품조회
	public int getTotalCountPI(Criteria cri) {
		return pdao.getTotalCountPI(cri);
	}
	
	public ArrayList<b_stockDTO> pplist_select(Criteria cri){
		System.out.println(cri);
		return pdao.pplist_select(cri);
	}
	
	public int getTotalCountPP(Criteria cri) {
		return pdao.getTotalCountPP(cri);
	}
	
	//상품 원산지 조회
	public ArrayList<b_productDTO> product_country_select(){
		
		return pdao.product_country_select();
		
	}
	
	//상품 업체 조회
	public ArrayList<b_productDTO> product_business_select(){
		
		return pdao.product_business_select();
		
	}
	
	//원산지 등록
	public String country_insert(String data) {
		
		pdao.country_insert(data);
		
		return pdao.country_last_select();
		
	}
	
	//업체 등록
	public String business_insert(String business_name_data, String business_tel_data) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("business_name_data", business_name_data);
		map.put("business_tel_data", business_tel_data);
		
		pdao.business_insert(map);
		
		return pdao.business_last_select();
		
	}
}
