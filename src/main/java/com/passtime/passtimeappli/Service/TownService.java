/**
 * 
 */
package com.passtime.passtimeappli.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.passtime.passtimeappli.Dao.TownDao;
import com.passtime.passtimeappli.Model.Town;

/**
 * @author ALTR BUSINESS 1
 *
 */
public class TownService {

	@Autowired
	private TownDao townDao;

	public TownDao getTownDao() {
		return townDao;
	}

	public void setTownDao(TownDao townDao) {
		this.townDao = townDao;
	}
	
	
	public List<Town> getAll()
	{
		if(null != this.townDao.getAll())
			System.out.println(this.townDao.getAll().size());
		return this.townDao.getAll();
	}
	 
	
}
