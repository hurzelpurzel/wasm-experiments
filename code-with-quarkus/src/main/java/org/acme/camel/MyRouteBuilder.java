package org.acme.camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    CalcProcessor proc = new CalcProcessor();

   

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
       
        from("direct:myroute")
            .pollEnrich("file:src/test/resources/?fileName=input.csv&noop=true")
            .unmarshal().csv()
            .process(proc)
            .marshal()
            .csv()
            .to("file:target/?fileName=out.csv");

            
    }

}   

