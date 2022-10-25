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
	
	//�԰� ��� ����Ʈ
	@RequestMapping(value = "/arrive_list", method = RequestMethod.GET)
	public String arrive_list(Model model, Criteria cri) {
		
		model.addAttribute("alist",aservice.arrive_list_select(cri));
		
		//����¡ ó��
		model.addAttribute("pageMaker",new PageDTO(cri,aservice.getTotalCount(cri)));
		
		model.addAttribute("plist",aservice.arrive_list_select_pallet());
		
		model.addAttribute("total",aservice.arrive_total_list());
		
		return "arrive_list";
	}
	
	
	//�԰��û
	@RequestMapping(value = "/arrive", method = RequestMethod.GET)
	public String arrive() {
		
		return "arrive";
	}
	
	//�԰�����_����
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check() {
		
		return "check";
	}
	
	//�μ����
	@RequestMapping(value = "/dept_add", method = RequestMethod.GET)
	public String dept_add() {
		
		return "dept_add";
	}
	
	//��ǰ�з��߰�
	@RequestMapping(value = "/group_add", method = RequestMethod.GET)
	public String group_add() {
		
		return "group_add";
	}
	
	//â����
	@RequestMapping(value = "/house_add", method = RequestMethod.GET)
	public String house_add() {
		
		return "house_add";
	}
	
	
	//ȸ������
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("dept",mservice.dept_select());
		return "join";
	}
	
	//��ǰ�� ��ġ��ȸ
	@RequestMapping(value = "/location_inquiry", method = RequestMethod.GET)
	public String location_inquiry() {
		
		return "location_inquiry";
	}
	
	//�α���
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	//�������Ѻο�
	@RequestMapping(value = "/manager_authority", method = RequestMethod.GET)
	public String manager_authority() {
		
		return "manager_authority";
	}
	
	//������_���Կ�û����
	@RequestMapping(value = "/manager_emp_approve", method = RequestMethod.GET)
	public String manager_emp_approve() {
		
		return "manager_emp_approve";
	}
	
	//������_������ȸ
	@RequestMapping(value = "/manager_emp_inquiry", method = RequestMethod.GET)
	public String manager_emp_inquiry() {
		
		return "manager_emp_inquiry";
	}
	
	//������_����
	@RequestMapping(value = "/manager_main", method = RequestMethod.GET)
	public String manager_main() {
		
		return "manager_main";
	}
	
	//�̵����
	@RequestMapping(value = "/move_order_list", method = RequestMethod.GET)
	public String move_order_list(Model model,Criteria cri) {
		
		model.addAttribute("molist",sservice.move_list(cri));
		
		model.addAttribute("movement",sservice.movement(cri));
		
		model.addAttribute("pageMaker", new PageDTO(cri,sservice.getTotalCountMol(cri)));
		
		return "move_order_list";
	}
	
	//�̵�����
	@RequestMapping(value = "/move_order", method = RequestMethod.GET)
	public String GetMoveorder(Model model, Criteria cri) {
		
		model.addAttribute("mlist", sservice.moveList(cri));
		
		model.addAttribute("pageMaker",new PageDTO(cri,sservice.getTotalCountMo(cri)));
		
		//ArrayList<b_stockDTO> list = sservice.moveList();
		//System.out.println(list);
		return "move_order";
	}
	
	//���ֽ�û
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(Model model) {
		
		model.addAttribute("pglist",rservice.recipe_add_select());
		
		
		return "order";
	}
	
	//�ķ�Ʈ����
	@RequestMapping(value = "/pallet", method = RequestMethod.GET)
	public String pallet(Model model) {
		model.addAttribute("pglist",rservice.recipe_add_select());
		return "pallet";
	}
	
	//��ǰ��ȸ
	@RequestMapping(value = "/product_inquiry", method = RequestMethod.GET)
	public String product_inquiry(Model model) {
		model.addAttribute("pilist",pservice.piproduct_select()); //��ǰ��ȸ ����Ʈ
		return "product_inquiry";
	}
	
	//��ǰ�� ��ġ��ȸ
	@RequestMapping(value = "/product_position_inquiry", method = RequestMethod.GET)
	public String product_position_inquiry() {
		
		return "product_position_inquiry";
	}
	
	//��ǰ���
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model) {
		model.addAttribute("plist",pservice.product_group_select()); //��ǰ�з� select box
		return "product";
	}
	
	//�������߰�
	@RequestMapping(value = "/recipe_add", method = RequestMethod.GET)
	public String recipe_add(Model model) {
		
		model.addAttribute("pglist",rservice.recipe_add_select());
		
		return "recipe_add";
	}
	
	//�����Ǽ���
	@RequestMapping(value = "/recipe_update", method = RequestMethod.GET)
	public String recipe_update(Model model, @RequestParam("product_code") int product_code) {
		System.out.println("���δ�Ʈ�ڵ�� �Ѿ�Ͷ� : " + product_code);
		
		model.addAttribute("product",rservice.recipe_update_get(product_code));
		
		model.addAttribute("pglist",rservice.recipe_add_select());
		
		return "recipe_update";
	}
	
	//�����ǻ󼼺���
	@RequestMapping(value = "/recipe_detail", method = RequestMethod.GET)
	public String recipe_detail(int rc, Model model) {
		
		
		
		model.addAttribute("choiseRecipe", rservice.recipe_detail(rc));
		
		return "recipe_detail";
	}
	
	//������ ���
	@RequestMapping(value = "/recipe_inquiry", method = RequestMethod.GET)
	public String recipe_inquiry(Model model, Criteria cri) {
		
		model.addAttribute("rlist",rservice.recipe_inquiry(cri));
		
		//����¡ó��
		model.addAttribute("pageMaker",new PageDTO(cri,rservice.getTotalCount(cri)));
		
		return "recipe_inquiry";
	}
	
	//������ø��
	@RequestMapping(value = "/release_order_list", method = RequestMethod.GET)
	public String release_order_list() {
		
		return "release_order_list";
	}
	
	//����û����
	@RequestMapping(value = "/release_pay", method = RequestMethod.GET)
	public String release_pay() {
		
		return "release_pay";
	}
	
	//����ûó����Ȳ
	@RequestMapping(value = "/release_state_inquiry", method = RequestMethod.GET)
	public String release_state_inquiry() {
		
		return "release_state_inquiry";
	}
	
	//����û
	@RequestMapping(value = "/release", method = RequestMethod.GET)
	public String release() {
		
		return "release";
	}
	
	
}
