package org.boksan.dao;

import org.boksan.model.b_empDTO;

public interface MemberDao {

	//ȸ������
	public void MemberInsert(b_empDTO edto);
	
	//ȸ�����ο���
	public void approveInsert();
	
	//�α���
	public b_empDTO Login(b_empDTO edto);
	
	//���̵� �ߺ� üũ
	
}
