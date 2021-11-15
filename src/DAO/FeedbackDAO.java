package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.FeedbackVO;

public class FeedbackDAO {

	public void insert(FeedbackVO feedbackvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(feedbackvo);
		tr.commit();
		session.close();
		
	}

	public List searchFeedback() {
		// TODO Auto-generated method stub
List ls=new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from FeedbackVO");
		ls=q.list();
		
		return ls;
		
		
	}

}
