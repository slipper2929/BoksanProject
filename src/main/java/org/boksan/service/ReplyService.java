package org.boksan.service;

import java.util.ArrayList;

import org.boksan.model.ReplyDTO;

public interface ReplyService {
	
	// ���̵� �ߺ� Ȯ��
	public ArrayList<ReplyDTO> overlapId(String id);
	
	
}
