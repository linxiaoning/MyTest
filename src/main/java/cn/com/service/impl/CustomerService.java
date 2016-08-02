package cn.com.service.impl;

import java.util.List;

import cn.com.bean.Customer;
import cn.com.dao.ICustomerDao;
import cn.com.service.ICustomerService;

public class CustomerService implements ICustomerService {

	private ICustomerDao customerdao;

	public ICustomerDao getCustomerdao() {
		return customerdao;
	}

	public void setCustomerdao(ICustomerDao customerdao) {
		this.customerdao = customerdao;
	}

	
	public Customer selectCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return customerdao.SelectCustomer(cus);
	}

	
	public int selectAllnumber() {
		// TODO Auto-generated method stub
		return customerdao.SelectAllnumber();
	}

	
	public List<Customer> selectCustomerPage(int page, int j) {
		// TODO Auto-generated method stub
		return customerdao.selectCustomerPage(page, j);
	}


	public void addCustomer(Customer cus) {
		// TODO Auto-generated method stub
		customerdao.addCustomer(cus);
	}

	
	public int delete(Customer cus) {
		// TODO Auto-generated method stub
		System.out.println("delete");
		return customerdao.delete(cus);
	}

	public int updateCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return customerdao.updateCustomer(cus);
	}


	public Customer SelectCustomerByID(Customer cus) {
		// TODO Auto-generated method stub
		return customerdao.SelectCustomerByID(cus);
	}

}
