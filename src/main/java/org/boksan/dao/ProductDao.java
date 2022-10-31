package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_productDTO;
import org.boksan.model.b_stockDTO;


public interface ProductDao {
	
	//상품분류 select box
	public ArrayList<Product_groupDTO> product_group_select();
	//상품등록 버튼
	public void ProductInsert(b_productDTO pdto);
	//상품분류추가 버튼
	public void Product_group_addInsert(Product_groupDTO pgdto);
	//발주 예상구매액
	public String price_select(String data);
	//상품조회 리스트
	public ArrayList<b_productDTO> piproduct_select(Criteria cri);
	//상품조회 리스트 수정
	public void update_product(b_productDTO pdto);
	//상품조회 리스트 수정의 상품분류코드 selectBox
	public ArrayList<b_productDTO> gproduct_select(Criteria cri);
	//상품조회 리스트 삭제
	public void product_list_delete(b_productDTO pdto);
	//페이징 처리를 위한 전체건수 상품조회
	public int getTotalCountPI(Criteria cri);
	//상품별조회
	public ArrayList<b_stockDTO> pplist_select(Criteria cri);
	//페이징 처리를 위한 전체건수 상품별조회
	public int getTotalCountPP(Criteria cri);
}
