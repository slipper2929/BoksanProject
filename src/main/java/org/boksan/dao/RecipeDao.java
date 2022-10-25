package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.Product_selectDTO;
import org.boksan.model.RecipeDTO;
import org.boksan.model.Recipe_addDTO;

public interface RecipeDao {
	//레시피 상품분류 찾기
	public ArrayList<Product_groupDTO>recipe_add_select();
	//레시피 상품분류에 따른 상품이름 찾기
	public ArrayList<Product_selectDTO>recipe_add_pselect(String data);
	
	//레시피추가
	public void recipe_add_insert(Recipe_addDTO rdto);
	
	//레시피추가_재료목록(맵핑테이블)
	public void recipe_add_insert_material(Recipe_addDTO rdto);
	
	//레시피수정post
	public void recipe_update_post(Recipe_addDTO rdto);
	
	//레시피수정post_재료목록_삭제
	public void recipe_update_post_material_d(Recipe_addDTO rdto);
	
	//레시피수정post_재료목록_삽입
	public void recipe_update_post_material_i(Recipe_addDTO rdto);
	
	//레시피 목록
	public ArrayList<Recipe_addDTO> recipe_inquiry(Criteria cri);
	
	//레시피 삭제
	public void recipe_delete(String recipe_code);
	
	//레시피 검색목록 조회
	public ArrayList<Recipe_addDTO> recipe_inquiry_search(String search_text);
	
	//페이징 처리를 위한 전체건수
	public int getTotalCount(Criteria cri);
	
	//레시피 상세
	public ArrayList<Recipe_addDTO> recipe_detail(int rc);
	
	//레시피 수정
	public ArrayList<Recipe_addDTO> recipe_update_get(int product_code);
}
