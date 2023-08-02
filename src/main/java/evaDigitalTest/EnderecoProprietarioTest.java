package evaDigitalTest;

import core.Components;
import core.LoginPage;
import core.TestRecordManagement;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class EnderecoProprietarioTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Pedro.pereira","1234");
        paginaDeLogin.page("http://localhost:8080/eva/primeiroEmplacamentoDigital/enderecoProprietario");
    }

    @AfterEach
    public void aftereEach(){
        Components.captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"EnderecoProprietario");
        Components.fecharDriver();
    }

    @Test
    public void tentativaDeConsultarMunicipioInvalido(){
        Components.clicarBotao(By.id("btn-search"));

        Assert.assertTrue(Components.contemTexto("Primeiro Emplacamento Digital"));
        Assert.assertTrue(Components.contemTexto("Município de emplacamento é obrigatório"));
        Assert.assertTrue(Components.contemTexto("2AB1Z7AARR23S3790"));
        Assert.assertTrue(Components.contemTexto("024.197.226-84"));
    }

    @Ignore
    public void selecionandoMunicipioValido(){
        Components.selecionarCombo("search-address","1");

    }
}
