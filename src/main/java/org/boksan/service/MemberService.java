package org.boksan.service;

import org.boksan.model.b_empDTO;

public interface MemberService {
	
		//ȸ������
		public void MemberInsert(b_empDTO edto);
		
		//�α���
		public b_empDTO Login(b_empDTO edto);
}
