package org.boksan.dao;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_productDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.model.statementDTO;


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
	public ArrayList<Product_groupDTO> gproduct_select(Criteria cri);
	//상품조회 리스트 삭제
	public void product_list_delete(b_productDTO pdto);
	//페이징 처리를 위한 전체건수 상품조회
	public int getTotalCountPI(Criteria cri);
	//상품별조회
	public ArrayList<b_stockDTO> pplist_select(Criteria cri);
	//페이징 처리를 위한 전체건수 상품별조회
	public int getTotalCountPP(Criteria cri);
	//상품 원산지 조회
	public ArrayList<b_productDTO> product_country_select();
	//상품 업체 조회
	public ArrayList<b_productDTO> product_business_select();
	//원산지 등록
	public void country_insert(String data);
	//원산지 등록 후 마지막 코드 조회
	public String country_last_select();
	//업체 등록
	public void business_insert(Map<String, Object> map);
	//업체 등록 후 마지막 코드 조회
	public String business_last_select();
	//상품조회 원산지 셀렉박스 조회
	public ArrayList<b_productDTO> cproduct_select();
	//상품조회 업체 셀렉박스 조회
	public ArrayList<b_productDTO> bproduct_select();
	//전체조회_입출고내역조회
	public ArrayList<statementDTO> in_out_record(Map<String, Object> record_data);
	//전체조회_재고조회
	public ArrayList<b_stockDTO> stock_record(Map<String, Object> record_data);
	//전체조회_입출고내역조회
	public ArrayList<statementDTO> in_out_record_excel(Map<String, Object> record_data);
}
