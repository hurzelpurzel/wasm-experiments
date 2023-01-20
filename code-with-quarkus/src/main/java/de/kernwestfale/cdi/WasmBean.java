package de.kernwestfale.cdi;

import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

import org.wasmer.Instance;

import de.kernwestfale.model.AbstractCmd;


public abstract class WasmBean<T extends AbstractCmd>{
    
    private String wasm;
    Instance instance = null;
    
    public WasmBean(String wasm) {
        this.wasm = wasm;
    }
    
    @PostConstruct
    public void postConstruct()  {

        
        try {

            InputStream instream = WasmBean.class.getClassLoader().getResourceAsStream(wasm);

            // Reads the WebAssembly module as bytes.
            byte[] wasmBytes = instream.readAllBytes();

            // Instantiates the WebAssembly module.
            instance = new Instance(wasmBytes);

           
        } catch(Exception ex){
                throw new RuntimeException(ex);
        }
    }
    
    public abstract void invoke(T cmd);

    @PreDestroy
    public void preDestroy(){
        instance.close();
    }
}
