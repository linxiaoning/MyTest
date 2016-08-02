package cn.com.service.impl;

import java.util.List;

import cn.com.bean.Address;
import cn.com.dao.IAddressDao;
import cn.com.service.IAddressService;

public class AddressService implements IAddressService {

	private IAddressDao addressDao;
	

	public List<Address> selectAddress() {
		// TODO Auto-generated method stub
		return addressDao.selectAddress();
	}
	
	
	
	public Address selectAddressByID(Address a) {
		// TODO Auto-generated method stub
		return addressDao.selectAddressByID(a);
	}

	public IAddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(IAddressDao addressDao) {
		this.addressDao = addressDao;
	}


}
