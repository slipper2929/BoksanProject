package org.boksan.controller;

import org.boksan.model.Product_groupDTO;
import org.boksan.model.b_productDTO;
import org.boksan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	//상품등록 버튼
	@RequestMapping(value="/product", method = RequestMethod.POST)
	public String PostProduct(b_productDTO pdto) {
		pservice.ProductInsert(pdto);
		return "product";
	}
	//상품분류추가 버튼
	@RequestMapping(value="/group_add", method = RequestMethod.POST)
	public String Post_group_add(Product_groupDTO pgdto) {
		pservice.Product_group_addInsert(pgdto);
		return "group_add";
	}
}
