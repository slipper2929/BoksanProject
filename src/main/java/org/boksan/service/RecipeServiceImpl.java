package org.boksan.service;

import java.util.ArrayList;

import org.boksan.dao.RecipeDao;
import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.Product_selectDTO;
import org.boksan.model.RecipeDTO;
import org.boksan.model.Recipe_addDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	RecipeDao rdao;
	//레시피 상품분류 찾기
	public ArrayList<Product_groupDTO>recipe_add_select(){
		
		return rdao.recipe_add_select();
		
	}
	//레시피 상품분류에따른 상품이름
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
	
	//레시피수정post
	public void recipe_update_post(Recipe_addDTO rdto) {
		rdao.recipe_update_post(rdto);
		
		rdao.recipe_update_post_material_d(rdto);
		
		for(int i = 0; i < rdto.getProduct_code_list().size(); i++) {
			rdto.setProduct_code(rdto.getProduct_code_list().get(i).getProduct_code());
			rdto.setMaterial_num(rdto.getMaterial_num_list().get(i).getMaterial_num());
			
			rdao.recipe_update_post_material_i(rdto);
		}
		
	}
	
	//레시피 목록 조회
	public ArrayList<Recipe_addDTO> recipe_inquiry(Criteria cri){
		return rdao.recipe_inquiry(cri);
	}
	
	//레시피 삭제
	public void recipe_delete(String recipe_code) {
		
		rdao.recipe_delete(recipe_code);
		
	}
	
	//레시피 검색 목록 조회
	public ArrayList<Recipe_addDTO> recipe_inquiry_search(String search_text){
		return rdao.recipe_inquiry_search(search_text);
	}
	
	//페이징 처리를 위한 전체건수
	public int getTotalCount(Criteria cri) {
		
		return rdao.getTotalCount(cri);
		
	}
	
	//레시피 상세
	public ArrayList<Recipe_addDTO> recipe_detail(int rc) {
		
		return rdao.recipe_detail(rc);
		
	}
	
	//레시피수정
	public ArrayList<Recipe_addDTO> recipe_update_get(int product_code) {
		
		return rdao.recipe_update_get(product_code);
		
	}
}
