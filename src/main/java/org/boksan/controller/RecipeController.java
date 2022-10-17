package org.boksan.controller;

import org.boksan.model.Recipe_addDTO;
import org.boksan.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
