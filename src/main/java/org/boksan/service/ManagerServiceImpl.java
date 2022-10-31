package org.boksan.service;

import java.util.ArrayList;

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
}
