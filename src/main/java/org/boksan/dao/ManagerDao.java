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
	//직원조회
	public ArrayList<b_empDTO> emp_select(Criteria cri);
	//페이징 처리를 위한 전체건수 직원조회
	public int getTotalCountEMP(Criteria cri);
	//직원조회 페이지 부서 수정버튼 select box
	public ArrayList<b_deptDTO> dept_selectbox();
	//직원조회 수정완료
	public void emp_update(Map<String,Object> map);
	//직원삭제
	public void emp_delete(String edto);
	//가입승인
	public ArrayList<b_empDTO> emp_approve(Criteria cri);
	//가입승인 부서 selectbox
	public ArrayList<b_deptDTO> emp_apdept(Criteria cri);
	//페이징 처리를 위한 전체건수 가입승인
	public int getTotalCountAP(Criteria cri);
	//가입요청
	public void manager_approve(String emp_val);
	//가입거절
	public void manager_dept_code(Map<String, Object> map);
	//부서등록
	public void dept_group_add(b_deptDTO ddto);
	//창고등록화면
	public ArrayList<house_functionDTO> manager_house();
	//창고등록
	public void manager_house_add(b_houseDTO hdto);
}
