package com.myheadache.core.schedulers;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.myheadache.core.schedulers.SchedulerArticle;


@Designate(ocd=SchedulerArticle.class)
@Component(service=Runnable.class,immediate = true)
public class ArticleExpiryScheduler implements Runnable {
    
    protected final Logger logger = LoggerFactory.getLogger(ArticleExpiryScheduler.class);

    @Override
    public void run() {
        
    }

    @Activate
    protected void activate(SchedulerArticle config) {
    	
    	config.cronExpression();
       
    }

}
