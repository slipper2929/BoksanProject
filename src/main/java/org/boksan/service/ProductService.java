package org.boksan.service;

import org.boksan.model.b_productDTO;
import org.boksan.model.b_product_group_addDTO;

public interface ProductService {
	
	public void ProductInsert(b_productDTO pdto);
	
	public void Product_group_addInsert(b_product_group_addDTO pgdto);
	
}
