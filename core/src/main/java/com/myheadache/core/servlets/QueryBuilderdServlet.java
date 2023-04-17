package com.myheadache.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Session;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.collections.map.HashedMap;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;





@Component(service =  Servlet.class , immediate=true)
@SlingServletResourceTypes(
        resourceTypes= {"myproject/components/page"},
        methods= {"GET"},
        extensions= {"json","txt","html"},
        selectors="recent"
        )
 
public class QueryBuilderdServlet extends SlingAllMethodsServlet{
	
	@Reference
	QueryBuilder querybld;
	  protected void doGet(SlingHttpServletRequest request,
	             SlingHttpServletResponse response) throws ServletException, IOException {
		  
		 Map<String, String> predicate=new HashMap<String, String>();
		 predicate.put("type", "cq:page");
		predicate.put("path","/content/myheadache");
				predicate.put("fulltext","myheadache");
				predicate.put("orderby","@jcr:content/cq:lastModified");
				predicate.put("orderby.sort","desc");
				predicate.put ("p.limit","-1");
				Query query=querybld.createQuery(PredicateGroup.create(predicate),request.getResourceResolver().adaptTo(Session.class));
		       SearchResult result= query.getResult();
		     
		        List<Hit> hits=result.getHits();
		        JsonArrayBuilder json=Json.createArrayBuilder();
		        for(Hit hit:hits)
		        {
		        	try {
		        		JsonObjectBuilder job=Json.createObjectBuilder();
		        		Resource resource=hit.getResource();
		        		Resource content=request.getResourceResolver().getResource(resource.getPath()+"jcr:content");
		        		job.add("title",content.getValueMap().get("jcr:title",String.class));
		        		job.add("path",resource.getPath());
		        		json.add(job);
		        	}
		        	catch(Exception e)
		        	{
		        		e.printStackTrace();
		        	}
		        	response.getWriter().write(json.build().toString());
		        }

}
}
