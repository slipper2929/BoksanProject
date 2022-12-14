package org.boksan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.boksan.dao.ProductDao;
import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_houseDTO;
import org.boksan.model.b_productDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.model.statementDTO;
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
	
	//상품조회 원산지 셀렉박스 조회
	public ArrayList<b_productDTO> cproduct_select(){
		
		return pdao.cproduct_select();
		
	}
	
	//상품조회 업체 셀렉박스 조회
	public ArrayList<b_productDTO> bproduct_select(){
		
		return pdao.bproduct_select();
		
	}
	
	//전체조회_입출고내역조회
	public ArrayList<statementDTO> in_out_record(
			Map<String, Object> record_data,
			String[] record_arr
			){
		
				record_data.put("record_arr0", record_arr[0]);
				record_data.put("record_arr1", record_arr[1]);
				record_data.put("record_arr2", record_arr[2]);

				System.out.println(record_data);
		
		
		return pdao.in_out_record(record_data);
	}
	
	//전체조회_재고조회
	public ArrayList<b_stockDTO> stock_record(
			Map<String, Object> record_data,
			String[] record_arr){
		
				record_data.put("record_arr0", record_arr[0]);
				record_data.put("record_arr1", record_arr[1]);
				record_data.put("record_arr2", record_arr[2]);
				record_data.put("record_arr3", record_arr[3]);

				System.out.println(record_data);
		
		
		return pdao.stock_record(record_data);
	}
	
	//전체조회_창고조회
	public ArrayList<b_houseDTO> house_record(
			Map<String, Object> record_data,
			String[] record_arr){
		
		record_data.put("record_arr0", record_arr[0]);
		record_data.put("record_arr1", record_arr[1]);
		record_data.put("record_arr2", record_arr[2]);
		record_data.put("record_arr3", record_arr[3]);
		
		return pdao.house_record(record_data);
	}
	
	//창고번지 입력을 위한 out_num_select
	public String[] house_out_num_select(String data) {
		
		return pdao.house_out_num_select(data);
		
	}
	
	//창고번지 입력을 위한 창고번지 조회
	public ArrayList<b_houseDTO> house_out_num_select2(Map<String, Object> map) {
		
		return pdao.house_out_num_select2(map);
		
	}
	
	
}
