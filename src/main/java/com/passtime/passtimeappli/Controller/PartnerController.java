package com.passtime.passtimeappli.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.passtime.passtimeappli.Model.Partner;
import com.passtime.passtimeappli.Service.PartnerService;

@Controller
@RequestMapping("/partner")
public class PartnerController {
	@Autowired
	private PartnerService partnerService;

	public PartnerService getPartnerService() {
		return partnerService;
	}

	public void setPartnerService(PartnerService partnerService) {
		this.partnerService = partnerService;
	}
	@ResponseBody
	@RequestMapping("/all")
	public Map<String,List<Partner>> getAll()
	{
		if(null != this.partnerService.getAll()) 
			{
				Map<String,List<Partner>> mymap = new HashMap<String,List<Partner>>();
				mymap.put("partenaires", this.partnerService.getAll());
				return mymap;
			}
		else
		{
			System.out.println("liste vide");
			return null;
		}
			
	}
	@ResponseBody
	@RequestMapping("/first")
	public Map<String,Partner> getFirst()
	{
		HashMap<String,Partner> mymap = new HashMap<String,Partner>();
		mymap.put("partner", this.partnerService.getFirst());
		return mymap;
			
	}
}
