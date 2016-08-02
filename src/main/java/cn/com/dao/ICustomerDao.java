package cn.com.dao;

import java.util.List;

import cn.com.bean.Customer;

public interface ICustomerDao {

	public Customer SelectCustomer(Customer cus);
	
	public Customer SelectCustomerByID(Customer cus);
	
	public int SelectAllnumber();
	
	public List<Customer> selectCustomerPage(int page,int j);
	
	public void addCustomer(Customer cus);
	
	public int delete(Customer cus);
	
	public int updateCustomer(Customer cus);
	
}
