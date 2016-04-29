package com.passtime.passtimeappli.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.passtime.passtimeappli.Model.Account;
import com.passtime.passtimeappli.Model.Country;

public class AccountDao {
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
    public Account checkConnection(String email,String password)
    {
    	try {
    		Account account;
    		Session session = sessionFactory.openSession();
    	       session.beginTransaction();
    	       Criteria criteria = session.createCriteria(Account.class);
    	       criteria.add(Restrictions.eq("login", email)).add(Restrictions.eq("password",password));
    	       account = (Account) criteria.uniqueResult();
    	       session.getTransaction().commit();
    	       session.close();
    	      
    	       return account;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    }
 
    public String inscrire(String title, String nom, String prenom, String email, String pwd, Date datebirth, String phone, String address, String addresscomp, String postcode, String town)
    {
    	Account compte = new Account();
    	compte.setEmail(email);
    	compte.setFirstName(prenom);
    	compte.setFamilyName(nom);
    	compte.setPassword(pwd);
    	compte.setLogin(email);
    	compte.setTitle(title);
    	compte.setDateBirth(datebirth);
    	compte.setMobilePhone(phone);
    	compte.setAddress(address);
    	compte.setAddressAdditional(addresscomp);
    	compte.setPostcode(postcode);
    	compte.setTown(town);
    	compte.setAccountActive((byte) 1);
    	compte.setDateRegistration(new java.sql.Timestamp((new Date()).getTime()));
    	compte.setDateLastConnection(new java.sql.Timestamp((new Date()).getTime()));
    	try{
    		Session session = sessionFactory.openSession();
 	        session.beginTransaction();
 	        session.save(compte);
 	        session.getTransaction().commit();
 	        session.close();
 	        return "oui";
 	       
    	}catch(Exception e)
    	{
    		return "non";
    	}
    }
    @SuppressWarnings("unchecked")
	public List<Account> getAll()
    {
    	try {
    		ArrayList<Account> account;
    		Session session = sessionFactory.openSession();
    	       session.beginTransaction();
    	       Query query = session.getNamedQuery("Account.findAll");
    	       session.getTransaction().commit();
    	       account = (ArrayList<Account>) query.uniqueResult();
    	       session.close();
    	       return account;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    }
    public String Testinscrire()
    {
    	Account compte = new Account();
    	compte.setEmail("bounajmamohamed@gmail.com");
    	compte.setFirstName("Mohamed");
    	compte.setFamilyName("Bounajma");
    	compte.setPassword("123456");
    	compte.setLogin("bounajmamohamed@gmail.com");
    	compte.setChangePassword((byte) 0);
    	compte.setAccountActive((byte) 1);
    	try{
    		Session session = sessionFactory.openSession();
 	        session.beginTransaction();
 	        session.save(compte);
 	        session.getTransaction().commit();
 	        session.close();
 	        return "oui";
 	       
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		return "non";
    	}
    }
}
