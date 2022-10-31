package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.Arrive_palletDTO;
import org.boksan.model.Arrive_totalDTO;
import org.boksan.model.Criteria;
import org.boksan.model.b_arriveDTO;
import org.boksan.model.b_stockDTO;

public interface ArriveDao {

	//�԰�����
	public ArrayList<b_arriveDTO> arrive_list_select(Criteria cri);
	
	//�԰��⸮��Ʈ_�ķ�Ʈ��ȣ ��������
	public ArrayList<Arrive_palletDTO> arrive_list_select_pallet();
	
	//����¡ ó���� ���� ��ü�Ǽ�
	public int getTotalCount(Criteria cri);
	
	//��ǰ�� �� �����
	public ArrayList<Arrive_totalDTO> arrive_total_list();
	
	//�԰�����_���� insert
	public void Arrive_insert(b_stockDTO sdto);
	
	//�԰�����_���� �� delete
	public void Arrive_delete(int arrive_code);
}
