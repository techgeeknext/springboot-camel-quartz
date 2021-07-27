package com.techgeeknext;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCamelQuartzApplication {

	@Autowired
	private CamelContext camelContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCamelQuartzApplication.class, args);
	}

	@Bean
	public QuartzSchedulerRouteBuilder fileRouteBuilder() throws Exception {
		QuartzSchedulerRouteBuilder routeBuilder = new QuartzSchedulerRouteBuilder();
		camelContext.addRoutes(routeBuilder);
		return routeBuilder;

	}
}
