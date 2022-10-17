package org.boksan.controller;

import org.boksan.model.Recipe_addDTO;
import org.boksan.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecipeController {
	
	@Autowired
	RecipeService rservice;
	
	//레시피추가 
	@RequestMapping(value = "/recipe_add", method = RequestMethod.POST)
	public String recipe_add_insert(Recipe_addDTO rdto) {
		System.out.println("가나다라");
		System.out.println(rdto);
		System.out.println("레시피코드 : " + rdto.getRecipe_code());
		//System.out.println("상품코드 : " + rdto.getProduct_code());
		//System.out.println("상품중량 : " + rdto.getMaterial_num());
		rservice.recipe_add_insert(rdto);
		
		return "recipe_add";
	}
	
	//레시피삭제
	@RequestMapping(value = "/recipe_delete", method = RequestMethod.POST)
	public String recipe_delete(@RequestParam("recipe_code") String recipe_code) {
		
		rservice.recipe_delete(recipe_code);
		System.out.println("들고온 레시피코드"+recipe_code);
		
		return "redirect:recipe_inquiry";
	}
	
	//레시피 검색창 검색
	@RequestMapping(value = "/recipe_inquiry", method = RequestMethod.POST)
	public String recipe_search(@RequestParam("search_text") String search_text, Model model) {
		
		System.out.println(search_text);
		model.addAttribute("rlist", rservice.recipe_inquiry_search(search_text));
	
		return "recipe_inquiry";
	}
}
