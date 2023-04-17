package com.myheadache.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name="SchedulerTask",
description = "Simple demo for cron-job like task with properties")
public @interface SchedulerArticle {
	
	 @AttributeDefinition(name = "Scheduler Name",
     		description="Name of the Scheduler",
     		type=AttributeType.STRING)
     public String schedulerName() default "Custom Sling Scheduler";


     @AttributeDefinition(name = "Cron Expression",
     		description="Cron Exoression used by Scheduler",
     		type=AttributeType.STRING)
     public String cronExpression() default "0/5 * * * * ?";

 }
	
	
	
	


