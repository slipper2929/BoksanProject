package org.boksan.dao;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.b_releaseDTO;
import org.boksan.model.materiaDTO;

public interface ReleaseDao {

	//총중량 select
	public int gross_weight_select(Map<String, Object> objdata);
	
	//출고요청 레시피기준 조회(release.js)
	public ArrayList<materiaDTO> release_recipe_select(Map<String, Object> objdata);
	
	//출고요청 insert
	public void release_insert(b_releaseDTO rdto);
	
	//출고요청처리현황 select
	public ArrayList<b_releaseDTO> release_state_inquiry_select(Criteria cri);
	
	//페이징 처리를 위한 전체건수
	public int getTotalCount(Criteria cri);
}
