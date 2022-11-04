package org.boksan.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.b_deptDTO;
import org.boksan.model.b_empDTO;
import org.boksan.model.b_houseDTO;
import org.boksan.model.house_functionDTO;

public interface ManagerDao {
	//������ȸ
	public ArrayList<b_empDTO> emp_select(Criteria cri);
	//����¡ ó���� ���� ��ü�Ǽ� ������ȸ
	public int getTotalCountEMP(Criteria cri);
	//������ȸ ������ �μ� ������ư select box
	public ArrayList<b_deptDTO> dept_selectbox();
	//������ȸ �����Ϸ�
	public void emp_update(Map<String,Object> map);
	//��������
	public void emp_delete(String edto);
	//���Խ���
	public ArrayList<b_empDTO> emp_approve(Criteria cri);
	//���Խ��� �μ� selectbox
	public ArrayList<b_deptDTO> emp_apdept(Criteria cri);
	//����¡ ó���� ���� ��ü�Ǽ� ���Խ���
	public int getTotalCountAP(Criteria cri);
	//���Կ�û
	public void manager_approve(String emp_val);
	//���԰���
	public void manager_dept_code(Map<String, Object> map);
	//�μ����
	public void dept_group_add(b_deptDTO ddto);
	//â����ȭ��
	public ArrayList<house_functionDTO> manager_house();
	//â����
	public void manager_house_add(b_houseDTO hdto);
}
