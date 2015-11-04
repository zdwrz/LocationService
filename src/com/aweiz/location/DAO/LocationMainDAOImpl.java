package com.aweiz.location.DAO;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aweiz.location.entity.LocationMain;

@Component
public class LocationMainDAOImpl implements LocationMainDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer save(LocationMain main) {
		Integer seqId = (Integer)sessionFactory.getCurrentSession().save(main);
		return seqId;
	}

	@Override
	public LocationMain getLastLocation() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(LocationMain.class);
		crit.addOrder(Order.desc("seqId"));
		crit.setMaxResults(1);
		return (LocationMain)crit.uniqueResult();
	}
	
}
