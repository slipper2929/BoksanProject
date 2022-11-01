package org.boksan.service;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.materiaDTO;

public interface ReleaseService {
	
	//출고요청 레시피기준 조회(release.js)
	public ArrayList<materiaDTO> release_recipe_select(Map<String, Object> objdata);
	
}
