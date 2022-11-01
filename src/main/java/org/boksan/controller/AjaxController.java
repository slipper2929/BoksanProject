package org.boksan.controller;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Product_selectDTO;
import org.boksan.model.b_productDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.model.materiaDTO;
import org.boksan.service.ArriveService;
import org.boksan.service.ProductService;
import org.boksan.service.RecipeService;
import org.boksan.service.ReleaseService;
import org.boksan.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
		//System.out.println("전 : " + pdto);
		pservice.update_product(pdto);
		//System.out.println("후 : " + pdto);
		
		return pdto;
	}

	
	//출고요청 레시피기준 조회(release.js)materiaDTO
	@GetMapping(value="/release_recipe_select",
			produces = "application/json; charset=utf-8")
	public ArrayList<materiaDTO> release_recipe_select(@RequestParam Map<String, Object> objdata) {
		
		System.out.println(objdata);
		return relservice.release_recipe_select(objdata);
	}

}
