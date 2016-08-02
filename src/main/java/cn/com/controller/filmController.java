package cn.com.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.bean.Address;
import cn.com.bean.Customer;
import cn.com.service.IAddressService;
import cn.com.service.ICustomerService;


@Controller
@RequestMapping("/film")
public class filmController {
	@Resource(name="customerService")
	private ICustomerService customerService;
	@Resource(name="addressService")
	private IAddressService addressService;
	
	//验证登录信息的模块
	@RequestMapping("/toLogin")
	public String toLogin(Customer customer,HttpServletRequest request){
		if(customerService.selectCustomer(customer)!=null){
			request.getSession().setAttribute("name",customer.getFirst_name());
			return "redirect:/film/toAll";
		}else {
			return "/login2";
		}
	}
	
	//获取所有数据的模块
	@RequestMapping("/toAll")
	public String toAll(Customer customer,HttpServletRequest request){
		ArrayList<Customer> list=(ArrayList<Customer>) customerService.selectCustomerPage(0,20);
		request.setAttribute("list", list);
		return "/customer2";
	}
	
	
	
	
	//添加用户信息的模块
	@RequestMapping("/toAdd")
	public String addCustomer(Customer customer){
		//定义一个时间戳，来记录当前时间
		customer.setCreate_date(new Timestamp(System.currentTimeMillis()));
		customer.setLast_update(new Timestamp(System.currentTimeMillis()));
		customer.setStore_id((byte)1);
		customerService.addCustomer(customer);
		return "redirect:/film/toAll";
	}
	
	//删除用户信息的模块，其中@ResponseBody表示该方法的返回结果直接写入HTTP response body中
	
	@RequestMapping("/toDelete")
	public String delete(Customer customer, HttpServletRequest request, HttpServletResponse response) {
		customer = customerService.SelectCustomerByID(customer);
		customerService.delete(customer);
		return "redirect:/film/toAll";
	}

	//修改用户信息的模块
	@RequestMapping("/toUpdate")
	public String updateCustomer(Customer customer,HttpServletRequest request){
		ArrayList<Address> addressList= (ArrayList<Address>) addressService.selectAddress();
		request.setAttribute("addressList11", addressList);	
		Customer cus = customerService.SelectCustomerByID(customer);
		cus.setFirst_name(customer.getFirst_name());
		cus.setLast_name(customer.getLast_name());
		cus.setAddress_id(addressService.selectAddressByID(customer.getAddress_id()));
		cus.setEmail(customer.getEmail());
		customerService.updateCustomer(cus);		
		return "redirect:/film/toAll";
	}
	
	//查询所有地址信息模块
	@RequestMapping("/toAllAddress")
	public String selectAllAddress(HttpServletRequest request){
		ArrayList<Address> addressList = (ArrayList<Address>) addressService.selectAddress();
		request.setAttribute("list", addressList);		
		return "/newcustomer";	
	}
	
	//实现地址模块对前台ajax交互模块
	@RequestMapping("/toSelectAllAddressAjax")
	@ResponseBody
	public ArrayList<Address> selectAllAddress2(){
		ArrayList<Address> addressList = (ArrayList<Address>) addressService.selectAddress();
		return addressList;	
	}
	
//主界面实现分页模块
	@RequestMapping("/toAjaxPaget")
	@ResponseBody
	public Map<String,Object> ajaxPaget(HttpServletRequest request) {
		 Map<String, Object> map=new HashMap<String, Object>();
		 ArrayList<Customer> customerList = new ArrayList<Customer>();
//当前所在的页数
		 int page = Integer.parseInt(request.getParameter("page"));
		 customerList = (ArrayList<Customer>) customerService.selectCustomerPage(page, 20);
//获取每页有多少条数据
		 int size = 20;
		 //获取数据库总共的数据
		 int num = customerService.selectAllnumber();
		 //计算出共有多少页
		 int totalPage=num/size;
		 if(num%size!=0){
			 totalPage += 1;
		 }
		 map.put("customerList", customerList);
		 map.put("page", page);
		 map.put("totalPage", totalPage);
		 return map;
	}


	}

	

