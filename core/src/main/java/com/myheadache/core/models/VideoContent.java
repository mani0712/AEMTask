package com.myheadache.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.wcm.core.components.models.Page;

@Model(adaptables = { Resource.class,SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class VideoContent implements Video{
	
@ValueMapValue	
private String text;

@ValueMapValue	
private String externalLink;

@ValueMapValue	
private String play;

@ValueMapValue	
private String pause;

@ValueMapValue(name="sling:resourceType",injectionStrategy = InjectionStrategy.REQUIRED)
@Default(values="myheadache/components/video")
private String slingResourceType;

@ScriptVariable
ValueMap vm;

@SlingObject
ResourceResolver resolver;

String pageTitle;

public void init()
{
	Page page = resolver.adaptTo(Page.class);
	pageTitle = page.getTitle();
	//=vm.get("jcr:title",String.class);
}
	
	@Override
	public String getExternalLink() {
		return externalLink;
		
		
	}
	public String getpageTitle()
	{
		return pageTitle;
	}

	@Override
	public String getText() {
	 return text;
		
	}

	@Override
	public String getPlay() {
		return play;
		
	}

	@Override
	public String getPause() {
		return pause;
		
	}

	@Override
	public String getSlingResourceType() {
		return slingResourceType;
		
	}

}
