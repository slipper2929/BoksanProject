package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.b_deptDTO;
import org.boksan.model.b_empDTO;

public interface MemberDao {

	//ȸ������
	public void MemberInsert(b_empDTO edto);
	
	//ȸ������ �μ� select
	public ArrayList<b_deptDTO> dept_select();
	//ȸ�����ο���
	public void approveInsert();
	
	//�α���
	public b_empDTO Login(b_empDTO edto);
	
	//���̵� �ߺ� üũ
	
}
