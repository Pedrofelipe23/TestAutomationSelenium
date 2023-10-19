package vivaTest;

import core.Components;
import core.LoginPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static core.TestRecordManagement.captureScreenshot;

public class MesaVistoriadorNewTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("https://homolog.vivabr.com.br/otimiza/vistoria/mesaVistoriadorNew");
        //paginaDeLogin.autorizarHttps();
        paginaDeLogin.preencherFormularioDeLogin("es.poc","1234");
    }

    @AfterEach
    public void aftereEach(){
        captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"Perfil");
        Components.fecharDriver();
    }

    @Test
    public void isPageMesaVistoriador(){
        Components.isPage("https://homolog.vivabr.com.br/otimiza/vistoria/mesaVistoriadorNew");

        Assert.assertTrue(Components.isPage("https://homolog.vivabr.com.br/otimiza/vistoria/mesaVistoriadorNew"));
    }

    @Ignore
    public void selecionarVistoriaGerarLaudo(){

    }

}
