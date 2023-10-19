package vivaTest;

import core.Components;
import core.LoginPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static core.TestRecordManagement.captureScreenshot;

public class PerfilTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("https://homolog.vivabr.com.br/otimiza/vistoria/perfil");
        //paginaDeLogin.autorizarHttps();
        paginaDeLogin.preencherFormularioDeLogin("detran.es","1234");
    }

    @AfterEach
    public void aftereEach(){
        captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"Perfil");
        //Components.fecharDriver();
    }

    @Test
    public void buscarVistoriaPorPeriodo(){
        Components.clicarBotao(By.id("datas"));
        Components.forceWait();
        Components.clicarBotao(By.xpath("//*[@id=\"datepickers-container\"]/div/div/div/div[2]/div[3]"));
        Components.clicarBotao(By.id("pesquisar"));

        Assert.assertTrue(Components.contemTexto(""));
    }


}
