package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CityVO;

public class CityDAO {
	public void insertCity(CityVO cityvo) {
		SessionFactory sessionfactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(cityvo);
		tr.commit();
		session.close();
	}

	public List searchCity(CityVO cityvo) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		SessionFactory sessionfactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from CityVO where deleteStatus='active'");
		ls = query.list();
		tr.commit();
		session.close();
		return ls;

	}

	public List editCity(CityVO cityvo) {
		// TODO Auto-generated method stub
		List ls=new ArrayList();
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		tr.commit();
		Query query= session.createQuery("from CityVO where CityID='"+cityvo.getCityID()+"'");
		ls=query.list();
		return ls;
		
	}

	public void update(CityVO cityvo) {
		// TODO Auto-generated method stub
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.saveOrUpdate(cityvo);
			
			tr.commit();
			
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		
	}

	public void deleteCity(CityVO cityvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		
		Query q=session.createQuery("update CityVO set deleteStatus='deactive' where cityID='"+cityvo.getCityID()+"' ");
		q.executeUpdate();
	
		tr.commit();
		
	}
}
