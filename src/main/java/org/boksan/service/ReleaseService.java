package org.boksan.service;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.materiaDTO;

public interface ReleaseService {
	
	//����û �����Ǳ��� ��ȸ(release.js)
	public ArrayList<materiaDTO> release_recipe_select(Map<String, Object> objdata);
	
}
