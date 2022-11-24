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
	
	//출고요청 insert
	public void release_insert(b_releaseDTO rdto) {
		
		for(int i = 0; i < rdto.getRelease_insert_list().size(); i++) {
			
			rdto.setProduct_code(rdto.getRelease_insert_list().get(i).getProduct_code());
			rdto.setProduct_name(rdto.getRelease_insert_list().get(i).getProduct_name());
			rdto.setRelease_num(rdto.getRelease_insert_list().get(i).getRelease_num());
			
			rdao.release_insert(rdto);
			
		}
		
	}
	
	//출고요청처리현황 select
	public ArrayList<b_releaseDTO> release_state_inquiry_select(Criteria cri){
		
		return rdao.release_state_inquiry_select(cri);
		
	}
	
	//페이징 처리를 위한 전체건수
	public int getTotalCount(Criteria cri) {
		
		return rdao.getTotalCount(cri);
		
	}
	
	//출고요청결제 select
	public ArrayList<b_releaseDTO> release_pay_select(Criteria cri){
		
		
		return rdao.release_pay_select(cri);
	}
	
	//페이징 처리를 위한 전체건수(결제)
	public int getTotalCount_pay(Criteria cri) {
		
		return rdao.getTotalCount_pay(cri);
		
	}
	
	//출고요청목록 insert
	public void release_order_list_insert(b_release_listDTO rldto) {
		
		
		
		ArrayList<b_release_listDTO> pallet_list = rdao.getPalletList(rldto);

		int count = rldto.getRelease_num();//요구한 중량 230 100 + 100 + 30
		
		for(int i = 0; i < pallet_list.size(); i++) {

			rldto.setRelease_list_code(pallet_list.get(i).getRelease_list_code());
			rldto.setHouse_address(pallet_list.get(i).getHouse_address());

			if(pallet_list.get(i).getCumsum_num_check() == 1) {

				rldto.setRelease_num(pallet_list.get(i).getRelease_num());

				rdao.release_order_list_insert(rldto); //릴리즈리스트에 값 넣는 부분
				
				//릴리즈리스트 마지막행 찾아서 프라이머리키 저장
				String release_primary = rdao.release_order_list_primary_select();
				System.out.println("------release_primary------");
				System.out.println(release_primary);
				count = count - rldto.getRelease_num();
				System.out.println("------getRelease_list_code------");
				System.out.println(rldto.getRelease_list_code());
				int pallet_num = rdao.pallet_num_select(rldto.getRelease_list_code()); //릴리즈리스트에 릴리즈리스트코드(파레트넘) 단건 검색한거
				String pallet_num2 = rdao.pallet_num_select2(rldto.getRelease_list_code());
				System.out.println("------pallet_num------");
				System.out.println(pallet_num);
				//스테이트스톡(새거)에 insert(위에 코드에서 찾은 파레트넘으로 우리도 정보를 셀렉해서 새 테이블에 인설트해줄거임)
				
				rdao.state_stock_insert(pallet_num2);
				
				//방금넣은친구 프라이머리키 가져오고(마지막행을 찾으면 위에 친구 찾을수있음)
				String state_num = rdao.state_stock_primary_select();
				System.out.println("------state_num------");
				System.out.println(state_num);
				Map <String,Object> map = new HashMap<String,Object>();
				
				map.put("release_primary", release_primary);
				map.put("state_num", state_num);
				System.out.println("------map------");
				System.out.println(map);
				//그 프라이머리키를 릴리즈리스트에 업데이트
				rdao.release_list_state_update(map);
				
				if(pallet_num == rldto.getRelease_num()) { //스톡에 null로 업데이트하는 부분
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
	
	
	//출고요청결제 취소
	public void release_cancel(int data) {
		
		rdao.release_cancel(data);
		
	}
	
	//출고지시목록
	public ArrayList<b_release_listDTO> release_order_list(Criteria cri){
		
		return rdao.release_order_list(cri);
		
	}
	
	//페이징 처리를 위한 전체건수(출고지시목록)
	public int getTotalCount_order(Criteria cri) {
		
		return rdao.getTotalCount_order(cri);
		
	}
	
	//재고 update
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
			
			
		
		
		
		
		System.out.println("파레트 넘 셀렉");
		
		rdao.release_list_delete(rldto);
		
		//b_release삭제
		int release_list_check = rdao.release_list_check(rldto);
		
		if(release_list_check == 0) {
			rdao.release_delete(rldto);
		}
		
		
		
	}
	//recipe select
	public ArrayList<String> recipe_select(){
		return rdao.recipe_select();
	}
	
	//출고요청 회원정보를 조회
	public b_empDTO emp_select(String userId) {
		return rdao.emp_select(userId);
	}
	
	//출고지시화면에서 발주하기 모달창 상품의 재고 select
	public String release_order(int data) {
		return rdao.release_order(data);
	}
	
	//출고지시화면에서 발주하기 모달창 상품의 재고의 구매가 select
	public String release_order_price_select(int data) {
		return rdao.release_order_price_select(data);
	}
	
	//출고지시화면에서 발주하기 모달창 상품의 재고 발주하기 insert
	public void release_pay_order(HttpSession session, int order_num_count, int product_code) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("order_num_count", order_num_count);
		map.put("product_code", product_code);
		
		b_arriveDTO pc_num = new b_arriveDTO();
				
		pc_num.setProduct_code(product_code);
		
		int select_num = odao.pallet_in_ratio_select(pc_num);
		System.out.println("상품허용중량 : ");
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
	
	//출고요청시 재고조회
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
