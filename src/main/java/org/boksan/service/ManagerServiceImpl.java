package org.boksan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	public String emp_update(String[] emp_arr, String[] dept_arr) {
		
		for(int i= 0; i<emp_arr.length; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("emp_arr", emp_arr[i]);
			map.put("dept_arr", dept_arr[i]);
			mgdao.emp_update(map);
		}
		return "";
	}
	
	//��������
		public String emp_delete(String[] edto) {
			
			for(int i = 0; i<edto.length; i++) {
				
				String emp_code_choice = edto[i];
				
				mgdao.emp_delete(emp_code_choice);
			}
			System.out.println("����" + edto);
			
			return "";
		}
		
		//���Խ���
		public ArrayList<b_empDTO> emp_approve(Criteria cri){
			return mgdao.emp_approve(cri);
		}
		
		//���Խ��� �μ� selectbox
		public ArrayList<b_deptDTO> emp_apdept(Criteria cri){
			return mgdao.emp_apdept(cri);
		}
		
		//����¡ ó���� ���� ��ü�Ǽ� ���Խ���
		public int getTotalCountAP(Criteria cri) {
			return mgdao.getTotalCountAP(cri);
		}
		//���Կ�û
		public String manager_approve(String[] emp_val) {

			for(int i=0; i<emp_val.length; i++) {
		
				System.out.println("���� 1: " + emp_val[i]);
				mgdao.manager_approve(emp_val[i]);
				System.out.println("���� 2: " + emp_val[i]);
			}
			System.out.println("���� 3: " + emp_val);
			
			return "";
		}
		
}
