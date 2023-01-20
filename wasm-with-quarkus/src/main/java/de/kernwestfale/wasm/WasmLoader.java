package de.kernwestfale.wasm;

import java.io.IOException;
import java.io.InputStream;

import javax.enterprise.context.ApplicationScoped;

import org.wasmer.*;

import de.kernwestfale.model.AbstractCmd;


public class WasmLoader {

    private String wasm;

    public WasmLoader(String wasm) {
        this.wasm = wasm;
    }

    
    public void process(AbstractCmd cmd) throws IOException {

        Instance instance = null;
        try {

            InputStream instream = WasmLoader.class.getClassLoader().getResourceAsStream(wasm);

            // Reads the WebAssembly module as bytes.
            byte[] wasmBytes = instream.readAllBytes();

            // Instantiates the WebAssembly module.
            instance = new Instance(wasmBytes);

            // Calls an exported function, and returns an object array.
            Object[] results = instance.exports.getFunction(cmd.getCmd()).apply(cmd.getArgs());
            cmd.setResults(results);
        } finally {
            // Drops an instance object pointer which is stored in Rust.
            instance.close();
        }
    }

    
}
