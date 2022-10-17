package org.boksan.service;

import java.util.ArrayList;
import java.util.List;

import org.boksan.dao.RecipeDao;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.Product_selectDTO;
import org.boksan.model.Recipe_addDTO;
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
	
	//레시피추가
	public void recipe_add_insert(Recipe_addDTO rdto) {
		
		rdao.recipe_add_insert(rdto);
		
		for(int i = 0; i < rdto.getProduct_code_list().size(); i++) {
			rdto.setProduct_code(rdto.getProduct_code_list().get(i).getProduct_code());
			rdto.setMaterial_num(rdto.getMaterial_num_list().get(i).getMaterial_num());
			
			rdao.recipe_add_insert_material(rdto);
		}
		
		
		System.out.println("첫번째목록 상품코드 : "+rdto.getProduct_code_list().get(0).getProduct_code());
		System.out.println("첫번째목록 상품중량 : "+rdto.getMaterial_num_list().get(0).getMaterial_num());
		System.out.println("두번째목록 상품코드 : "+rdto.getProduct_code_list().get(1).getProduct_code());
		System.out.println("두번째목록 상품중량 : "+rdto.getProduct_code_list().get(1).getMaterial_num());
		
		
	}
}
