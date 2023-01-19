package org.acme;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.wasmer.*;

public class WasmLoader {


    private static void process(AbstractCmd cmd)throws IOException{
        
        Instance instance = null;
        try{


        
        InputStream instream =WasmLoader.class.getClassLoader().getResourceAsStream("calculator.wasm");

        // Reads the WebAssembly module as bytes.
        byte[] wasmBytes =  instream.readAllBytes();
        
        // Instantiates the WebAssembly module.
         instance = new Instance(wasmBytes);

        // Calls an exported function, and returns an object array.
        Object[] results = instance.exports.getFunction(cmd.getCmd()).apply(cmd.getArgs());
        cmd.setResults(results);
        }finally{
           // Drops an instance object pointer which is stored in Rust.
           instance.close();
        }
    }

    public static void main(String[] args) throws IOException {
        
        AddCmd cmd = new AddCmd();
        cmd.setArgs(35,7);
        WasmLoader.process(cmd);
        
        System.out.println((Integer) cmd.getResults()[0]); // 42

        
    }
}
