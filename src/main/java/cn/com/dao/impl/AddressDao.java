package cn.com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.com.bean.Address;
import cn.com.bean.Customer;
import cn.com.dao.IAddressDao;

public class AddressDao  implements IAddressDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Address> selectAddress() {
		String hql = "from Address";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Address> list = query.list();
		return list;
	}
	
	
	public Address selectAddressByID(Address a) {
		String hql = "from Address c where c.address_id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, a.getAddress_id());
		Address address = (Address) query.list().get(0);
		return address;
	}

}
