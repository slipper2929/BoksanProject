package org.boksan.dao;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.materiaDTO;

public interface ReleaseDao {

	//총중량 select
	public int gross_weight_select(Map<String, Object> objdata);
	
	//출고요청 레시피기준 조회(release.js)
	public ArrayList<materiaDTO> release_recipe_select(Map<String, Object> objdata);
}
