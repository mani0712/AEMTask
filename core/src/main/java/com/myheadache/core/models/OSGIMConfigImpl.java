package com.myheadache.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = SlingHttpServletRequest.class, adapters =OSGIMconfig.class )
public class OSGIMConfigImpl implements OSGIMconfig {
	
	@OSGiService
	OSGIconfig osgiConfig;

	@Override
	public String getServiceName() {
		// TODO Auto-generated method stub
		return osgiConfig.getServiceName();
	}

	@Override
	public int getServiceCount() {
		// TODO Auto-generated method stub
		return osgiConfig.getServiceCount();
	}

	@Override
	public boolean isLiveData() {
		// TODO Auto-generated method stub
		return osgiConfig.isLiveData();
	}

	@Override
	public String[] getCountries() {
		// TODO Auto-generated method stub
		return osgiConfig.getCountries();
	}

	@Override
	public String getRunModes() {
		// TODO Auto-generated method stub
		return osgiConfig.getRunModes();
	}

}
