package com.passtime.passtimeappli.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.passtime.passtimeappli.Model.Account;
import com.passtime.passtimeappli.Service.AccountService;

@Controller 
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	/*
	 *  méthode de l'iscription
	 *  /account/inscrire
	 *  retourne "oui", si tout s'est bien passé, non sinon (pour le moment)
	 */
	
	@ResponseBody
	@RequestMapping(value="/inscrire",method = RequestMethod.POST)
	public String inscrire(@RequestParam("title") String title,@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("email") String email, @RequestParam("pwd") String pwd, @RequestParam("datebirth") String datebirth, @RequestParam("phone") String phone, @RequestParam("address") String address, @RequestParam("addresscomp") String addresscomp, @RequestParam("postcode") String postcode, @RequestParam("town") String town)
	{
		SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = new Date();
		try {
			d = df.parse(datebirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.accountService.inscrire(title, prenom, prenom, email, pwd, d, phone, address, addresscomp, postcode, town);
	}
	/*
	 * Méthode de l'authentification
	 * /account/connect
	 * retourne "oui", si tout s'est bien passé, non sinon (pour le moment)
	 */
	@ResponseBody
	@RequestMapping(value="/connect",method = RequestMethod.POST)
	public Account SeConnecter(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		if(null != this.accountService.connect(email, password))
			return this.accountService.connect(email, password);
		else
			return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	public List<Account> TestConnection()
	{
		if(null != this.accountService.getAll())
			return this.accountService.getAll();
		else
		{
			ArrayList<Account> list = new ArrayList<Account>();
			Account a = new Account();
			a.setFamilyName("bounajma");
			a.setFirstName("mohamed");
			a.setEmail("bounajmamohamed@gmail.com");
			list.add(a);
			return list;
		}
	}
	/*
	 * method de test pour inscription
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/testInscrire",method = RequestMethod.GET)
	public String TestInscrire()
	{
		SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
		Date d = new Date();
		try {
			d = df.parse("1993-06-05");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.accountService.inscrire("M.","bounajma","mohamed","bounajmamohamed@gmail.com","123456",d, "0648212192","temare","el massira 2","10000","Rabat");
	}
	/*
	 * method de test pour inscription
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/testConnect",method = RequestMethod.GET)
	public Account TestConnect()
	{
		if(null != this.accountService.connect("bounajmamohamed@gmail.com", "123456"))
			return this.accountService.connect("bounajmamohamed@gmail.com", "123456");
		else
			return null;
	}
	
}
