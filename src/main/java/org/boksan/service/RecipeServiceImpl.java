package org.boksan.service;

import java.util.ArrayList;

import org.boksan.dao.RecipeDao;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.Product_selectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	RecipeDao rdao;
	
	public ArrayList<Product_groupDTO>recipe_add_select(){
		
		return rdao.recipe_add_select();
		
	}
	
	public ArrayList<Product_selectDTO>recipe_add_pselect(String data){
		
		return rdao.recipe_add_pselect(data);
		
	}
}
