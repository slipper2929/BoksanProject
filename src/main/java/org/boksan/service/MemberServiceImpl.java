package org.boksan.service;

import java.util.ArrayList;

import org.boksan.dao.MemberDao;
import org.boksan.model.b_deptDTO;
import org.boksan.model.b_empDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDao mdao;
	
	//회원가입
	public void MemberInsert(b_empDTO edto) {
		mdao.MemberInsert(edto);
		mdao.approveInsert(); //승인 여부 검사
	}
	
	//회원가입 부서 select
	public ArrayList<b_deptDTO> dept_select(){
		return mdao.dept_select();
	}
	
	//로그인
	public b_empDTO Login(b_empDTO edto) {
		return mdao.Login(edto);
	}
	
	//아이디 중복  체크
	
	
}
