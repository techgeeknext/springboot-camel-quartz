package com.techgeeknext;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class QuartzSchedulerRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //CASE1 - Move files from one folder other

		/*from("file:D://techgeeknext-camel-1?recursive=true&noop=true&scheduler=quartz2&scheduler.cron=0 0/1 * 1/1 * ? *")
                .process(new Processor() {

			public void process(Exchange exchange) throws Exception {
				System.out.println("moving " + exchange.getIn().getBody());
			}
		}).to("file:D://techgeeknext-camel-2");
*/


        //CASE2 - Print output at console
        //repeatCount: How many times should the timer repeat?
        //repeatInterval: The amount of time in milliseconds between repeated triggers.
        from("quartz2://currentTimer?trigger.repeatInterval=1000&trigger.repeatCount=5")
                .setBody().simple("TechGeekNext Quartz Example 1")
                .to("stream:out");


        //CASE3 - Print output at console on every 20 minutes
		/*from("quartz2://Custom?cron=0/20+*+*+?+*+*")
				.setBody().simple("TechGeekNext Quartz Example 3")
				.to("stream:out");*/

    }
}
