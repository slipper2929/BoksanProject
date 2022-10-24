package org.boksan.service;

import java.util.ArrayList;

import org.boksan.dao.ProductDao;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_productDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao pdao;
	
	public ArrayList<Product_groupDTO> product_group_select(){
		return pdao.product_group_select();
	}
	
	public void ProductInsert(b_productDTO pdto) {
		pdao.ProductInsert(pdto);
	}
	
	public void Product_group_addInsert(Product_groupDTO pgdto) {
		pdao.Product_group_addInsert(pgdto);
	}
	
	public String price_select(String data) {
		
		return pdao.price_select(data);
		
	}
	
	public ArrayList<b_productDTO> piproduct_select(){
		return pdao.piproduct_select();
	}
	
}
