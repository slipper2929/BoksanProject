package org.boksan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.boksan.model.Arrive_palletDTO;
import org.boksan.model.Arrive_totalDTO;
import org.boksan.model.Criteria;
import org.boksan.model.b_arriveDTO;
import org.boksan.model.b_stockDTO;

public interface ArriveService {
	
	//�԰��⸮��Ʈ
	public ArrayList<b_arriveDTO> arrive_list_select(Criteria cri);
	
	//�԰��⸮��Ʈ_�ķ�Ʈ��ȣ ��������
	public ArrayList<Arrive_palletDTO> arrive_list_select_pallet();
	
	//����¡ ó���� ���� ��ü�Ǽ�
	public int getTotalCount(Criteria cri);
	
	//��ǰ�� �� �����
	public ArrayList<Arrive_totalDTO> arrive_total_list();
	
	//�԰�����_���� insert
	public void Arrive_insert(HttpSession session, b_stockDTO sdto, int arrive_code);
	
	//�԰����� insert
	public void Arrive_list_insert(b_arriveDTO adto);
}
