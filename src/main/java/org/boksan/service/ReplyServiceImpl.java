package org.boksan.service;

import java.util.ArrayList;

import org.boksan.dao.ReplyDao;
import org.boksan.model.ReplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl  implements ReplyService {
	@Autowired
	ReplyDao rdao;
	
	// 아이디 중복 확인
	public ArrayList<ReplyDTO> overlapId(String id){
		return rdao.overlapId(id);
	}
}

