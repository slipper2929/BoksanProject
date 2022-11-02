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
	
	//직원조회
	public ArrayList<b_empDTO> emp_select(Criteria cri){
		return mgdao.emp_select(cri);
	}
	
	
	//페이징 처리를 위한 전체건수 이동목록
	public int getTotalCountEMP(Criteria cri) {
		return mgdao.getTotalCountEMP(cri);
	}
	//직원조회 페이지 부서 수정버튼 select box
	public ArrayList<b_deptDTO> dept_selectbox(){
		return mgdao.dept_selectbox();
	}
	//직원조회 수정완료
	public String emp_update(String[] emp_arr, String[] dept_arr) {
		
		for(int i= 0; i<emp_arr.length; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("emp_arr", emp_arr[i]);
			map.put("dept_arr", dept_arr[i]);
			mgdao.emp_update(map);
		}
		return "";
	}
}
