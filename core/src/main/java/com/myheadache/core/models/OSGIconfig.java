package com.myheadache.core.models;

public interface OSGIconfig {
	public String getServiceName();
	public int getServiceCount();
	public boolean isLiveData();
	public String[] getCountries();
	public String getRunModes();

}
