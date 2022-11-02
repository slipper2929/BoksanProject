package org.boksan.dao;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.b_releaseDTO;
import org.boksan.model.materiaDTO;

public interface ReleaseDao {

	//���߷� select
	public int gross_weight_select(Map<String, Object> objdata);
	
	//����û �����Ǳ��� ��ȸ(release.js)
	public ArrayList<materiaDTO> release_recipe_select(Map<String, Object> objdata);
	
	//����û insert
	public void release_insert(b_releaseDTO rdto);
	
	//����ûó����Ȳ select
	public ArrayList<b_releaseDTO> release_state_inquiry_select(Criteria cri);
	
	//����¡ ó���� ���� ��ü�Ǽ�
	public int getTotalCount(Criteria cri);
}
