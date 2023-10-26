package suporteTest;

import core.Components;
import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static core.Components.contemTexto;
import static core.Components.isPage;
import static core.PageObject.fecharDriver;
import static core.TestRecordManagement.captureScreenshot;
import static core.TestRecordManagement.deleteFileSpecifiedTarget;

public class ConsultarEstornosTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("http://localhost:8080/eva/suporte/consultarEstornos");
        paginaDeLogin.preencherFormularioDeLogin("davi.santos","1234");
        paginaDeLogin.efetuaLogin();
    }

    @AfterEach
    public void aftereEach(){
        captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"consultarEstornos");
        fecharDriver();
    }

    @Test
    public void isPageConsultarEstornos(){
        isPage("http://localhost:8080/eva/suporte/consultarEstornos");

        Assert.assertTrue(isPage("http://localhost:8080/eva/suporte/consultarEstornos"));
        Assert.assertTrue(contemTexto("Consultar Estornos "));
    }

}
