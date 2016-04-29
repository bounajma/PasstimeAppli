/**
 * 
 */
package com.passtime.passtimeappli.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.passtime.passtimeappli.Model.Town;
import com.passtime.passtimeappli.Service.TownService;

/**
 * @author ALTR BUSINESS 1
 *
 */

@Controller
@RequestMapping("/town")
public class TownController {

	@Autowired
	private TownService townService;

	public TownService getTownService() {
		return townService;
	}

	public void setTownService(TownService townService) {
		this.townService = townService;
	}
	
	@ResponseBody
	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	public List<Town> getAll()
	{
		try{
			return this.townService.getAll();
		}catch(Exception e) {
			// TODO: handle exception
			return null;
	   }
			
		
	}
	
}
