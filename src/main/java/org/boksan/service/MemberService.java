package org.boksan.service;

import java.util.ArrayList;

import org.boksan.model.b_deptDTO;
import org.boksan.model.b_empDTO;

public interface MemberService {
	
		//ȸ������
		public void MemberInsert(b_empDTO edto);
		
		//ȸ������ �μ� select
		public ArrayList<b_deptDTO> dept_select();
		
		//�α���
		public b_empDTO Login(b_empDTO edto);
		
		
		
}
