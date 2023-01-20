package de.kernwestfale.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorCmd extends AbstractCmd{

    public static String WASM = "calculator.wasm";

    public CalculatorCmd( String cmd) {
        super( cmd);
        
    }

    public List<String> toResultline(){
        List<String> data = new ArrayList<String>();
        data.add(0, this.getCmd());
        data.add(1, String.valueOf(this.getArgs()[0]));
        data.add(2, String.valueOf(this.getArgs()[1]));
        data.add(3, String.valueOf(this.getResults()[0]));
        return data;
    }
    
    public static CalculatorCmd parse(List<String> line){
        CalculatorCmd res = new CalculatorCmd(line.get(0));
        res.setArgs(line.get(1),line.get(2));
        return res;
    }
}
