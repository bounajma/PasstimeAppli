package com.passtime.passtimeappli.Dao;



import com.passtime.passtimeappli.Model.Address;
import com.passtime.passtimeappli.Model.Contact;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressDao {
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
public List<Address> findAll()
   {
	   ArrayList<Address> list = new ArrayList<Address>();
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       Query query = session.createQuery("from Address where id = 7"); 
       list =(ArrayList<Address>) query.list();
       session.getTransaction().commit();
       session.close();
       return list;
       
    }
   public void save()
   {
	   Contact c = new Contact();
		c.setName("mohamed");
		c.setEmailFrom("myemail");
		c.setEmailTo("youremail");
		c.setSubject("Sujet");
		 Session session = sessionFactory.openSession();
	       session.beginTransaction();
	       session.save(c);
	       session.getTransaction().commit();
	       session.close(); 
   }
  
}
