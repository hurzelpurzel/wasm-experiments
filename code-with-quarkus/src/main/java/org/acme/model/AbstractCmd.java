package org.acme.model;

import java.io.Serializable;

public abstract class AbstractCmd implements Serializable{
    
    private final String cmd;
    
    private Object [] args;
    private Object []results;

    

    public AbstractCmd(  String cmd) {
        this.cmd = cmd;
        
    }

    public String getCmd() {
        return cmd;
    }


    public Object [] getArgs() {
        return args;
    }

    public void setArgs(Object ... args) {
        this.args = args;
    }

    public Object [] getResults() {
        return results;
    }
    public void setResults(Object [] result) {
        this.results = result;
    }
    

    


}
