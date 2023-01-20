package de.kernwestfale.cdi;

import javax.enterprise.context.ApplicationScoped;

import de.kernwestfale.model.CalculatorCmd;

@ApplicationScoped
public class CalculatorBean extends WasmBean<CalculatorCmd>{

    public CalculatorBean() {
        super(CalculatorCmd.WASM);
        
    }

    @Override
    public void invoke(CalculatorCmd cmd) {
        
         Object[] results = instance.exports.getFunction(cmd.getCmd()).apply(cmd.getArgs());
         cmd.setResults(results);
    }
    
}
