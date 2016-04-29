package com.passtime.passtimeappli.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.passtime.passtimeappli.Model.Address;
import com.passtime.passtimeappli.Model.Contact;
import com.passtime.passtimeappli.Service.AddressService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private AddressService addressService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public AddressService getAddressService() {
		return addressService;
	}
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	public static Logger getLogger() {
		return logger;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@ResponseBody
	@RequestMapping(value = "/connect", method = RequestMethod.POST)
	public List<Address> test( @RequestParam(value = "email", required = false) String memberId,
		    @RequestParam(value = "password", required = false) String member)
	{
		return  this.addressService.findAll();
	}
	@RequestMapping(value = "/saveCont", method = RequestMethod.GET)
	public void Reserve()
	{
		try {
			this.addressService.save();
			System.out.println("oui");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("non");
		}
	}
	
	
}
