package org.boksan.service;

import java.util.ArrayList;

import org.boksan.dao.ArriveDao;
import org.boksan.dao.OrderDao;
import org.boksan.model.Arrive_palletDTO;
import org.boksan.model.Arrive_totalDTO;
import org.boksan.model.Criteria;
import org.boksan.model.b_arriveDTO;
import org.boksan.model.b_stockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArriveServiceImpl implements ArriveService{

	@Autowired
	ArriveDao adao;
	
	@Autowired
	OrderDao odao;
	
	//�԰�����
	public ArrayList<b_arriveDTO> arrive_list_select(Criteria cri){
		
		return adao.arrive_list_select(cri);
		
	}
	
	//�԰�����_�ķ�Ʈ_select
	public ArrayList<Arrive_palletDTO> arrive_list_select_pallet(){
		
		return adao.arrive_list_select_pallet();
		
	}
	
	//����¡ ó���� ���� ��ü�Ǽ�
	public int getTotalCount(Criteria cri) {
		
		return adao.getTotalCount(cri);
		
	}
	
	//��ǰ�� �� �����
	public ArrayList<Arrive_totalDTO> arrive_total_list(){
		
		return adao.arrive_total_list();
		
	}
	
	//�԰�����_���� insert
	public void Arrive_insert(b_stockDTO sdto, int arrive_code) {
		
		adao.Arrive_insert(sdto);
		
		adao.Arrive_delete(arrive_code);

		
	}
	
	//�԰����� insert
	public void Arrive_list_insert(b_arriveDTO adto) {
		int select_num = odao.pallet_in_ratio_select(adto);
		System.out.println("��ǰ����߷� : ");
		System.out.println(select_num);
		
		if(adto.getArrive_num() > select_num) {
			
			int minus_num;
			
			while(true) {
				
				if(select_num >= adto.getArrive_num()) {
					adao.Arrive_list_insert(adto);
					break;
				}
				
				minus_num = adto.getArrive_num() - select_num;
				adto.setArrive_num(select_num);
				adao.Arrive_list_insert(adto);
				adto.setArrive_num(minus_num);
				
			}
			 
		} else {
			adao.Arrive_list_insert(adto);
		}
	}
}
