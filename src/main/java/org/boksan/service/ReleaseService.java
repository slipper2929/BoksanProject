package org.boksan.service;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.b_releaseDTO;
import org.boksan.model.b_release_listDTO;
import org.boksan.model.materiaDTO;

public interface ReleaseService {
	
	//����û �����Ǳ��� ��ȸ(release.js)
	public ArrayList<materiaDTO> release_recipe_select(Map<String, Object> objdata);
	
	//����û insert
	public void release_insert(b_releaseDTO rdto);
	
	//����ûó����Ȳ select
	public ArrayList<b_releaseDTO> release_state_inquiry_select(Criteria cri);
	
	//����¡ ó���� ���� ��ü�Ǽ�
	public int getTotalCount(Criteria cri);
	
	//����û���� select
	public ArrayList<b_releaseDTO> release_pay_select(Criteria cri);
	
	//����¡ ó���� ���� ��ü�Ǽ�(����ȭ��)
	public int getTotalCount_pay(Criteria cri);
	
	//����û��� insert
	public void release_order_list_insert(b_release_listDTO rldto);
	
	//����û���� ���
	public void release_cancel(int data);
	
	//������ø��
	public ArrayList<b_release_listDTO> release_order_list();
}
