package com.java.dao;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.java.entity.Corporate1;

import com.java.entity.User;
@Repository
public class dao {
	@Autowired
	SessionFactory sessionfactory;
Corporate1 corporate;
// Dao Layer 
	public boolean checklogin(User user) {
		
		//login Connection and process
		String username=user.getUsername();
		
		String password=user.getPassword();
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username",username));
	
		criteria.add(Restrictions.eq("password",password));
		List<User> listuser=criteria.list();
		if(!listuser.isEmpty())
		{
		
			return true;
		}
		else
		{
		
			return false;
		}
	}

//Iterate a list for home page
	public List<Corporate1> getcor() {
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Corporate1.class);
		List<Corporate1>listcor=criteria.list();
			return listcor;
	}

// Add to the record using query fire through hibernate
	public boolean addcor(Corporate1 cor) {
		Session session=sessionfactory.openSession();
		org.hibernate.Transaction transaction=session.beginTransaction();
		
		session.save(cor);
		transaction.commit();
		
		return true;
	}

//Delete Record from database
	public boolean deletecor(int stid) {
		Session session=sessionfactory.openSession();
		org.hibernate.Transaction transcation=session.beginTransaction();
		Corporate1 cor=session.get(Corporate1.class, stid);
		session.delete(cor);
		
		transcation.commit();
		
		return true;
	}


	public List<Corporate1> getproj(int idprj) {
		System.out.println("d1");
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		System.out.println("d2");
		Criteria criteria=session.createCriteria(Corporate1.class);
		criteria.add(Restrictions.eq("srNo",idprj));
		System.out.println("d3");
		List<Corporate1>listproj=criteria.list();
	
		System.out.println("d4");
		
		return listproj;
	}


	public boolean updateproj(Corporate1 proj) {
		
		System.out.println("d5");
		Session session=sessionfactory.openSession();
		
		org.hibernate.Transaction transaction=session.beginTransaction();
		System.out.println("d6");
		session.saveOrUpdate(proj);
		
		System.out.println("update");
		
		transaction.commit();
		
		return true;
	}


}
