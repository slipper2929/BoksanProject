package org.boksan.controller;




import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

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
	
	
	
	//이중 select box  (product_select.js)
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
	
	
	//빈 파레트 조회 (pallet.js)
	@GetMapping(value = "/delete_pallet_select",
			produces = "application/json; charset=utf-8")
	
	public ArrayList<b_stockDTO> delete_pallet_select(String data){
		System.out.println(data);
		
		ArrayList<b_stockDTO> dps = sservice.DeletePalletSelect(data);
		System.out.println(dps);
		return dps;
	}
	
	
	//이동지시완료 (move_order.js)
	@PostMapping(value="/changeHouse",
			produces = "application/json; charset=utf-8")
	public String changeHouse(String data){
		System.out.println(data);
		String change = sservice.changeHouse(data);
		System.out.println(change);
		return change;
	}
	
	
	//발주 예상구매액 (order.js)
	@GetMapping(value="/price_select",
			produces = "application/json; charset=utf-8")
	public String price_select(String data) {
		
		String res = pservice.price_select(data);
		
		return res;
		
	}	
	
	//상품조회 리스트 수정
	@PostMapping(value = "/product_Iupdate",
			produces = "application/json; charset=utf-8")
	public b_productDTO product_Iupdate_ajax(b_productDTO pdto) {
		System.out.println("전 : " + pdto);
		pservice.update_product(pdto);
		System.out.println("후 : " + pdto);
		
		return pdto;
	}

	
	//출고요청 레시피기준 조회(release.js)materiaDTO
	@GetMapping(value="/release_recipe_select",
			produces = "application/json; charset=utf-8")
	public ArrayList<materiaDTO> release_recipe_select(@RequestParam Map<String, Object> objdata) {
		
		System.out.println(objdata);
		return relservice.release_recipe_select(objdata);
	}
	

	//직원조회 수정완료
	@PostMapping(value="/emp_update",
			produces = "application/json; charset=utf-8")
	public String emp_update(@RequestParam(value="emp_arr") String[] emp_arr, @RequestParam(value="dept_arr") String[] dept_arr) {
		mgservice.emp_update(emp_arr,dept_arr);
		
		return "부서가 변경되었습니다.";
	}
	

	//출고요청결제 취소
	@PostMapping(value = "/release_cancel",
			produces = "application/json; charset=utf-8")
	public String release_cancel(int data) {
		
		relservice.release_cancel(data);
		
		return "취소가 되었습니다.";
	}
	
	//출고지시화면에서 발주하기 모달창 상품의 재고 select
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
	


	//승인요청
	@PostMapping(value="/approve_success",
			produces = "application/json; charset=utf-8")
	public String manager_approve(@RequestParam(value="emp_val") String[] emp_val,@RequestParam(value="dept_val") String[] dept_val) {

		mgservice.manager_approve(emp_val, dept_val);
		return "가입이 승인되었습니다.";
	}
	//가입거절
	@PostMapping(value="/approve_sorry",
			produces = "application/json; charset=utf-8")
	public String manager_approve(@RequestParam(value="emp_val") String[] emp_val) {
		System.out.println("개수 : " + emp_val.length);
		mgservice.emp_delete(emp_val);
		return "삭제되었습니다.";
	}
	
	//출고요청시 재고조회
	@GetMapping(value="/release_stock_check",
			produces = "application/json; charset=utf-8")
	public String[] release_stock_check(@RequestParam(value="pc_arr") String[] pc_arr,@RequestParam(value="rn_arr") String[] rn_arr) {
		
		String[] res = relservice.release_stock_check(pc_arr, rn_arr);
		
		return res;
		
	}
	
	//원산지 등록 
	@PostMapping(value="/country_insert",
			produces = "application/json; charset=utf-8")
	public String country_insert(String data) {

		String result = pservice.country_insert(data);
		
		return result;
		
	}
	
	//업체 등록 
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
	
	//전체조회_입출고내역조회
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
	
	//전체조회_재고조회
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

}
