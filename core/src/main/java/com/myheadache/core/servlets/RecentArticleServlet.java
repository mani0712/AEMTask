package com.myheadache.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

//import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
//import org.apache.sling.api.resource.ModifiableValueMap;
//import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
//import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;

import org.osgi.service.component.annotations.Component;

//import com.adobe.xfa.ut.Resolver;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;


	@Component(service =  Servlet.class , immediate=true)
	@SlingServletResourceTypes(
	        resourceTypes= {"myproject/components/page"},
	        methods= {"GET"},
	        extensions= {"json","txt","html"},
	        selectors="recent"
	        )
	//@SlingServletPaths("/bin/myproject/services/recent-article")
	public class RecentArticleServlet  extends SlingAllMethodsServlet {

	    //private static final long serialVersionUID = 1L;

	    @Override
	    protected void doGet(SlingHttpServletRequest request,
	             SlingHttpServletResponse response) throws ServletException, IOException {
	    	/*ResourceResolver res= request.getResourceResolver();
	         Resource resource = res.getResource("/content/myproject/jcr:content");
            
            Map<String,Object> mp=new HashMap<>();
            
             mp.put("type","gfjhh");
             res.create(resource,"test", mp);

	         JsonObjectBuilder json=Json.createObjectBuilder();
	         if(resource!=null) {
	        ValueMap vm=resource.getValueMap();
	          String title=(String) vm.get("jcr:title");
	        // String Desc=vm.get("jcr:description",String.class);
	         String restyp=vm.get("sling:resourceType", "myproject/components/page");
	         json.add("title",title);
	        // json.add("description", Desc);
	         json.add("resourceType",restyp);

             ModifiableValueMap mprop = resource.adaptTo(ModifiableValueMap.class);
             mprop.put("jcr:title","myproject my headache");
             mprop.put("category", "sports");
             mprop.remove("jcr:description");
             res.commit();
	         }
	          response.setContentType("application/json");
	         response.getWriter().write(json.build().toString());
			}
			 catch (Exception e) {
				
			}*/
	    	//response.getWriter().write("Response from path based servlet - do get method");
            
            try{
            ResourceResolver res = request.getResourceResolver();
            
                PageManager pgmr= res.adaptTo(PageManager.class);
                try{
                pgmr.create("/content/myproject/us/en",
                "apple-phone","/conf/myproject/settings/wcm/templates/page-content","apple");
                }
                
                
                catch(Exception e)
                {
                    e.printStackTrace();
                }

               // pgmr.de
                Page pg=pgmr.getPage("/content/myproject/us/en");
               JsonArrayBuilder jarr=Json.createArrayBuilder();
             Iterator<Page> cp= pg.listChildren();
              while(cp.hasNext()) {
                JsonObjectBuilder json=Json.createObjectBuilder();
                  Page p=(Page) cp.next();
                  json.add("pageTitle",p.getTitle());
                  json.add("path",p.getPath());
                  jarr.add(json);
                
              }
              response.setContentType("application/json");
              response.getWriter().write(jarr.build().toString());

            } catch(Exception e) {

            }
        

        


	    }
	    @Override
	    protected void doPost(SlingHttpServletRequest request,  SlingHttpServletResponse response)
	    		throws ServletException, IOException {
	    	response.getWriter().write("Response from path based servlet - do get method");

	    	
	    }
	}



