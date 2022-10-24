package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.b_deptDTO;
import org.boksan.model.b_empDTO;

public interface MemberDao {

	//회원가입
	public void MemberInsert(b_empDTO edto);
	
	//회원가입 부서 select
	public ArrayList<b_deptDTO> dept_select();
	//회원승인여부
	public void approveInsert();
	
	//로그인
	public b_empDTO Login(b_empDTO edto);
	
	//아이디 중복 체크
	
}
