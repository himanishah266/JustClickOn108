package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.ComplaintVO;

public class ComplaintDAO {

	public void insert(ComplaintVO complaintvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(complaintvo);
		tr.commit();
		session.close();
		
		
	}

	public List searchComplaint() {
		// TODO Auto-generated method stub
List ls=new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from ComplaintVO");
		ls=q.list();
		
		return ls;
	
	}

	public List replyComplaint(ComplaintVO complaintvo) {
		// TODO Auto-generated method stub
		List ls=new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from ComplaintVO where ComplaintID='"+complaintvo.getCid()+ "' ");
		ls=q.list();
		
		return ls;
		
			
		
	}

	public void sendResponse(ComplaintVO complaintvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(complaintvo);
		tr.commit();
		session.close();
		
		
	}
	

}
