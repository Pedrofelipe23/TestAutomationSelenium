package core;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import vivaTest.AtualizarEnderecoEntregaTest;
import vivaTest.GerenciarPagamentosVistoriaTest;
import vivaTest.MinhasVistoriasTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GerenciarPagamentosVistoriaTest.class, MinhasVistoriasTest.class, AtualizarEnderecoEntregaTest.class
})
public class TestSuite {

    @BeforeClass
    public static void beforeClass(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("es.poc","1234");
    }
    @AfterClass
    public static void aftereClass(){
        Components.fecharDriver();
    }

}
