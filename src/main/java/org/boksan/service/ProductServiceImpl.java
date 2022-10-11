package org.boksan.service;

import org.boksan.dao.ProductDao;
import org.boksan.model.b_productDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao pdao;
	
	public void ProductInsert(b_productDTO pdto) {
		pdao.ProductInsert(pdto);
	}
}
