package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.Criteria;
import org.boksan.model.b_deptDTO;
import org.boksan.model.b_empDTO;

public interface ManagerDao {
	//������ȸ
	public ArrayList<b_empDTO> emp_select(Criteria cri);
	//����¡ ó���� ���� ��ü�Ǽ� ������ȸ
	public int getTotalCountEMP(Criteria cri);
	//������ȸ ������ �μ� ������ư select box
	public ArrayList<b_deptDTO> dept_selectbox();
}
