package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.ReplyDTO;

public interface ReplyDao {
	
	//���̵� �ߺ� Ȯ��
	public ArrayList<ReplyDTO> overlapId(String id);
}
