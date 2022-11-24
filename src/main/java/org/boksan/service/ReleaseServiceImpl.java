package org.boksan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.boksan.dao.ArriveDao;
import org.boksan.dao.OrderDao;
import org.boksan.dao.ReleaseDao;
import org.boksan.model.Criteria;
import org.boksan.model.b_arriveDTO;
import org.boksan.model.b_empDTO;
import org.boksan.model.b_releaseDTO;
import org.boksan.model.b_release_listDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.model.materiaDTO;
import org.boksan.model.statementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseServiceImpl implements ReleaseService {

	@Autowired
	ReleaseDao rdao;
	
	@Autowired
	OrderDao odao;
	
	@Autowired
	ArriveDao adao;
	
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

				rdao.release_order_list_insert(rldto); //�������Ʈ�� �� �ִ� �κ�
				
				//�������Ʈ �������� ã�Ƽ� �����̸Ӹ�Ű ����
				String release_primary = rdao.release_order_list_primary_select();
				System.out.println("------release_primary------");
				System.out.println(release_primary);
				count = count - rldto.getRelease_num();
				System.out.println("------getRelease_list_code------");
				System.out.println(rldto.getRelease_list_code());
				int pallet_num = rdao.pallet_num_select(rldto.getRelease_list_code()); //�������Ʈ�� �������Ʈ�ڵ�(�ķ�Ʈ��) �ܰ� �˻��Ѱ�
				String pallet_num2 = rdao.pallet_num_select2(rldto.getRelease_list_code());
				System.out.println("------pallet_num------");
				System.out.println(pallet_num);
				//������Ʈ����(����)�� insert(���� �ڵ忡�� ã�� �ķ�Ʈ������ �츮�� ������ �����ؼ� �� ���̺� �μ�Ʈ���ٰ���)
				
				rdao.state_stock_insert(pallet_num2);
				
				//��ݳ���ģ�� �����̸Ӹ�Ű ��������(���������� ã���� ���� ģ�� ã��������)
				String state_num = rdao.state_stock_primary_select();
				System.out.println("------state_num------");
				System.out.println(state_num);
				Map <String,Object> map = new HashMap<String,Object>();
				
				map.put("release_primary", release_primary);
				map.put("state_num", state_num);
				System.out.println("------map------");
				System.out.println(map);
				//�� �����̸Ӹ�Ű�� �������Ʈ�� ������Ʈ
				rdao.release_list_state_update(map);
				
				if(pallet_num == rldto.getRelease_num()) { //���忡 null�� ������Ʈ�ϴ� �κ�
					rdao.release_stock_update(rldto);

				} else {
					rdao.release_stock_update_zero(rldto);
				}

			} else if(count < pallet_list.get(i).getRelease_num()) {

					rldto.setRelease_num(count);
					System.out.println("---------------rldto-------------");
					System.out.println(rldto);
					if(rldto.getRelease_num() != 0) {
						rdao.release_order_list_insert(rldto);
					}
					
					
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
	public void release_stock_update(HttpSession session, b_release_listDTO rldto) {
		System.out.println("----------rldto-------------");
		System.out.println(rldto);
		b_empDTO user = (b_empDTO) session.getAttribute("member");
		System.out.println("1111111111111");
		statementDTO stdto = new statementDTO();
		b_stockDTO sdto = new b_stockDTO();
		System.out.println("222222222222222");
		
		String product_code = rdao.statement_product_code_select(rldto.getRelease_list_code());
		System.out.println("-------------product_code-----------------");
		System.out.println(product_code);
		if(product_code == null) {
			
			product_code = rdao.state_stock_product_code_select(rldto.getState_num());
			
			rdao.state_stock_delete(rldto.getState_num());
			
		}
			
			sdto.setProduct_code(Integer.parseInt(product_code));

			stdto.setEmp_code(user.getEmp_code());
			stdto.setEmp_name(user.getName());
			stdto.setEmp_tel(user.getTel());
			stdto.setProduct_code(Integer.parseInt(product_code));

			statementDTO product_select = adao.statement_product_select(sdto);

			stdto.setProduct_name(product_select.getProduct_name());

			stdto.setProduct_country(product_select.getProduct_country());

			stdto.setProduct_business(product_select.getProduct_business());

			stdto.setProduct_price(product_select.getProduct_price()*rldto.getRelease_num());

			stdto.setQuantity(rldto.getRelease_num());

			rdao.statement_release_insert(stdto);
			
			
		
		
		
		
		System.out.println("�ķ�Ʈ �� ����");
		
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
	
	//�������ȭ�鿡�� �����ϱ� ���â ��ǰ�� ����� ���Ű� select
	public String release_order_price_select(int data) {
		return rdao.release_order_price_select(data);
	}
	
	//�������ȭ�鿡�� �����ϱ� ���â ��ǰ�� ��� �����ϱ� insert
	public void release_pay_order(HttpSession session, int order_num_count, int product_code) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("order_num_count", order_num_count);
		map.put("product_code", product_code);
		
		b_arriveDTO pc_num = new b_arriveDTO();
				
		pc_num.setProduct_code(product_code);
		
		int select_num = odao.pallet_in_ratio_select(pc_num);
		System.out.println("��ǰ����߷� : ");
		System.out.println(select_num);
		
		b_arriveDTO adto = new b_arriveDTO();

		adto.setArrive_num(order_num_count);
		adto.setProduct_code(product_code);
		
		if(adto.getArrive_num() > select_num) {
			
			int minus_num;
			
			while(true) {
				
				if(select_num >= adto.getArrive_num()) {
					rdao.release_pay_order(adto);
					break;
				}
				
				minus_num = adto.getArrive_num() - select_num;
				adto.setArrive_num(select_num);
				rdao.release_pay_order(adto);
				adto.setArrive_num(minus_num);
				
			}
			 
		} else {
			rdao.release_pay_order(adto);
		}
		
		b_empDTO user = (b_empDTO) session.getAttribute("member");
		
		statementDTO stdto = new statementDTO();
		b_stockDTO sdto = new b_stockDTO();
		sdto.setProduct_code(product_code);
		
		stdto.setEmp_code(user.getEmp_code());
		stdto.setEmp_name(user.getName());
		stdto.setEmp_tel(user.getTel());
		
		stdto.setProduct_code(product_code);
		
		statementDTO product_select = adao.statement_product_select(sdto);
		
		stdto.setProduct_name(product_select.getProduct_name());
		stdto.setProduct_country(product_select.getProduct_country());
		stdto.setProduct_business(product_select.getProduct_business());
		stdto.setProduct_price(product_select.getProduct_price()*order_num_count);
		stdto.setQuantity(order_num_count);
		
		rdao.statement_release_oder_insert(stdto);
	}
	
	//����û�� �����ȸ
	public String[] release_stock_check(String[] pc_arr, String [] rn_arr) {
		
		String[] pc_group_type_arr;
		String[] result_arr;
		pc_group_type_arr = new String [pc_arr.length];
		result_arr = new String [pc_arr.length];

		for(int i = 0; i < pc_arr.length; i++) {
			String tf = rdao.pc_group_type_select(pc_arr[i]);
			pc_group_type_arr[i] = tf;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		
		for(int i = 0; i < pc_arr.length; i++) {
			System.out.println(pc_group_type_arr[i]);
			if(pc_group_type_arr[i].equals("true")) {
				System.out.println("dsfasdfsadfasdfda");
				map.put("pc_arr", pc_arr[i]);
				map.put("rn_arr", rn_arr[i]);
				
				String pcs_check = rdao.pc_stock_check_select(map);
				
				if(pcs_check == null) {
					result_arr[i] = rn_arr[i];
				}else {
					result_arr[i] = pcs_check;
				}
				
			}else {
				result_arr[i] = "f";
			}
		}
		
		return result_arr;
		
	}
	
}
