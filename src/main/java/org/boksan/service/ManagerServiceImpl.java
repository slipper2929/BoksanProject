package org.boksan.service;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.dao.ManagerDao;
import org.boksan.model.Criteria;
import org.boksan.model.b_deptDTO;
import org.boksan.model.b_empDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService{
	@Autowired
	ManagerDao mgdao;
	
	//������ȸ
	public ArrayList<b_empDTO> emp_select(Criteria cri){
		return mgdao.emp_select(cri);
	}
	
	
	//����¡ ó���� ���� ��ü�Ǽ� �̵����
	public int getTotalCountEMP(Criteria cri) {
		return mgdao.getTotalCountEMP(cri);
	}
	//������ȸ ������ �μ� ������ư select box
	public ArrayList<b_deptDTO> dept_selectbox(){
		return mgdao.dept_selectbox();
	}
	//������ȸ �����Ϸ�
	//public b_empDTO emp_update(b_empDTO edto) {
	//	return mgdao.emp_update(edto);
	//}
}
