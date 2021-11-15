package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.LoginVO;
import VO.RegisterVO;

public class RegisterDAO {

	public void insert(RegisterVO registervo) {
		

		// TODO Auto-generated method stub
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(registervo);
		tr.commit();
		session.close();
		
	}

	public void insert(LoginVO loginvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(loginvo);
		tr.commit();
		session.close();
		

	}

	public List authentication(LoginVO loginvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Query q=session.createQuery("from LoginVO where user_name='"+loginvo.getUserName() +"' and password='"+loginvo.getPassword()+"'");
		List ls=q.list();
		return ls;
		
	}

	public List searchAdmin() {
		// TODO Auto-generated method stub
		
		
		
List ls=new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from LoginVO where userType='admin'");
		ls=q.list();
		
		return ls;

	}

	public List searchEmail(LoginVO loginvo) {
		// TODO Auto-generated method stub
List ls=new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from LoginVO where userName='"+loginvo.getUserName()+"' ");
		ls=q.list();
		
		return ls;
		
		
	}

	public List search(LoginVO loginvo) {
		// TODO Auto-generated method stub
		
List ls=new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from LoginVO where loginID='"+loginvo.getLoginID()+"' ");
		ls=q.list();
		
		return ls;
	
	}

	public void updatePassword(LoginVO loginvo) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Transaction tr=session.beginTransaction();

		Query q=session.createQuery("update LoginVO set password='"+loginvo.getPassword()+"'  where user_Name='"+loginvo.getUserName()+"  '");
		q.executeUpdate();
	
		tr.commit();
		
	}

	

}
