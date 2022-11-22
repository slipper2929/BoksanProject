package org.boksan.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.boksan.model.Criteria;
import org.boksan.model.b_empDTO;
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
	public ArrayList<b_release_listDTO> release_order_list(Criteria cri);
	
	//����¡ ó���� ���� ��ü�Ǽ�(������ø��)
	public int getTotalCount_order(Criteria cri);
	
	//��� update
	public void release_stock_update(HttpSession session, b_release_listDTO rldto);
	//recipe select
	public ArrayList<String> recipe_select();
	
	//����û ȸ�������� ��ȸ
	public b_empDTO emp_select(String userId);
	
	//�������ȭ�鿡�� �����ϱ� ���â ��ǰ�� ��� select
	public String release_order(int data);
	
	//�������ȭ�鿡�� �����ϱ� ���â ��ǰ�� ����� ���Ű� select
	public String release_order_price_select(int data);
	
	//�������ȭ�鿡�� �����ϱ� ���â ��ǰ�� ��� �����ϱ� insert
	public void release_pay_order(HttpSession session, int order_num_count, int product_code);
	
	//����û�� �����ȸ
	public String[] release_stock_check(String[] pc_arr, String [] rn_arr);
}
