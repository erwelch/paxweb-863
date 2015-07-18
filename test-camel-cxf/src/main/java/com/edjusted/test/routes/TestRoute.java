package com.edjusted.test.routes;

import com.edjusted.lib.Response;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ewelch
 * @since 2015/07/06 15:53
 */
public class TestRoute extends RouteBuilder {
    private static final Logger log = LoggerFactory.getLogger(TestRoute.class);

    @Override
    public void configure() throws Exception {
        from("cxf:bean:cxfTest")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        log.info("Webservice Called");
                        Response resp = new Response();
                        resp.setTimestamp(String.valueOf(System.currentTimeMillis()));
                        exchange.getIn().setBody(resp);
                    }
                });
    }
}
