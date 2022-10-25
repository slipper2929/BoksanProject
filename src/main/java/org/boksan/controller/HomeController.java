package org.boksan.controller;




import org.boksan.model.Criteria;
import org.boksan.model.PageDTO;

import org.boksan.model.Product_groupDTO;
import org.boksan.service.MemberService;

import org.boksan.service.ArriveService;

import org.boksan.service.ProductService;
import org.boksan.service.RecipeService;
import org.boksan.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	ArriveService aservice;

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
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
	public String arrive() {
		
		return "arrive";
	}
	
	//입고대기목록_검증
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check() {
		
		return "check";
	}
	
	//부서등록
	@RequestMapping(value = "/dept_add", method = RequestMethod.GET)
	public String dept_add() {
		
		return "dept_add";
	}
	
	//상품분류추가
	@RequestMapping(value = "/group_add", method = RequestMethod.GET)
	public String group_add() {
		
		return "group_add";
	}
	
	//창고등록
	@RequestMapping(value = "/house_add", method = RequestMethod.GET)
	public String house_add() {
		
		return "house_add";
	}
	
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("dept",mservice.dept_select());
		return "join";
	}
	
	//상품별 위치조회
	@RequestMapping(value = "/location_inquiry", method = RequestMethod.GET)
	public String location_inquiry() {
		
		return "location_inquiry";
	}
	
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	//업무권한부여
	@RequestMapping(value = "/manager_authority", method = RequestMethod.GET)
	public String manager_authority() {
		
		return "manager_authority";
	}
	
	//관리자_가입요청승인
	@RequestMapping(value = "/manager_emp_approve", method = RequestMethod.GET)
	public String manager_emp_approve() {
		
		return "manager_emp_approve";
	}
	
	//관리자_직원조회
	@RequestMapping(value = "/manager_emp_inquiry", method = RequestMethod.GET)
	public String manager_emp_inquiry() {
		
		return "manager_emp_inquiry";
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
	public String order(Model model) {
		
		model.addAttribute("pglist",rservice.recipe_add_select());
		
		
		return "order";
	}
	
	//파레트관리
	@RequestMapping(value = "/pallet", method = RequestMethod.GET)
	public String pallet(Model model) {
		model.addAttribute("pglist",rservice.recipe_add_select());
		return "pallet";
	}
	
	//상품조회
	@RequestMapping(value = "/product_inquiry", method = RequestMethod.GET)
	public String product_inquiry(Model model) {
		model.addAttribute("pilist",pservice.piproduct_select()); //상품조회 리스트
		return "product_inquiry";
	}
	
	//상품별 위치조회
	@RequestMapping(value = "/product_position_inquiry", method = RequestMethod.GET)
	public String product_position_inquiry() {
		
		return "product_position_inquiry";
	}
	
	//상품등록
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model) {
		model.addAttribute("plist",pservice.product_group_select()); //상품분류 select box
		return "product";
	}
	
	//레시피추가
	@RequestMapping(value = "/recipe_add", method = RequestMethod.GET)
	public String recipe_add(Model model) {
		
		model.addAttribute("pglist",rservice.recipe_add_select());
		
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
	public String release_order_list() {
		
		return "release_order_list";
	}
	
	//출고요청결제
	@RequestMapping(value = "/release_pay", method = RequestMethod.GET)
	public String release_pay() {
		
		return "release_pay";
	}
	
	//출고요청처리현황
	@RequestMapping(value = "/release_state_inquiry", method = RequestMethod.GET)
	public String release_state_inquiry() {
		
		return "release_state_inquiry";
	}
	
	//출고요청
	@RequestMapping(value = "/release", method = RequestMethod.GET)
	public String release() {
		
		return "release";
	}
	
	
}
