package cn.com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import cn.com.bean.Customer;
import cn.com.dao.ICustomerDao;

public class CustomerDao implements ICustomerDao{

	private SessionFactory sessionFactory;
		
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//查询用户的姓和名，查询出来封装到一个对象里，返回结果是一个对象
	public Customer SelectCustomer(Customer cus) {
		int index = 0;
		String hql = "from Customer c where c.first_name = ? and c.last_name = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, cus.getFirst_name());
		query.setParameter(1, cus.getLast_name());
		Customer s;
		if(query.list().size()==0){
			
			s = null;
		}else{
			s = (Customer) query.list().get(0);
		}
		return s;
	}
	
	//查询记录条数
	public int SelectAllnumber() {
		String hql = "from Customer";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Customer> list = query.list();
		int allNumber  = list.size();
		return allNumber;
	}
	
	//分页查询
	public List<Customer> selectCustomerPage(int page,int j) {
		String hql = "from Customer c ORDER BY c.customer_id desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(((page-1)*j));//从第几行开始
		query.setMaxResults(j);//返回多少行
		List<Customer> list = query.list();
		return list;
	}
	
	//添加新的用户
	public void addCustomer(Customer cus) {
		sessionFactory.getCurrentSession().save(cus);	
		
	}
	
	//删除用户
	public int delete(Customer cus) {
	
		sessionFactory.getCurrentSession().delete(cus);
		
		return 0;
	}
	
	//更新用户信息
	public int updateCustomer(Customer cus) {
		sessionFactory.getCurrentSession().update(cus);		
		return 0;
	}
	
	//按照用户ID查询用户
	public Customer SelectCustomerByID(Customer cus) {
		String hql = "from Customer c where c.customer_id =?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, cus.getCustomer_id());
		Customer s;
		s = (Customer) query.list().get(0);
		return s;
	}


}