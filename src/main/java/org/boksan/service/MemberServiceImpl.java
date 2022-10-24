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
	
	//ȸ������
	public void MemberInsert(b_empDTO edto) {
		mdao.MemberInsert(edto);
		mdao.approveInsert(); //���� ���� �˻�
	}
	
	//ȸ������ �μ� select
	public ArrayList<b_deptDTO> dept_select(){
		return mdao.dept_select();
	}
	
	//�α���
	public b_empDTO Login(b_empDTO edto) {
		return mdao.Login(edto);
	}
	
	//���̵� �ߺ�  üũ
	
	
}
