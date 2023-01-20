package de.kernwestfale.model;

import java.io.Serializable;

public abstract class AbstractCmd implements Serializable {

    private final String cmd;

    private String[] args;
    

    private Object[] results;

    public AbstractCmd(String cmd) {
        this.cmd = cmd;

    }

    public String getCmd() {
        return cmd;
    }

    
    public String[] getArgs() {
        return args;
    }
    public Object [] getIntArgs() {
        
        return convert(args);
    }

    public void setArgs(String... args) {
        this.args = args;
    }

    public Object[] getResults() {
        return results;
    }

    public void setResults(Object[] result) {
        this.results = result;
    }

    public static Integer[] convert(String[] objectArray) {
        Integer[] intArray = new Integer[objectArray.length];

        for (int i = 0; i < objectArray.length; i++) {
            intArray[i] = Integer.valueOf( objectArray[i]);
        }

        return intArray;
    }

}
