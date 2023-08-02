package vivaTest;

import core.Components;
import core.LoginPage;
import vivaPage.GerenciarPagamentosVistoriaPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GerenciarPagamentosVistoriaTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("es.poc","1234");
        paginaDeLogin.page("http://localhost:8080/eva/vistoria/gerenciarPagamentosVistoria");
    }

    @AfterEach
    public void aftereEach(){
        Components.captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"GerenciarPagamentosVistoria");
        Components.fecharDriver();
    }


}
