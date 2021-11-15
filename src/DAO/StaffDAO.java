package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.AreaVO;
import VO.StaffVO;

public class StaffDAO {

	public void insertStaff(StaffVO svo) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(svo);
		tr.commit();
		session.close();
		
		
	}

	public List searchStaff(StaffVO svo) {
		// TODO Auto-generated method stub
		
	List ls=new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		Query q=session.createQuery("from StaffVO where deleteStatus='active'");
		ls=q.list();
		
		return ls;
		
		
		
	}

	public List editStaff(StaffVO svo) {
		// TODO Auto-generated method stub
		
List editlist=new ArrayList();
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Query query= session.createQuery("from StaffVO where serialNo='"+svo.getSerialNo()+"'");
		editlist=query.list();
		
		tr.commit();
		return editlist;
		
		
	}

	public void updateStaff(StaffVO svo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(svo);
		tr.commit();
		session.close();
		
	}

	public void deleteStaff(StaffVO svo) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Query q=session.createQuery("update StaffVO set deleteStatus='deactive' where serialNo='"+svo.getSerialNo()+"'");
		q.executeUpdate();
		tr.commit();


		
		
	}

	public List loadAmbulance(AreaVO areavo) {
		// TODO Auto-generated method stub
List ls = new ArrayList();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("from AmbulanceVO where areavo='"+areavo.getAreaID()+"' and deleteStatus='active' ");
		ls=q.list();
		tr.commit();
		System.out.println(ls.size());
	
	return ls;
		
		
	}

}
