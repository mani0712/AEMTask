package com.myheadache.core.listeners;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.replication.ReplicationAction;

@Component(service = EventHandler.class,
immediate = true,
property  = {EventConstants.EVENT_TOPIC + "=" + ReplicationAction.EVENT_TOPIC} 
)
public class ArticlePageEventHandler implements EventHandler {
	
	public static final Logger LOG=LoggerFactory.getLogger(ArticlePageEventHandler.class);
	
	@Override
	public void handleEvent(Event event){
		LOG.info("Event handler method");
		LOG.info(event.getTopic());
		
			}

}
