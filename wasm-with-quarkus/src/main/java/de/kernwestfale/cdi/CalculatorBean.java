package de.kernwestfale.cdi;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

import de.kernwestfale.model.CalculatorCmd;

public class CalculatorBean extends WasmBean<CalculatorCmd> implements Serializable {

    private static CalculatorBean singleton = null;

    public static CalculatorBean build() {

        if (singleton == null) {
            singleton = new CalculatorBean();
        }
        return singleton;
    }

    private CalculatorBean() {
        super(CalculatorCmd.WASM);
        super.postConstruct();

    }

    @Override
    public void invoke(CalculatorCmd cmd) {

        Object[] results = instance.exports.getFunction(cmd.getCmd()).apply(cmd.getIntArgs());
        cmd.setResults(results);
    }

    protected void finalize() throws Throwable {
        super.preDestroy();
    }

}
