package org.boksan.service;

import org.boksan.dao.MemberDao;
import org.boksan.model.b_empDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDao mdao;
	
	//ȸ������
	public void MemberInsert(b_empDTO edto) {
		mdao.MemberInsert(edto);
		mdao.approveInsert(); //���� ���� �˻�
	}
	
	//�α���
	public b_empDTO Login(b_empDTO edto) {
		return mdao.Login(edto);
	}
	
	//���̵� �ߺ�  üũ
	
	
}
