package com.passtime.passtimeappli.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.passtime.passtimeappli.Dao.AccountDao;
import com.passtime.passtimeappli.Model.Account;

public class AccountService {
	@Autowired
	private AccountDao accountDao;

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public String inscrire(String title, String nom, String prenom, String email, String pwd, Date datebirth, String phone, String address, String addresscomp, String postcode, String town)
    {
		String reponse = this.accountDao.inscrire(title, nom, prenom, email, pwd, datebirth, phone, address, addresscomp, postcode, town);
		return reponse;
	}
	public Account connect(String email,String password)
	{
		return this.accountDao.checkConnection(email, password);
	}
	public List<Account> getAll()
	{
		if(null != this.accountDao.getAll())
			System.out.println(this.accountDao.getAll().size());
		return this.accountDao.getAll();
	}
	 public String Testinscrire()
	    {
		 return this.accountDao.Testinscrire();
	    }
}
