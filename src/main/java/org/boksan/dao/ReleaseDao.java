package org.boksan.dao;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.materiaDTO;

public interface ReleaseDao {

	//���߷� select
	public int gross_weight_select(Map<String, Object> objdata);
	
	//����û �����Ǳ��� ��ȸ(release.js)
	public ArrayList<materiaDTO> release_recipe_select(Map<String, Object> objdata);
}
