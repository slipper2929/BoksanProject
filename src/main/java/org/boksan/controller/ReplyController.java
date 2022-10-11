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
	
	//아이디 중복 확인
	public ResponseEntity<ArrayList<ReplyDTO>>  overlapId(@PathVariable("id")String id){
		//통신이 정상적이면(HttpStatus.OK), select된 결과(rservice.list(bno))를
		//reply.js에 ajax함수의 success에 보내라.
		return new ResponseEntity<>(rservice.overlapId(id),HttpStatus.OK);
	}
}
