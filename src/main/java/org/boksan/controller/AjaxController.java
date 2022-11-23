package org.boksan.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.boksan.model.Product_selectDTO;
import org.boksan.model.b_productDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.model.materiaDTO;
import org.boksan.model.statementDTO;
import org.boksan.service.ArriveService;
import org.boksan.service.ManagerService;
import org.boksan.service.ProductService;
import org.boksan.service.RecipeService;
import org.boksan.service.ReleaseService;
import org.boksan.service.StockService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;





@RestController
public class AjaxController {
	
	
	@Autowired
	RecipeService rservice; 
	
	@Autowired
	StockService sservice; 
	
	@Autowired
	ArriveService aservice;
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	ReleaseService relservice;
	
	@Autowired
	ManagerService mgservice;
	
	
	
	//���� select box  (product_select.js)
	@GetMapping(value = "/testajax",
			produces = "application/json; charset=utf-8")
	
	//@GetMapping("/testajax")
	public ArrayList<Product_selectDTO> product_select_ajax(String data) {
		//Map<String, String> result = new HashMap<>();
		//result.put("result", "success");
		//String res = data;
		
		//model.addAttribute("plist",rservice.recipe_add_pselect(data));
		System.out.println(data);
		
		ArrayList<Product_selectDTO> res = rservice.recipe_add_pselect(data);
		System.out.println(res);
		
		return res;
	}
	
	
	//�� �ķ�Ʈ ��ȸ (pallet.js)
	@GetMapping(value = "/delete_pallet_select",
			produces = "application/json; charset=utf-8")
	
	public ArrayList<b_stockDTO> delete_pallet_select(String data){
		System.out.println(data);
		
		ArrayList<b_stockDTO> dps = sservice.DeletePalletSelect(data);
		System.out.println(dps);
		return dps;
	}
	
	
	//�̵����ÿϷ� (move_order.js)
	@PostMapping(value="/changeHouse",
			produces = "application/json; charset=utf-8")
	public String changeHouse(String data){
		System.out.println(data);
		String change = sservice.changeHouse(data);
		System.out.println(change);
		return change;
	}
	
	
	//���� ���󱸸ž� (order.js)
	@GetMapping(value="/price_select",
			produces = "application/json; charset=utf-8")
	public String price_select(String data) {
		
		String res = pservice.price_select(data);
		
		return res;
		
	}	
	
	//��ǰ��ȸ ����Ʈ ����
	@PostMapping(value = "/product_Iupdate",
			produces = "application/json; charset=utf-8")
	public b_productDTO product_Iupdate_ajax(b_productDTO pdto) {
		System.out.println("�� : " + pdto);
		pservice.update_product(pdto);
		System.out.println("�� : " + pdto);
		
		return pdto;
	}

	
	//����û �����Ǳ��� ��ȸ(release.js)materiaDTO
	@GetMapping(value="/release_recipe_select",
			produces = "application/json; charset=utf-8")
	public ArrayList<materiaDTO> release_recipe_select(@RequestParam Map<String, Object> objdata) {
		
		System.out.println(objdata);
		return relservice.release_recipe_select(objdata);
	}
	

	//������ȸ �����Ϸ�
	@PostMapping(value="/emp_update",
			produces = "application/json; charset=utf-8")
	public String emp_update(@RequestParam(value="emp_arr") String[] emp_arr, @RequestParam(value="dept_arr") String[] dept_arr) {
		mgservice.emp_update(emp_arr,dept_arr);
		
		return "�μ��� ����Ǿ����ϴ�.";
	}
	

	//����û���� ���
	@PostMapping(value = "/release_cancel",
			produces = "application/json; charset=utf-8")
	public String release_cancel(int data) {
		
		relservice.release_cancel(data);
		
		return "��Ұ� �Ǿ����ϴ�.";
	}
	
	//�������ȭ�鿡�� �����ϱ� ���â ��ǰ�� ��� select
	@GetMapping(value = "/release_order",
			produces = "application/json; charset=utf-8")
	public Map<String, Object> release_order(int data) {
		
		String res = relservice.release_order(data);
		String data_price = relservice.release_order_price_select(data);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		map.put("data", res);
		map.put("data_price", data_price);
		
		return map;
	}
	


	//���ο�û
	@PostMapping(value="/approve_success",
			produces = "application/json; charset=utf-8")
	public String manager_approve(@RequestParam(value="emp_val") String[] emp_val,@RequestParam(value="dept_val") String[] dept_val) {

		mgservice.manager_approve(emp_val, dept_val);
		return "������ ���εǾ����ϴ�.";
	}
	//���԰���
	@PostMapping(value="/approve_sorry",
			produces = "application/json; charset=utf-8")
	public String manager_approve(@RequestParam(value="emp_val") String[] emp_val) {
		System.out.println("���� : " + emp_val.length);
		mgservice.emp_delete(emp_val);
		return "�����Ǿ����ϴ�.";
	}
	
	//����û�� �����ȸ
	@GetMapping(value="/release_stock_check",
			produces = "application/json; charset=utf-8")
	public String[] release_stock_check(@RequestParam(value="pc_arr") String[] pc_arr,@RequestParam(value="rn_arr") String[] rn_arr) {
		
		String[] res = relservice.release_stock_check(pc_arr, rn_arr);
		
		return res;
		
	}
	
