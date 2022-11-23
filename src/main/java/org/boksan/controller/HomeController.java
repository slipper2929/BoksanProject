package org.boksan.controller;



import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.boksan.model.Criteria;
import org.boksan.model.PageDTO;
import org.boksan.model.b_stockDTO;
import org.boksan.model.statementDTO;
import org.boksan.service.ArriveService;
import org.boksan.service.ManagerService;
import org.boksan.service.MemberService;
import org.boksan.service.ProductService;
import org.boksan.service.RecipeService;
import org.boksan.service.ReleaseService;
import org.boksan.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@Autowired
	RecipeService rservice;
	
	@Autowired
	StockService sservice;
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	MemberService mservice;

	@Autowired
	ArriveService aservice;
	
	@Autowired
	ManagerService mgservice;
	
	@Autowired
	ReleaseService relservice;

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Authentication authentication,HttpSession session) {
		
		if(authentication != null) {
			
			String userId = authentication.getName();
			session.getAttribute("member");
			session.setAttribute("member", relservice.emp_select(userId));
			
		}
		
		return "index";
	}
	
	//입고 대기 리스트
	@RequestMapping(value = "/arrive_list", method = RequestMethod.GET)
	public String arrive_list(Model model, Criteria cri) {
		
		model.addAttribute("alist",aservice.arrive_list_select(cri));
		
		//페이징 처리
		model.addAttribute("pageMaker",new PageDTO(cri,aservice.getTotalCount(cri)));
		
		model.addAttribute("plist",aservice.arrive_list_select_pallet());
		
		model.addAttribute("total",aservice.arrive_total_list());
		
		return "arrive_list";
	}
	
	
	//입고요청
	@RequestMapping(value = "/arrive", method = RequestMethod.GET)
	public String arrive(Model model) {
		
		model.addAttribute("pglist",rservice.recipe_add_select());
		
		return "arrive";
	}
	
	//입고대기목록_검증
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check() {
		
		return "check";
	}
	
	//상품분류추가
	@RequestMapping(value = "/group_add", method = RequestMethod.GET)
	public String group_add() {
		
		return "group_add";
	}
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("dept",mservice.dept_select());
		return "join";
	}
	
	//상품별 위치조회
	@RequestMapping(value = "/location_inquiry", method = RequestMethod.GET)
	public String location_inquiry(Model model, Criteria cri) {
		model.addAttribute("lilist", sservice.location_select(cri));
		model.addAttribute("pageMaker", new PageDTO(cri,sservice.getTotalCountLI(cri)));
		return "location_inquiry";
	}
	
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	//창고등록
	@RequestMapping(value = "/manager_house_add", method = RequestMethod.GET)
	public String manager_house(Model model) {
		model.addAttribute("hlist",mgservice.manager_house());
		return "manager_house_add";
	}
	
	
	//업무권한부여
	@RequestMapping(value = "/manager_authority", method = RequestMethod.GET)
	public String manager_authority() {
		
		return "manager_authority";
	}
	
	//관리자_가입요청승인
	@RequestMapping(value = "/manager_emp_approve", method = RequestMethod.GET)
	public String manager_emp_approve(Model model,Criteria cri) {
		model.addAttribute("applist",mgservice.emp_approve(cri));
		model.addAttribute("apdept",mgservice.emp_apdept(cri));
		//페이징 처리
		model.addAttribute("pageMaker",new PageDTO(cri,mgservice.getTotalCountAP(cri)));
		return "manager_emp_approve";
	}
	
	//관리자_직원조회
	@RequestMapping(value = "/manager_emp_inquiry", method = RequestMethod.GET)
	public String manager_emp_inquiry(Model model, Criteria cri) {
		model.addAttribute("emplist",mgservice.emp_select(cri));
		model.addAttribute("deptlist",mgservice.dept_selectbox());
		//페이징 처리
		model.addAttribute("pageMaker",new PageDTO(cri,mgservice.getTotalCountEMP(cri)));
		return "manager_emp_inquiry";
	}
	
	//부서등록
	@RequestMapping(value = "/manager_dept_group", method = RequestMethod.GET)
	public String manager_dept_group() {
		
		return "manager_dept_group";
	}
	
	//관리자_메인
	@RequestMapping(value = "/manager_main", method = RequestMethod.GET)
	public String manager_main() {
		
		return "manager_main";
	}
	
	//이동목록
	@RequestMapping(value = "/move_order_list", method = RequestMethod.GET)
	public String move_order_list(Model model,Criteria cri) {
		
		model.addAttribute("molist",sservice.move_list(cri));
		
		model.addAttribute("movement",sservice.movement(cri));
		
		model.addAttribute("pageMaker", new PageDTO(cri,sservice.getTotalCountMol(cri)));
		
		return "move_order_list";
	}
	
	//이동지시
	@RequestMapping(value = "/move_order", method = RequestMethod.GET)
	public String GetMoveorder(Model model, Criteria cri) {
		
		model.addAttribute("mlist", sservice.moveList(cri));
		
		model.addAttribute("pageMaker",new PageDTO(cri,sservice.getTotalCountMo(cri)));
		
		//ArrayList<b_stockDTO> list = sservice.moveList();
		//System.out.println(list);
		return "move_order";
	}
	
	//발주신청
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(
			Model model,
			@RequestParam(value="product_code", defaultValue="0") int rel_product_code,
			@RequestParam(value="product_name", defaultValue="0") String rel_product_name
			) {
		
				model.addAttribute("pglist",rservice.recipe_add_select());
				
				model.addAttribute("release_order",rel_product_code);
				model.addAttribute("release_order_name",rel_product_name);
				
				
				
				return "order";
	}
	
	//파레트관리
	@RequestMapping(value = "/pallet", method = RequestMethod.GET)
	public String pallet(Model model) {
		
		String data = "aaa";
		model.addAttribute("pglist",rservice.recipe_add_select());
		model.addAttribute("plist",sservice.DeletePalletSelect(data));
		return "pallet";
	}
	
	//상품조회
	@RequestMapping(value = "/product_inquiry", method = RequestMethod.GET)
	public String product_inquiry(Model model,Criteria cri) {
		model.addAttribute("pilist",pservice.piproduct_select(cri)); //상품조회 리스트
		model.addAttribute("pglist", pservice.gproduct_select(cri));
		model.addAttribute("pclist",pservice.cproduct_select());
		model.addAttribute("pblist", pservice.bproduct_select());
		//페이징 처리
		model.addAttribute("pageMaker",new PageDTO(cri,pservice.getTotalCountPI(cri)));
		return "product_inquiry";
	}
	
	//상품별 위치조회
	@RequestMapping(value = "/product_position_inquiry", method = RequestMethod.GET)
	public String product_position_inquiry(Model model,Criteria cri) {
		model.addAttribute("pplist",pservice.pplist_select(cri));
		model.addAttribute("pageMaker",new PageDTO(cri,pservice.getTotalCountPP(cri)));
		return "product_position_inquiry";
	}
	
	//상품등록
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model) {
		model.addAttribute("plist",pservice.product_group_select()); //상품분류 select box
		model.addAttribute("pclist",pservice.product_country_select());//원산지 셀렉트
		model.addAttribute("pblist",pservice.product_business_select());//업체 셀렉트
		return "product";
	}
	
	//레시피추가
	@RequestMapping(value = "/recipe_add", method = RequestMethod.GET)
	public String recipe_add(Model model) {
		
		model.addAttribute("pglist",rservice.recipe_add_select());
		model.addAttribute("rlist",relservice.recipe_select());
		return "recipe_add";
	}
	
	//레시피수정
	@RequestMapping(value = "/recipe_update", method = RequestMethod.GET)
	public String recipe_update(Model model, @RequestParam("product_code") int product_code) {
		System.out.println("프로덕트코드야 넘어와라 : " + product_code);
		
		model.addAttribute("product",rservice.recipe_update_get(product_code));
		
		model.addAttribute("pglist",rservice.recipe_add_select());
		
		return "recipe_update";
	}
	
	//레시피상세보기
	@RequestMapping(value = "/recipe_detail", method = RequestMethod.GET)
	public String recipe_detail(int rc, Model model) {
		
		
		
		model.addAttribute("choiseRecipe", rservice.recipe_detail(rc));
		
		return "recipe_detail";
	}
	
	//레시피 목록
	@RequestMapping(value = "/recipe_inquiry", method = RequestMethod.GET)
	public String recipe_inquiry(Model model, Criteria cri) {
		
		model.addAttribute("rlist",rservice.recipe_inquiry(cri));
		
		//페이징처리
		model.addAttribute("pageMaker",new PageDTO(cri,rservice.getTotalCount(cri)));
		
		return "recipe_inquiry";
	}
	
	//출고지시목록
	@RequestMapping(value = "/release_order_list", method = RequestMethod.GET)
	public String release_order_list(Model model, Criteria cri) {
		
		model.addAttribute("rolist", relservice.release_order_list(cri));
		
		//페이징처리
		model.addAttribute("pageMaker",new PageDTO(cri,relservice.getTotalCount_order(cri)));
		
		return "release_order_list";
	}
	
	//출고요청결제
	@RequestMapping(value = "/release_pay", method = RequestMethod.GET)
	public String release_pay(Model model, Criteria cri) {
		
		model.addAttribute("rplist", relservice.release_pay_select(cri));
		
		//페이징처리
		model.addAttribute("pageMaker",new PageDTO(cri,relservice.getTotalCount_pay(cri)));
		
		return "release_pay";
	}
	
	//출고요청처리현황
	@RequestMapping(value = "/release_state_inquiry", method = RequestMethod.GET)
	public String release_state_inquiry(Model model, Criteria cri) {
		
		model.addAttribute("rslist", relservice.release_state_inquiry_select(cri));
		
		//페이징처리
		model.addAttribute("pageMaker",new PageDTO(cri,relservice.getTotalCount(cri)));
		
		return "release_state_inquiry";
	}
	
	//출고요청
	@RequestMapping(value = "/release", method = RequestMethod.GET)
	public String release(Model model,Authentication authentication) {
		
		System.out.println("ddd");
		 String userId = authentication.getName();
		 //System.out.println("zzz");
		 System.out.println(userId);
		 
		model.addAttribute("pglist",rservice.recipe_add_select());
		model.addAttribute("rlist",relservice.recipe_select());
		//model.addAttribute("member",relservice.emp_select(userId));
		
		return "release";
	}
	
	//재고조회
	@RequestMapping(value="/stock", method= RequestMethod.GET)
	public String stock(Model model, Criteria cri) {
		model.addAttribute("slist",sservice.stock(cri));
		model.addAttribute("plist",sservice.stockAll());
		model.addAttribute("pageMaker", new PageDTO(cri,sservice.getTotalCountS(cri)));
		return "stock";
	}
	
	//전체조회
	@RequestMapping(value="/overall_check", method= RequestMethod.GET)
	public String overall_check() {
		
		return "overall_check";
	}

	//전체조회_입출고내역조회excel
			@SuppressWarnings("resource")
			@RequestMapping(value="/excelDownXlsx", method= RequestMethod.GET, produces="application/text;charset=utf-8")
			public void in_out_record_excel(
					HttpServletResponse response,
					@RequestParam(value="record_arr") String record_arr,
					@RequestParam(value="charge_name") String charge_name,
					@RequestParam(value="country_name") String country_name,
					@RequestParam(value="product_name") String product_name,
					@RequestParam(value="business_name") String business_name,
					@RequestParam(value="inquiry_date_start") String inquiry_date_start,
					@RequestParam(value="inquiry_date_end") String inquiry_date_end
					) throws IOException {
				
				Map<String, Object> record_data = new HashMap<String, Object>();
				
				record_data.put("charge_name", charge_name);
				record_data.put("country_name", country_name);
				record_data.put("country_name", country_name);
				record_data.put("product_name", product_name);
				record_data.put("business_name", business_name);
				record_data.put("inquiry_date_start", inquiry_date_start);
				record_data.put("inquiry_date_end", inquiry_date_end);
				
				String[] arr = record_arr.split(",");

				ArrayList<statementDTO> result = pservice.in_out_record(record_data, arr);
				

				XSSFWorkbook wb = null;
				Sheet sheet = null;
				Row row = null;
				Cell cell =null;
				wb = new XSSFWorkbook();
				sheet = wb.createSheet("입출고내역");
			
				
		
				
				
			
				
				//row(행)
				int cellCount=0;
				row = sheet.createRow(0);
				cell = row.createCell(cellCount++);
				cell.setCellValue("입출고내역코드");
				cell = row.createCell(cellCount++);
				cell.setCellValue("분류");
				cell = row.createCell(cellCount++);
				cell.setCellValue("날짜");
				cell = row.createCell(cellCount++);
				cell.setCellValue("상품명");
				cell = row.createCell(cellCount++);
				cell.setCellValue("상품원산지");
				cell = row.createCell(cellCount++);
				cell.setCellValue("공급사명");
				cell = row.createCell(cellCount++);
				cell.setCellValue("중량");
				cell = row.createCell(cellCount++);
				cell.setCellValue("가격");
				cell = row.createCell(cellCount++);
				cell.setCellValue("담당자명");
				cell = row.createCell(cellCount++);
				cell.setCellValue("담당자전화번호");
				
					for(int i=0; i<result.size(); i++) {
					row = sheet.createRow(i+1);
					cellCount = 0;
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getStatement_code());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getClassification());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getDate());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getProduct_name());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getProduct_country());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getProduct_business());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getQuantity());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getProduct_price());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getEmp_name());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getEmp_tel());
				}
				
				LocalDate now = LocalDate.now();	
				
			
				response.setContentType("Application/Msexcel");
			
				response.setHeader("Content-Disposition", "attachment;filename="+ now +"statement.xlsx");
			
				
				wb.write(response.getOutputStream());
			

				
			}
			
			//전체조회_재고조회excel
			@SuppressWarnings("resource")
			@RequestMapping(value="/stock_excel", method= RequestMethod.GET, produces="application/text;charset=utf-8")
			public void stock_excel(
					HttpServletResponse response,
					@RequestParam(value="record_arr") String record_arr,
					@RequestParam(value="product_name") String product_name,
					@RequestParam(value="country_name") String country_name,
					@RequestParam(value="inquiry_date_start") String inquiry_date_start,
					@RequestParam(value="inquiry_date_end") String inquiry_date_end,
					@RequestParam(value="business_name") String business_name,
					@RequestParam(value="house_code") String house_code
					) throws IOException {
				
				Map<String, Object> record_data = new HashMap<String, Object>();
				
				record_data.put("product_name", product_name);
				record_data.put("country_name", country_name);
				record_data.put("inquiry_date_start", inquiry_date_start);
				record_data.put("inquiry_date_end", inquiry_date_end);
				record_data.put("business_name", business_name);
				record_data.put("house_code", house_code);
				
				String[] arr = record_arr.split(",");
								
				ArrayList<b_stockDTO> result = pservice.stock_record(record_data, arr);
				System.out.println("스톡" + result);
				
				System.out.println("record_arr" + record_arr);
				System.out.println("product_name" + product_name);
				System.out.println("country_name" + country_name);
				System.out.println("inquiry_date_start" + inquiry_date_start);
				System.out.println("inquiry_date_end" + inquiry_date_end);
				System.out.println("business_name" + business_name);
				System.out.println("house_code" + house_code);
			
				XSSFWorkbook wb = null;
				Sheet sheet = null;
				Row row = null;
				Cell cell =null;
				wb = new XSSFWorkbook();
				sheet = wb.createSheet("재고조회");
				

				
				//row(행)
				int cellCount=0;
				row = sheet.createRow(0);
				cell = row.createCell(cellCount++);
				cell.setCellValue("파레트번호");
				cell = row.createCell(cellCount++);
				cell.setCellValue("상품명");
				cell = row.createCell(cellCount++);
				cell.setCellValue("원산지");
				cell = row.createCell(cellCount++);
				cell.setCellValue("공급사명");
				cell = row.createCell(cellCount++);
				cell.setCellValue("중량");
				cell = row.createCell(cellCount++);
				cell.setCellValue("창고번지");
				cell = row.createCell(cellCount++);
				cell.setCellValue("입고일");
			
			
				for(int i=0; i<result.size(); i++) {
					row = sheet.createRow(i+1);
					cellCount = 0;
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getPallet_num());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getProduct_name());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getCountry_name());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getBusiness_name());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getStock_num());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getHouse_code());
					cell = row.createCell(cellCount++);
					cell.setCellValue(result.get(i).getArrive_date());
				}
				
				
				
			
				LocalDate now = LocalDate.now();	
				
			
				response.setContentType("Application/Msexcel");
			
				response.setHeader("Content-Disposition", "attachment;filename="+ now +"stock.xlsx");
			
				
				wb.write(response.getOutputStream());
			

				
			}	
		

}
