package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.Arrive_palletDTO;
import org.boksan.model.Arrive_totalDTO;
import org.boksan.model.Criteria;
import org.boksan.model.b_arriveDTO;
import org.boksan.model.b_houseDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.model.statementDTO;

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
	
	//�԰����� insert
	public void Arrive_list_insert(b_arriveDTO adto);
	
	//������� insert�� ���� product select
	public statementDTO statement_product_select(b_stockDTO sdto);
	
	//������� insert
	public void statement_arrive_insert(statementDTO stdto);
	
	//�԰�� â�� now_quantity+1
	public void house_quantity_plus_update(b_houseDTO hdto);
}
