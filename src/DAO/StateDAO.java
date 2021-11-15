package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.StateVO;

public class StateDAO {

	public void insert(StateVO vo) {
		// TODO Auto-generated method stub
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(vo);
			
			tr.commit();
			
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		
		
	}
	public List search(StateVO vo)
	{
		List ls=new ArrayList();
		
		
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		
		Query query= session.createQuery("from StateVO where deleteStatus='active'");
		ls=query.list();
		
			
			
	
		return ls;
	}
public List edit(StateVO vo)
{
	List ls=new ArrayList();
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
	Session session=sessionfactory.openSession();
	Transaction tr=session.beginTransaction();
	tr.commit();
	Query query= session.createQuery("from StateVO where stateID='"+vo.getStateID()+"'");
	ls=query.list();
	return ls;
	
}
public void update(StateVO vo) {
	// TODO Auto-generated method stub
	try
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session =sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		session.update(vo);
		
		tr.commit();
		
	}
	catch(Exception z)
	{
		z.printStackTrace();
	}
	
	
}
public void delete(StateVO statevo) {
	// TODO Auto-generated method stub
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	Session session =sessionFactory.openSession();
	
	Transaction tr = session.beginTransaction();
	
	Query  q=session.createQuery("update StateVO set deleteStatus='deactive' where stateID='"+statevo.getStateID()+"' ");
	q.executeUpdate();
	
	tr.commit();
	session.close();
}

}