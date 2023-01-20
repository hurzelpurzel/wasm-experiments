package de.kernwestfale.camel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.apache.camel.Exchange;

import org.apache.camel.Processor;

import de.kernwestfale.cdi.CalculatorBean;
import de.kernwestfale.model.CalculatorCmd;


public class CalcProcessor implements Processor,Serializable {

    private static final Logger LOG = Logger.getLogger(CalcProcessor.class);

    
    
    public CalculatorBean calculator = CalculatorBean.build();

    @Override
    public void process(Exchange exchange) throws Exception {
        LOG.debug("process entered");

        List<List<String>> data = (List<List<String>>) exchange.getIn().getBody();
        List<List<String>> out = (List<List<String>>) new ArrayList<List<String>>();
            
        for (List<String> line : data) {
            
            CalculatorCmd cmd = CalculatorCmd.parse(line);
            
            calculator.invoke(cmd);
            out.add(cmd.toResultline());
        }
        exchange.getIn().setBody(out);
        
    }

}
