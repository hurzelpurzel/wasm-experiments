package org.acme.camel;

import java.util.ArrayList;
import java.util.List;

import org.acme.model.CalculatorCmd;
import org.acme.wasm.WasmLoader;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class CalcProcessor implements Processor {

    WasmLoader loader = new WasmLoader(CalculatorCmd.WASM);

    @Override
    public void process(Exchange exchange) throws Exception {

        // TODO Auto-generated method stub
        List<List<String>> data = (List<List<String>>) exchange.getIn().getBody();
        List<List<String>> out = (List<List<String>>) new ArrayList<List<String>>();
            
        for (List<String> line : data) {
            //LOG.debug(String.format("%s has an IQ of %s and is currently %s", line.get(0), line.get(1), line.get(2)));
            CalculatorCmd cmd = CalculatorCmd.parse(line);
            List<String> outline=cmd.toResultline();
            loader.process(cmd);
            out.add(cmd.toResultline());
        }
        exchange.getIn().setBody(out);
        
    }

}
