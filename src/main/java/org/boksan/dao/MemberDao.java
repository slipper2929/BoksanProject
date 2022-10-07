package org.boksan.dao;

import org.boksan.model.b_empDTO;

public interface MemberDao {

	public void MemberInsert(b_empDTO edto);
	
	public void approveInsert();
	
}
