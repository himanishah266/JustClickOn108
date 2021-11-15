package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CityVO;
import VO.HospitalVO;

public class HospitalDAO {

	public void insertHospital(HospitalVO hvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(hvo);
		tr.commit();
		session.close();
	}

	

	public List searchHospital(HospitalVO hvo) {
		// TODO Auto-generated method stub
		
		
List ls=new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from HospitalVO where deleteStatus='active'");
		ls=q.list();
		
		return ls;
	}



	public List editHospital(HospitalVO hvo) {
		// TODO Auto-generated method stub
List editlist=new ArrayList();
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Query query= session.createQuery("from HospitalVO where hospitalID='"+hvo.getHospitalID()+"'");
		editlist=query.list();
		
		tr.commit();
		return editlist;
		
		
		
		
	}

	public void updateHospital(HospitalVO hvo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(hvo);
		tr.commit();
		session.close();
		
	}



	public void deleteHospital(HospitalVO hvo) {
		
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Query q=session.createQuery("update HospitalVO set deleteStatus='deactive' where hospitalID='"+hvo.getHospitalID()+"'");
		q.executeUpdate();
		tr.commit();
		
		
	}



	public List loadArea(CityVO cityvo) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from AreaVO where cityvo='"+cityvo.getCityID()+"' and deleteStatus='active' ");
		ls=q.list();
		tr.commit();
	
	return ls;
		
		
		
	}

}
