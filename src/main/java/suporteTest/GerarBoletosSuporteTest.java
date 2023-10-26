package suporteTest;

import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static core.Components.*;
import static core.Driver.fecharDriver;
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

    @Disabled
    public void consultarPlaca(){
        escrever(By.id("placa"),"NOQ4J88");
        clicarBotao(By.id("pesquisaPlaca"));
        forceWait();
        clicarBotao(By.xpath("/html/body/div[3]/div/div[10]/button[1]"));
        forceWait();
        clicarBotao(By.xpath("/html/body/div[3]/div/div[10]/button[1]"));

        Assert.assertTrue(contemTexto("Boleto desvinculado com sucesso."));
        Assert.assertTrue(contemTexto("A placa pesquisada já possui um boleto associado e não pago, deseja desvinculá-lo e continuar?"));
        Assert.assertEquals(obterValorCampo("nome"),"ALISON HENRIQUE BATISTA");
        Assert.assertEquals(obterValorCampo("loja"),"ORIGINAL PLACAS EIRELI");
        Assert.assertEquals(obterValorCampo("valor"),"R$ 200,00");
    }

    @Test
    public void consultarPlacaSemBoleto(){
        escrever(By.id("placa"),"QBL1A28");
        clicarBotao(By.id("pesquisaPlaca"));
        forceWait();

        Assert.assertEquals(obterValorCampo("nome"),"JOSE ARTHUR FERNANDES COUTINHO");
        Assert.assertEquals(obterValorCampo("loja"),"VISTORIA VEICULAR VILA VELHA LTDA");
        Assert.assertEquals(obterValorCampo("valor"),"R$ 124,59");
    }

    @Test
    public void tentativaDeConsultaSemPassarPlaca(){
        escrever(By.id("placa"),"");
        clicarBotao(By.id("pesquisaPlaca"));
        forceWait();

        Assert.assertTrue(contemTexto("Por favor, insira uma placa para prosseguir!."));
    }

    @Test
    public void consultarPlacaComBoletoPago(){
        escrever(By.id("placa"),"LDV4H70");
        clicarBotao(By.id("pesquisaPlaca"));
        forceWait();

        Assert.assertTrue(contemTexto("A placa pesquisada já possui um boleto "));
        Assert.assertTrue(contemTexto(" associado e consta como PAGO. "));
        Assert.assertTrue(contemTexto(" Por favor, busque por outra placa."));
    }

    @Disabled
    public void TentativacriarBoletoComCamposVazios(){
        escrever(By.id("placa"),"QBL1A28");
        clicarBotao(By.xpath("/html/body/div[2]/main/div/main/div/button/span"));
        clicarBotao(By.xpath("/html/body/div[2]/main/div/main/div/button/span"));
        selecionarCombo("status","Pago");
        forceWait();

        Assert.assertEquals(obterValorCombo("status"),"Pago");
    }

}
