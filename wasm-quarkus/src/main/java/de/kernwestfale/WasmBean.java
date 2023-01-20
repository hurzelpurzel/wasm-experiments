package de.kernwestfale;



import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

import org.wasmer.Instance;


@ApplicationScoped
public  class WasmBean implements Serializable{
    
    public static String WASM = "calculator.wasm";
  
    Instance instance = null;
    
    
    public WasmBean() {
       
    }

    @PreDestroy
    void preDestroy(){
       instance.close();
   }
    
    @PostConstruct
    void postConstruct()  {

        
        try {

            InputStream instream = WasmBean.class.getClassLoader().getResourceAsStream(WASM);

            // Reads the WebAssembly module as bytes.
            byte[] wasmBytes = instream.readAllBytes();

            // Instantiates the WebAssembly module.
            instance = new Instance(wasmBytes);

           
        } catch(Exception ex){
                throw new RuntimeException(ex);
        }
    }

    public Object[] invoke(String function, Object ... args) {

        return instance.exports.getFunction(function).apply(args);
        
    }


   
}
