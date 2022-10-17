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
	
	//�������߰� 
	@RequestMapping(value = "/recipe_add", method = RequestMethod.POST)
	public String recipe_add_insert(Recipe_addDTO rdto) {
		System.out.println("�����ٶ�");
		System.out.println(rdto);
		System.out.println("�������ڵ� : " + rdto.getRecipe_code());
		//System.out.println("��ǰ�ڵ� : " + rdto.getProduct_code());
		//System.out.println("��ǰ�߷� : " + rdto.getMaterial_num());
		rservice.recipe_add_insert(rdto);
		
		return "recipe_add";
	}
}
