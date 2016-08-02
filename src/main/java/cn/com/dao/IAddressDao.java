package cn.com.dao;

import java.util.List;

import cn.com.bean.Address;

public interface IAddressDao {
	public List<Address> selectAddress();
	
	public Address selectAddressByID(Address a);
}
