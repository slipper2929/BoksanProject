package org.boksan.dao;

import org.boksan.model.b_productDTO;
import org.boksan.model.b_product_group_addDTO;

public interface ProductDao {
	
	public void ProductInsert(b_productDTO pdto);
	
	public void Product_group_addInsert(b_product_group_addDTO pgdto);
}
