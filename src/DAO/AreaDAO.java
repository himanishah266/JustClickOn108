package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.AreaVO;
import VO.StateVO;

public class AreaDAO {

	public void insertArea(AreaVO areavo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(areavo);
		tr.commit();
		session.close();
	}

	public List searchArea(AreaVO areavo) {
		// TODO Auto-generated method stub
		
		List ls=new ArrayList();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from AreaVO where deleteStatus='active'");
		ls=q.list();
		
		return ls;
		
	}

	public List editArea(AreaVO areavo) {
		// TODO Auto-generated method stub
		List editlist=new ArrayList();
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Query query= session.createQuery("from AreaVO where areaID='"+areavo.getAreaID()+"'");
		editlist=query.list();
		
		tr.commit();
		return editlist;
		
		
		
		
	}

	public void updateArea(AreaVO areavo) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(areavo);
		tr.commit();
		session.close();
		
	}

	public void deleteArea(AreaVO areavo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Query q=session.createQuery("update AreaVO set deleteStatus='deactive' where areaID='"+areavo.getAreaID()+"'");
		q.executeUpdate();
		tr.commit();
		
	}

	public List loadCity(StateVO statevo) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			Query q = session.createQuery("from CityVO where statevo='"+statevo.getStateID()+"' and deleteStatus='active' ");
			ls=q.list();
			tr.commit();
		
		return ls;
	
	}
		
		
	}


