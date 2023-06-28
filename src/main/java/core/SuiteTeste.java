package core;

import evaTest.PedidosDevolucaoFabricasTest;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PedidosDevolucaoFabricasTest.class
})
public class SuiteTeste {

    @AfterClass
    public static void finalizaTudo(){
        DriverFactory.killDriver();
    }
}
