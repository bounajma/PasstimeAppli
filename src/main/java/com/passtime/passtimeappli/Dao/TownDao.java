/**
 * 
 */
package com.passtime.passtimeappli.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.passtime.passtimeappli.Model.Address;
import com.passtime.passtimeappli.Model.Town;

/**
 * @author ALTR BUSINESS 1
 *
 */
public class TownDao {

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
public List<Town> getAll()
   {
	   try{
	   ArrayList<Town> list = new ArrayList<Town>();
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       Query query = session.getNamedQuery("Town.findAll");
       
       //Query query = session.createCriteria(town.class);
       query.setFirstResult(0);
       query.setMaxResults(2);
       
       
       list =(ArrayList<Town>) query.list();
       session.getTransaction().commit();
       session.close();
       System.out.println(list.size());
       return list;
	   }catch(Exception e) {
			// TODO: handle exception
			return null;
	   }
       
    }
	
}
