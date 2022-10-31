package org.boksan.dao;


import java.util.ArrayList;
import java.util.Map;

import org.boksan.model.Criteria;
import org.boksan.model.b_houseDTO;
import org.boksan.model.b_stockDTO;

public interface StockDao {
	
	//�ķ�Ʈ �߰�
	public void PalletInsert(b_stockDTO sdto);
	//������ �ķ�Ʈ ã��
	public ArrayList<b_stockDTO> DeletePalletSelect(String data);
	//�ķ�Ʈ ����
	public void pallet_delete(b_stockDTO sdto);
	//�̵����� ����Ʈ
	public ArrayList<b_stockDTO> moveList(Criteria cri);
	
	
	
	//�̵����� -> �̵���� insert
	public void move_change(Map<String, Object> map);
	
	//����¡ ó���� ���� ��ü�Ǽ� �̵�����
	public int getTotalCountMo(Criteria cri);
	//����¡ ó���� ���� ��ü�Ǽ� �̵����
	public int getTotalCountMol(Criteria cri);
	
	//�̵���� ����Ʈ
	public ArrayList<b_stockDTO> move_list(Criteria cri);
	//�̵���� �̵����ּ�
	public ArrayList<String> movement(Criteria cri);
	//�̵���� �ּ� Ȯ�ι�ư
	public void move_compare(b_stockDTO sdto);
	//�̵���� Ȯ�ι�ư ������ �̵���� ����Ʈ���� ����
	public void move_delete(b_stockDTO sdto);
	//�̵���� �ּ� �������� Ȯ��
	public String changeHouse(String data);
	//�����̼Ǻ� ��ġ��ȸ
	public ArrayList<b_stockDTO> location_select(Criteria cri);		
	//����¡ ó���� ���� ��ü�Ǽ� �����̼Ǻ�
	public int getTotalCountLI(Criteria cri);
	
}
