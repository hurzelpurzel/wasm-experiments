package org.acme;

import java.io.Serializable;

public abstract class AbstractCmd implements Serializable{
    
    private final String cmd;
    private final String wasm;
    private Object [] args;
    private Object []results;

    

    public AbstractCmd( String wasm, String cmd) {
        this.cmd = cmd;
        this.wasm = wasm;
    }

    public String getCmd() {
        return cmd;
    }

    public String getWasm() {
        return wasm;
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
