package de.kernwestfale.camel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.camel.Exchange;

import org.apache.camel.Processor;

import de.kernwestfale.cdi.CalculatorBean;
import de.kernwestfale.model.CalculatorCmd;


public class CalcProcessor implements Processor {

    

    @Inject
    CalculatorBean calculator;

    @Override
    public void process(Exchange exchange) throws Exception {

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
