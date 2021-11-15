package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.AmbulanceVO;
import VO.AreaVO;

public class AmbulanceDAO {

	public void insertAmbulance(AmbulanceVO avo) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(avo);
		tr.commit();
		session.close();
		
	}

	public List searchAmbulance(AmbulanceVO avo) {
		// TODO Auto-generated method stub
		
		List ls=new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from AmbulanceVO where deleteStatus='active'");
		ls=q.list();
		
		return ls;
		
		
		
	}

	public List editAmbulance(AmbulanceVO avo) {
		// TODO Auto-generated method stub
List editlist=new ArrayList();
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Query query= session.createQuery("from AmbulanceVO where ambulanceNumber='"+avo.getAmbulanceNumber()+"'");
		editlist=query.list();
		
		tr.commit();
		return editlist;
	}

	public void updateAmbulance(AmbulanceVO avo) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(avo);
		tr.commit();
		session.close();
		
		
	}

	public void deleteAmbulance(AmbulanceVO avo) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionfactory.openSession();
				Transaction tr=session.beginTransaction();
				Query q=session.createQuery("update AmbulanceVO set deleteStatus='deactive' where ambulanceNumber='"+avo.getAmbulanceNumber()+"'");
				q.executeUpdate();
				tr.commit();
	}

	public void update(AmbulanceVO avo) {
		// TODO Auto-generated method stub
		
		
		
	}



	}
