package de.kernwestfale.camel;


import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;



/**
 * A Camel Java DSL Router
 */

public class MyRouteBuilder extends RouteBuilder {

    
    CalcProcessor proc = new CalcProcessor();
    


    private String getInDir(){
        return System.getProperty("user.home")+"/camel/in/";
    }
    private String getOutDir(){
        return System.getProperty("user.home")+"/camel/out/";
    }
    

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
       
        from("timer://mytime?fixedRate=true&period=60000")
            .pollEnrich("file:"+getInDir()+"?include=.*.csv")
            .unmarshal().csv()
            .process(this.proc)
            .marshal()
            .csv()
            .to("file:"+getOutDir());

            
    }

}   

