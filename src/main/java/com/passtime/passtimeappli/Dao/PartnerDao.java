package com.passtime.passtimeappli.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.passtime.passtimeappli.Model.Partner;

public class PartnerDao {
	@Autowired
    private SessionFactory sessionFactory;

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @SuppressWarnings("unchecked")
	public List<Partner> getAll()
    {
    	ArrayList<Partner> liste = new ArrayList<Partner>();
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Criteria criteria = session.createCriteria(Partner.class);
    	liste = (ArrayList<Partner>) criteria.list();
    	session.getTransaction().commit();
    	session.close();
    	return liste;
    }
    @SuppressWarnings("unchecked")
	public Partner getFirst()
    {
    	ArrayList<Partner> liste = new ArrayList<Partner>();
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Criteria criteria = session.createCriteria(Partner.class);
    	liste = (ArrayList<Partner>) criteria.list(); 
    	session.getTransaction().commit();
    	session.close();
    	return liste.get(0);

    }
}
