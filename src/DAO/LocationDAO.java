package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.LocationVO;
import VO.LoginVO;
import VO.StaffVO;

public class LocationDAO {

	public void insertLocation(LocationVO lvo) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(lvo);
			tr.commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public List searchLocation(LocationVO lvo) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from LocationVO where status='open'");
		ls = q.list();

		return ls;
	}

	public void updateModel(LocationVO lvo) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionfactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			System.err.println("status is----------------" + lvo.getStatus());
			session.update(lvo);
			tr.commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	public List search(LocationVO lvo) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		System.err.println("from LocationVO where locationID='"+ lvo.getLocationID() + "' ");
		Query q = session.createQuery("from LocationVO where locationID='"+ lvo.getLocationID() + "' ");
		ls = q.list();

		return ls;

	}

	public List<LocationVO> inLocation(LocationVO lvo) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query q = session
				.createQuery("from LocationVO where status='inprogress'");
		ls = q.list();

		return ls;

	}

	public void closeModel(LocationVO lvo) {
		// TODO Auto-generated method stub

		SessionFactory sessionfactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		System.err.println("status is----------------" + lvo.getStatus());
		session.update(lvo);

		tr.commit();
		session.close();
	}

	public List searchLatlang(LocationVO lvo) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from LocationVO where locationID='"
				+ lvo.getLocationID() + "' ");
		ls = q.list();

		return ls;

	}

	public List<StaffVO> DriverByLogin(LoginVO loginVO2) {
		List ls = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from StaffVO where loginvo='"+loginVO2.getLoginID()+ "' ");
		ls = q.list();
		return ls;
	}

	public List<LocationVO> DriverAndCase(StaffVO staffVO) {
		List ls = new ArrayList();

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from LocationVO where ambulanceVO.ambulanceNumber='"+staffVO.getAvo().getAmbulanceNumber()+ "' ");
		ls = q.list();

		return ls;
	}

	/*
	 * public void delete(LocationVO lvo) { // TODO Auto-generated method stub
	 * SessionFactory sessionfactory=new
	 * Configuration().configure().buildSessionFactory(); Session
	 * session=sessionfactory.openSession(); Transaction
	 * tr=session.beginTransaction(); Query
	 * q=session.createQuery("delete from LocationVO where status='inprogress'"
	 * ); q.executeUpdate(); tr.commit();
	 * 
	 * session.close();
	 * 
	 * }
	 */

}
