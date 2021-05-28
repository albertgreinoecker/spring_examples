package org.htl.springweb.demo.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DemoApplication.class);
        application.addListeners((ApplicationListener<ContextClosedEvent>) event -> {
        	log.info("Shutdown process initiated...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            	log.info("Exception is thrown during the ContextClosedEvent", e);
            }
            log.info("Graceful Shutdown is processed successfully");
        });
        application.run(args);
	}

}
