package org.boksan.service;


import java.util.ArrayList;
import java.util.Map;

import org.boksan.dao.StockDao;
import org.boksan.model.Criteria;
import org.boksan.model.b_houseDTO;
import org.boksan.model.b_movement_orderDTO;
import org.boksan.model.b_stockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockDao sdao;
	
	//�����ȸ
	public ArrayList<b_stockDTO> stock(Criteria cri){
		return sdao.stock(cri);
	}
	//��ǰ�����
	public ArrayList<b_stockDTO> stockAll(){
		return sdao.stockAll();
	}
	public int getTotalCountS(Criteria cri) {
		return sdao.getTotalCountS(cri);
	}
	//�ķ�Ʈ �߰�
	public void PalletInsert(b_stockDTO sdto) {
		
		for(int i = 0; i < sdto.getPallet_count(); i++) {
			sdao.PalletInsert(sdto);	
		}
		
	}
	
	//�� �ķ�Ʈ ��ȸ
	public ArrayList<b_stockDTO> DeletePalletSelect(String data){
		System.out.println("���񽺴�" + data);
		return sdao.DeletePalletSelect(data);
		
	}
	
	//�ķ�Ʈ ����
	public void pallet_delete(b_stockDTO sdto) {
		
		for(int i = 0; i < sdto.getPallet_num_list().size(); i++) {
			sdto.setPallet_num(sdto.getPallet_num_list().get(i).getPallet_num());
			sdao.pallet_delete(sdto);
		}
		
	}
	
	//�̵����� ����Ʈ
	public ArrayList<b_stockDTO> moveList(Criteria cri){
		return sdao.moveList(cri);
	}
	
	//�̵����� -> �̵���� insert
	public void move_change(Map<String, Object> map) {
		sdao.move_change(map);
	}
	//����¡ ó���� ���� ��ü�Ǽ� �̵�����
	public int getTotalCountMo(Criteria cri) {
		return sdao.getTotalCountMo(cri);
	}
	//����¡ ó���� ���� ��ü�Ǽ� �̵����
	public int getTotalCountMol(Criteria cri) {
		return sdao.getTotalCountMol(cri);
	}
	//�̵���� ����Ʈ
	public ArrayList<b_stockDTO> move_list(Criteria cri){
		return sdao.move_list(cri);
	}
	//�̵���� �̵����ּ�
	public ArrayList<String> movement(Criteria cri){
		return sdao.movement(cri);
	}
	
	//�̵���� �ּ� Ȯ�ι�ư
	public void move_compare(b_stockDTO sdto) {
		sdao.move_compare(sdto);
		String num = sdto.getHouse_code();
		String move = sdto.getMovement_address();
		System.out.println(num);
		System.out.println(move);
		System.out.println(sdto.getPallet_num());
		sdao.move_quantity_plus(move);
		sdao.move_quantity_minus(num);
		
	}
	 //�̵���� Ȯ�ι�ư ������ �̵���� ����Ʈ���� ����
	public void move_delete(b_movement_orderDTO modto) {
		sdao.move_delete(modto);
	}
	//�̵���� �ּ� �������� Ȯ��
	public String changeHouse(String data){
		return sdao.changeHouse(data);
	}
	
	//�����̼Ǻ� ��ġ��ȸ
	public ArrayList<b_stockDTO> location_select(Criteria cri){
		return sdao.location_select(cri);
	}
			
	//����¡ ó���� ���� ��ü�Ǽ� �����̼Ǻ�
	public int getTotalCountLI(Criteria cri) {
		return sdao.getTotalCountLI(cri);
	}
	
	
}
