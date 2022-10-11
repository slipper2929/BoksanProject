package org.boksan.controller;

import java.util.ArrayList;

import org.boksan.model.ReplyDTO;
import org.boksan.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {
	@Autowired
	ReplyService rservice;
	
	@RequestMapping(value="replies/overlapId/{id}",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,
																						MediaType.APPLICATION_XML_VALUE})
	
	//���̵� �ߺ� Ȯ��
	public ResponseEntity<ArrayList<ReplyDTO>>  overlapId(@PathVariable("id")String id){
		//����� �������̸�(HttpStatus.OK), select�� ���(rservice.list(bno))��
		//reply.js�� ajax�Լ��� success�� ������.
		return new ResponseEntity<>(rservice.overlapId(id),HttpStatus.OK);
	}
}
