package org.boksan.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "index";
	}
	
	//�԰� ��� ����Ʈ
	@RequestMapping(value = "/arrive_list", method = RequestMethod.GET)
	public String arrive_list() {
		
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
	public String join() {
		
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
	
	//�̵����ø��
	@RequestMapping(value = "/move_order_list", method = RequestMethod.GET)
	public String move_order_list() {
		
		return "move_order_list";
	}
	
	//�̵�����
	@RequestMapping(value = "/move_order", method = RequestMethod.GET)
	public String move_order() {
		
		return "move_order";
	}
	
	//���ֽ�û
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order() {
		
		return "order";
	}
	
	//�ķ�Ʈ����
	@RequestMapping(value = "/pallet", method = RequestMethod.GET)
	public String pallet() {
		
		return "pallet";
	}
	
	//��ǰ��ȸ
	@RequestMapping(value = "/product_inquiry", method = RequestMethod.GET)
	public String product_inquiry() {
		
		return "product_inquiry";
	}
	
	//��ǰ�� ��ġ��ȸ
	@RequestMapping(value = "/product_position_inquiry", method = RequestMethod.GET)
	public String product_position_inquiry() {
		
		return "product_position_inquiry";
	}
	
	//��ǰ���
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product() {
		
		return "product";
	}
	
	//�������߰�
	@RequestMapping(value = "/recipe_add", method = RequestMethod.GET)
	public String recipe_add() {
		
		return "recipe_add";
	}
	
	//�����ǻ󼼺���
	@RequestMapping(value = "/recipe_detail", method = RequestMethod.GET)
	public String recipe_detail() {
		
		return "recipe_detail";
	}
	
	//������ ���
	@RequestMapping(value = "/recipe_inquiry", method = RequestMethod.GET)
	public String recipe_inquiry() {
		
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
