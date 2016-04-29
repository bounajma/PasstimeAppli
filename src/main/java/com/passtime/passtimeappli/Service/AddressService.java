package com.passtime.passtimeappli.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.passtime.passtimeappli.Dao.AddressDao;
import com.passtime.passtimeappli.Model.Address;

public class AddressService {
	 @Autowired
	    private AddressDao addressDao;

	   
	     public AddressDao getAddressDao() {
		return addressDao;
	}


	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}


		public List<Address> findAll()
	   {
	       return this.addressDao.findAll();
	   } 
		
		public void save()
		{
			this.addressDao.save();
		}
}
