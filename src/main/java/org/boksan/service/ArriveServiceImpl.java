package org.boksan.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.boksan.dao.ArriveDao;
import org.boksan.dao.OrderDao;
import org.boksan.model.Arrive_palletDTO;
import org.boksan.model.Arrive_totalDTO;
import org.boksan.model.Criteria;
import org.boksan.model.b_arriveDTO;
import org.boksan.model.b_empDTO;
import org.boksan.model.b_houseDTO;
import org.boksan.model.b_productDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.model.statementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArriveServiceImpl implements ArriveService{

	@Autowired
	ArriveDao adao;
	
	@Autowired
	OrderDao odao;
	
	//입고대기목록
	public ArrayList<b_arriveDTO> arrive_list_select(Criteria cri){
		
		return adao.arrive_list_select(cri);
		
	}
	
	//입고대기목록_파레트_select
	public ArrayList<Arrive_palletDTO> arrive_list_select_pallet(){
		
		return adao.arrive_list_select_pallet();
		
	}
	
	//페이징 처리를 위한 전체건수
	public int getTotalCount(Criteria cri) {
		
		return adao.getTotalCount(cri);
		
	}
	
	//상품별 총 대기목록
	public ArrayList<Arrive_totalDTO> arrive_total_list(){
		
		return adao.arrive_total_list();
		
	}
	
	//입고대기목록_검증 insert
	public void Arrive_insert(HttpSession session, b_stockDTO sdto, int arrive_code, b_houseDTO hdto) {
		
		b_empDTO user = (b_empDTO) session.getAttribute("member");
		
		System.out.println("과연 이름을...");
		System.out.println(user.getName()); 
		
		adao.Arrive_insert(sdto);
		
		adao.Arrive_delete(arrive_code);
		
		statementDTO stdto = new statementDTO();
		
		stdto.setEmp_code(user.getEmp_code());
		stdto.setEmp_name(user.getName());
		stdto.setEmp_tel(user.getTel());
		stdto.setProduct_code(sdto.getProduct_code());
		
		statementDTO product_select = adao.statement_product_select(sdto);
		
		stdto.setProduct_name(product_select.getProduct_name());
		stdto.setProduct_country(product_select.getProduct_country());
		stdto.setProduct_business(product_select.getProduct_business());
		stdto.setProduct_price(product_select.getProduct_price()*sdto.getStock_num());
		stdto.setQuantity(sdto.getStock_num());
		System.out.println("stdto임");
		System.out.println(stdto);
		adao.statement_arrive_insert(stdto);
		
		adao.house_quantity_plus_update(hdto);
		
	}
	
	//입고대기목록 insert
	public void Arrive_list_insert(b_arriveDTO adto) {
		int select_num = odao.pallet_in_ratio_select(adto);
		System.out.println("상품허용중량 : ");
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
