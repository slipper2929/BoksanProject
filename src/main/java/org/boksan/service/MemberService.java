package org.boksan.service;

import java.util.ArrayList;

import org.boksan.model.b_deptDTO;
import org.boksan.model.b_empDTO;

public interface MemberService {
	
		//회원가입
		public void MemberInsert(b_empDTO edto);
		
		//회원가입 부서 select
		public ArrayList<b_deptDTO> dept_select();
		
		//로그인
		public b_empDTO Login(b_empDTO edto);
		
		
		
}
