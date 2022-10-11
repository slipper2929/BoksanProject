package org.boksan.service;

import org.boksan.model.b_empDTO;

public interface MemberService {
	
		//회원가입
		public void MemberInsert(b_empDTO edto);
		
		//로그인
		public b_empDTO Login(b_empDTO edto);
}