	//������ ��� 
	@PostMapping(value="/country_insert",
			produces = "application/json; charset=utf-8")
	public String country_insert(String data) {

		String result = pservice.country_insert(data);
		
		return result;
		
	}
	
	//��ü ��� 
	@PostMapping(value="/business_insert",
			produces = "application/json; charset=utf-8")
	public String country_insert(
				@RequestParam(value="business_name_data") String business_name_data,
				@RequestParam(value="business_tel_data") String business_tel_data
			) {

		String result = pservice.business_insert(business_name_data, business_tel_data);
		System.out.println(result);
		return result;
		
	}
	
	//��ü��ȸ_���������ȸ
	@GetMapping(value="/in_out_record",
			produces = "application/json; charset=utf-8")
	public ArrayList<statementDTO> in_out_record(
			@RequestParam Map<String,Object> record_data,
			@RequestParam(value="record_arr") String[] record_arr
			) {
			
		ArrayList<statementDTO> result = pservice.in_out_record(record_data, record_arr);
		System.out.println(result);
		return result;
	}
	
	//��ü��ȸ_�����ȸ
	@GetMapping(value="/stock_record",
			produces = "application/json; charset=utf-8")
	public ArrayList<b_stockDTO> stock_record(
			@RequestParam Map<String,Object> record_data,
			@RequestParam(value="record_arr") String[] record_arr
			) {
			
		ArrayList<b_stockDTO> result = pservice.stock_record(record_data, record_arr);
		System.out.println(result);
		return result;
	}
	
	//��ü��ȸ_�����ȸexcel
		@SuppressWarnings("resource")
		@GetMapping(value="/excelDownXlsx",
				produces = "application/json; charset=utf-8")
		public void in_out_record_excel(	
				@RequestParam Map<String,Object> record_data,
				@RequestParam(value="record_arr") String[] record_arr,
				HttpServletResponse response) {
			
			
			
		
			XSSFWorkbook wb = null;
			Sheet sheet = null;
			Row row = null;
			Cell cell =null;
			wb = new XSSFWorkbook();
			sheet = wb.createSheet("statement");
			ArrayList<statementDTO> result = pservice.in_out_record(record_data, record_arr);
			System.out.println("����2");
			//List<statementDTO> result = pservice.in_out_record(record_data);
			//ArrayList<statementDTO> result = pservice.in_out_record(record_data, record_arr);
	
			
			
			System.out.println("aaaaaaaaaaaa");
			System.out.println(result);
			System.out.println("bbbbbbbbbbbb");
			
			//row(��)
			int cellCount=0;
			row = sheet.createRow(0);
			cell = row.createCell(cellCount++);
			cell.setCellValue("��������ڵ�");
			cell = row.createCell(cellCount++);
			cell.setCellValue("�з�");
			cell = row.createCell(cellCount++);
			cell.setCellValue("��¥");
			cell = row.createCell(cellCount++);
			cell.setCellValue("��ǰ��");
			cell = row.createCell(cellCount++);
			cell.setCellValue("��ǰ������");
			cell = row.createCell(cellCount++);
			cell.setCellValue("���޻��");
			cell = row.createCell(cellCount++);
			cell.setCellValue("�߷�");
			cell = row.createCell(cellCount++);
			cell.setCellValue("����");
			cell = row.createCell(cellCount++);
			cell.setCellValue("����ڸ�");
			cell = row.createCell(cellCount++);
			cell.setCellValue("�������ȭ��ȣ");
			
			for(int i=0; i<result.size(); i++) {
				row = sheet.createRow(i+1);
				cellCount = 0;
				cell = row.createCell(cellCount++);
				cell.setCellValue(result.get(i).getStatement_code());
				cell = row.createCell(cellCount++);
				cell.setCellValue(result.get(i).getClassification());
				cell = row.createCell(cellCount++);
				cell.setCellValue(result.get(i).getDate());
				cell = row.createCell(cellCount++);
				cell.setCellValue(result.get(i).getProduct_name());
				cell = row.createCell(cellCount++);
				cell.setCellValue(result.get(i).getProduct_country());
				cell = row.createCell(cellCount++);
				cell.setCellValue(result.get(i).getProduct_business());
				cell = row.createCell(cellCount++);
				cell.setCellValue(result.get(i).getQuantity());
				cell = row.createCell(cellCount++);
				cell.setCellValue(result.get(i).getProduct_price());
				cell = row.createCell(cellCount++);
				cell.setCellValue(result.get(i).getEmp_name());
				cell = row.createCell(cellCount++);
				cell.setCellValue(result.get(i).getEmp_tel());
			}
			
			System.out.println("hhhhhhhhhhhhhh");
			response.setContentType("ms-vnd/excel");
			System.out.println("sksksksksksksksk");
			response.setHeader("Content-Disposition", "attachment;filename=statement.xlsx");
			System.out.println("����");
			
			
				try {
					System.out.println("dddddddd");
					wb.write(response.getOutputStream());
					System.out.println("���Ͷ��");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
		
			
		}
	

}
