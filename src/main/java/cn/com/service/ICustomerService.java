package cn.com.service;

import java.util.List;

import cn.com.bean.Customer;

public interface ICustomerService {
	
	public Customer selectCustomer(Customer cus);
	
	public Customer SelectCustomerByID(Customer cus);
	
	public int selectAllnumber();
	
	public List<Customer> selectCustomerPage(int page,int j);
	
	public void addCustomer(Customer cus);
	
	public int delete(Customer cus);
	
	public int updateCustomer(Customer cus);
}
