package suporteTest;

import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static core.Components.*;
import static core.PageObject.fecharDriver;
import static core.TestRecordManagement.captureScreenshot;

public class GerarBoletosSuporteTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("http://localhost:8080/eva/suporte/gerarBoletos");
        paginaDeLogin.preencherFormularioDeLogin("davi.santos","1234");
        paginaDeLogin.efetuaLogin();
    }

    @AfterEach
    public void aftereEach(){
        captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"GerarBoletosSuporte");
        fecharDriver();
    }

    @Test
    public void isPageGerarBoletos(){
        isPage("http://localhost:8080/eva/suporte/gerarBoletos");

        Assert.assertTrue(contemTexto("Novo Boleto\n" +
                "                "));
    }

    @Test
    public void consultarPlaca(){
        escrever(By.id("placa"),"QBL1A28");
        clicarBotao(By.xpath("/html/body/div[2]/main/div/main/div/button"));

        Assert.assertEquals(obterValorCampo("nome"),"JOSE ARTHUR FERNANDES COUTINHO");
        Assert.assertEquals(obterValorCampo("loja"),"VISTORIA VEICULAR VILA VELHA LTDA");
        Assert.assertEquals(obterValorCampo("valor"),"R$ 124,59");
    }

    @Test
    public void TentativacriarBoletoComCamposVazios(){
        escrever(By.id("placa"),"QBL1A28");
        clicarBotao(By.xpath("/html/body/div[2]/main/div/main/div/button/span"));
        clicarBotao(By.xpath("/html/body/div[2]/main/div/main/div/button/span"));
        selecionarCombo("status","Pago");
        forceWait();

        Assert.assertEquals(obterValorCombo("status"),"Pago");
    }

}
