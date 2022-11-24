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
	
	
	//��ǰ�з� select box
	public ArrayList<Product_groupDTO> product_group_select(){
		return pdao.product_group_select();
	}
	//��ǰ��� ��ư
	public void ProductInsert(b_productDTO pdto) {
		pdao.ProductInsert(pdto);
	}
	//��ǰ�з��߰� ��ư
	public void Product_group_addInsert(Product_groupDTO pgdto) {
		pdao.Product_group_addInsert(pgdto);
	}
	//���� ���󱸸ž�
	public String price_select(String data) {
		
		return pdao.price_select(data);
		
	}
	//��ǰ��ȸ ����Ʈ
	public ArrayList<b_productDTO> piproduct_select(Criteria cri){
		return pdao.piproduct_select(cri);
	}
	
	//��ǰ��ȸ ����Ʈ ����
	public void update_product(b_productDTO pdto) {
		System.out.println(pdto);
		pdao.update_product(pdto);
		
	}
	//��ǰ��ȸ ����Ʈ ������ ��ǰ�з��ڵ� selectBox
	public ArrayList<Product_groupDTO> gproduct_select(Criteria cri) {
		return pdao.gproduct_select(cri);
	}
	//��ǰ��ȸ ����Ʈ ����
	public void product_list_delete(b_productDTO pdto) {
		pdao.product_list_delete(pdto);
	}
	//����¡ ó���� ���� ��ü�Ǽ� ��ǰ��ȸ
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
	
	//��ǰ ������ ��ȸ
	public ArrayList<b_productDTO> product_country_select(){
		
		return pdao.product_country_select();
		
	}
	
	//��ǰ ��ü ��ȸ
	public ArrayList<b_productDTO> product_business_select(){
		
		return pdao.product_business_select();
		
	}
	
	//������ ���
	public String country_insert(String data) {
		
		pdao.country_insert(data);
		
		return pdao.country_last_select();
		
	}
	
	//��ü ���
	public String business_insert(String business_name_data, String business_tel_data) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("business_name_data", business_name_data);
		map.put("business_tel_data", business_tel_data);
		
		pdao.business_insert(map);
		
		return pdao.business_last_select();
		
	}
	
	//��ǰ��ȸ ������ �����ڽ� ��ȸ
	public ArrayList<b_productDTO> cproduct_select(){
		
		return pdao.cproduct_select();
		
	}
	
	//��ǰ��ȸ ��ü �����ڽ� ��ȸ
	public ArrayList<b_productDTO> bproduct_select(){
		
		return pdao.bproduct_select();
		
	}
	
	//��ü��ȸ_���������ȸ
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
	
	//��ü��ȸ_�����ȸ
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
	
	//��ü��ȸ_â����ȸ
	public ArrayList<b_houseDTO> house_record(
			Map<String, Object> record_data,
			String[] record_arr){
		
		record_data.put("record_arr0", record_arr[0]);
		record_data.put("record_arr1", record_arr[1]);
		record_data.put("record_arr2", record_arr[2]);
		record_data.put("record_arr3", record_arr[3]);
		
		return pdao.house_record(record_data);
	}
	
	//â����� �Է��� ���� out_num_select
	public String[] house_out_num_select(String data) {
		
		return pdao.house_out_num_select(data);
		
	}
	
	
}
