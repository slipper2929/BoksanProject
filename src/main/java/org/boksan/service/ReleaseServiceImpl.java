package org.boksan.service;

import java.util.ArrayList;
import java.util.Map;

import org.boksan.dao.ReleaseDao;
import org.boksan.model.Criteria;
import org.boksan.model.b_empDTO;
import org.boksan.model.b_releaseDTO;
import org.boksan.model.b_release_listDTO;
import org.boksan.model.materiaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseServiceImpl implements ReleaseService {

	@Autowired
	ReleaseDao rdao;
	
	public ArrayList<materiaDTO> release_recipe_select(Map<String, Object> objdata){
		
		int gross_weight = rdao.gross_weight_select(objdata);
		
		double need_weight = (double) Integer.parseInt(String.valueOf(objdata.get("need_weight")));
		
		double ratio = need_weight / (double)gross_weight;
		
		
		System.out.println(ratio);
		ArrayList<materiaDTO> result = rdao.release_recipe_select(objdata);
		
		for(int i = 0; i < result.size(); i++) {
			
			result.get(i).setMaterial_num(
					
					(int)(result.get(i).getMaterial_num()*ratio)
					
					);
		}
		
		return result;
		
	}
	
	//����û insert
	public void release_insert(b_releaseDTO rdto) {
		
		for(int i = 0; i < rdto.getRelease_insert_list().size(); i++) {
			
			rdto.setProduct_code(rdto.getRelease_insert_list().get(i).getProduct_code());
			rdto.setProduct_name(rdto.getRelease_insert_list().get(i).getProduct_name());
			rdto.setRelease_num(rdto.getRelease_insert_list().get(i).getRelease_num());
			
			rdao.release_insert(rdto);
			
		}
		
	}
	
	//����ûó����Ȳ select
	public ArrayList<b_releaseDTO> release_state_inquiry_select(Criteria cri){
		
		return rdao.release_state_inquiry_select(cri);
		
	}
	
	//����¡ ó���� ���� ��ü�Ǽ�
	public int getTotalCount(Criteria cri) {
		
		return rdao.getTotalCount(cri);
		
	}
	
	//����û���� select
	public ArrayList<b_releaseDTO> release_pay_select(Criteria cri){
		
		
		return rdao.release_pay_select(cri);
	}
	
	//����¡ ó���� ���� ��ü�Ǽ�(����)
	public int getTotalCount_pay(Criteria cri) {
		
		return rdao.getTotalCount_pay(cri);
		
	}
	
	//����û��� insert
	public void release_order_list_insert(b_release_listDTO rldto) {
		
		ArrayList<b_release_listDTO> pallet_list = rdao.getPalletList(rldto);

		int count = rldto.getRelease_num();//�䱸�� �߷� 230 100 + 100 + 30
		
		for(int i = 0; i < pallet_list.size(); i++) {

			rldto.setRelease_list_code(pallet_list.get(i).getRelease_list_code());
			rldto.setHouse_address(pallet_list.get(i).getHouse_address());

			if(pallet_list.get(i).getCumsum_num_check() == 1) {

				rldto.setRelease_num(pallet_list.get(i).getRelease_num());

				rdao.release_order_list_insert(rldto);

				count = count - rldto.getRelease_num();
				
				int pallet_num = rdao.pallet_num_select(rldto.getRelease_list_code());
				
				if(pallet_num == rldto.getRelease_num()) {
					rdao.release_stock_update(rldto);

				} else {
					rdao.release_stock_update_zero(rldto);
				}

			} else if(count < pallet_list.get(i).getRelease_num()) {

					rldto.setRelease_num(count);
					System.out.println("---------------rldto-------------");
					System.out.println(rldto);
					rdao.release_order_list_insert(rldto);
					
					int pallet_num = rdao.pallet_num_select(rldto.getRelease_list_code());
					
					if(pallet_num == rldto.getRelease_num()) {
						rdao.release_stock_update(rldto);

					} else {
						rdao.release_stock_update_zero(rldto);
					}

			}

		}

		rdao.release_update(rldto);
		
	}
	
	
	//����û���� ���
	public void release_cancel(int data) {
		
		rdao.release_cancel(data);
		
	}
	
	//������ø��
	public ArrayList<b_release_listDTO> release_order_list(Criteria cri){
		
		return rdao.release_order_list(cri);
		
	}
	
	//����¡ ó���� ���� ��ü�Ǽ�(������ø��)
	public int getTotalCount_order(Criteria cri) {
		
		return rdao.getTotalCount_order(cri);
		
	}
	
	//��� update
	public void release_stock_update(b_release_listDTO rldto) {
		
		//int pallet_num = rdao.pallet_num_select(rldto.getRelease_list_code());
		
		System.out.println("�ķ�Ʈ �� ����");
		//System.out.println(pallet_num);
		
		//if(pallet_num == rldto.getRelease_num()) {
		//	rdao.release_stock_update(rldto);

		//} else {
		//	rdao.release_stock_update_zero(rldto);
		//}
		
		//b_release_list����
		rdao.release_list_delete(rldto);
		
		//b_release����
		int release_list_check = rdao.release_list_check(rldto);
		
		if(release_list_check == 0) {
			rdao.release_delete(rldto);
		}
	}
	//recipe select
	public ArrayList<String> recipe_select(){
		return rdao.recipe_select();
	}
	
	//����û ȸ�������� ��ȸ
	public b_empDTO emp_select(String userId) {
		return rdao.emp_select(userId);
	}
	
	//�������ȭ�鿡�� �����ϱ� ���â ��ǰ�� ��� select
	public String release_order(int data) {
		return rdao.release_order(data);
	}
	
}
