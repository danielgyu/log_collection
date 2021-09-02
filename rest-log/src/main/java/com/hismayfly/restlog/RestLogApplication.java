package com.hismayfly.restlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


// public class RestLogApplication implements CommandLineRunner {
@SpringBootApplication
public class RestLogApplication {

    @Autowired
    private ApplicationContext appContext;

    /*
    @Override
    public void run(String... args) {
	String[] beans = appContext.getBeanDefinitionNames();

	for (String bean:beans) {
	    System.out.println("bean name: " + bean);

	    Object logfileObject = appContext.getBean("logFile");
	    System.out.println("logfile object: " + logfileObject);
	}
    }
    */

    public static void main(String[] args) throws Exception {
	/*
	SpringApplication springApplication = new SpringApplication(RestLogApplication.class);
	springApplication.run(args);
	*/
	SpringApplication.run(RestLogApplication.class, args);
    }

}
