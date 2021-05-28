package org.htl.springweb.demo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DemoApplication.class);
        application.addListeners((ApplicationListener<ContextClosedEvent>) event -> {
            System.out.println("Shutdown process initiated...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            	System.out.println("Exception is thrown during the ContextClosedEvent" + e);
            }
            System.out.println("Graceful Shutdown is processed successfully");
        });
        application.run(args);
	}

}
