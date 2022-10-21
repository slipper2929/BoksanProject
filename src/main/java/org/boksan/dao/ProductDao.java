package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_productDTO;


public interface ProductDao {
	
	public ArrayList<Product_groupDTO> product_group_select();
	
	public void ProductInsert(b_productDTO pdto);
	
	public void Product_group_addInsert(Product_groupDTO pgdto);
	
	public String price_select(String data);
}
