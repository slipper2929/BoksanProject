package org.boksan.service;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.b_deptDTO;
import org.boksan.model.b_empDTO;

public interface ManagerService {
	
	//직원조회
	public ArrayList<b_empDTO> emp_select(Criteria cri);
	//페이징 처리를 위한 전체건수 직원조회
	public int getTotalCountEMP(Criteria cri);
	//직원조회 페이지 부서 수정버튼 select box
	public ArrayList<b_deptDTO> dept_selectbox();
	//직원조회 수정완료
	public String emp_update(String[] emp_arr, String[] dept_arr);
}
