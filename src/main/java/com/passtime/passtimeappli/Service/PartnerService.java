package com.passtime.passtimeappli.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.passtime.passtimeappli.Dao.PartnerDao;
import com.passtime.passtimeappli.Model.Partner;

public class PartnerService {
	@Autowired
	private PartnerDao partnerDao;

	public PartnerDao getPartnerDao() {
		return partnerDao;
	}

	public void setPartnerDao(PartnerDao partnerDao) {
		this.partnerDao = partnerDao;
	}
	
	public List<Partner> getAll()
	{
		return this.partnerDao.getAll();
	}
	public Partner getFirst()
	{
		return this.partnerDao.getFirst();
	}
}
