package vivaTest;

import core.Components;
import core.LoginPage;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static core.TestRecordManagement.captureScreenshot;

public class GerenciarPagamentosVistoriaTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("http://localhost:8080/eva/vistoria/gerenciarPagamentosVistoria");
        //paginaDeLogin.autorizarHttps();
        paginaDeLogin.preencherFormularioDeLogin("pedro.pereira","1234");
    }

    @AfterEach
    public void aftereEach(){
        captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"GerenciarPagamentosVistoria");
        Components.fecharDriver();
    }

    @Ignore
    public void testGerarPagamentosBoleto(){
        Components.clicarBotao(By.xpath("//*[@id=\"table\"]/tbody/tr[2]/td[8]/div/button"));
        Components.forceWait();
        Components.clicarBotao(By.xpath("//*[@id=\"202308076691123\"]"));
        Components.forceWait();
        Components.clicarBotao(By.id("bolMethod"));
        Components.forceWait();

        Assert.assertTrue(Components.contemTexto("Detalhe da compra"));
    }

    @Test
    public void testGerarPagamentoPix(){
        Components.escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"OBF6H29");
        Components.clickButtonXpath("//*[@id=\"table\"]/tbody/tr/td[8]/div/button");
        Components.clicarBotao(By.id("202308118561196"));
        Components.clicarBotao(By.id("pixMethod"));
        Components.forceWait();

        Components.clicarBotao(By.id("paymentButton"));
        Components.forceWait();

        Assert.assertTrue(Components.contemTexto("Detalhe da compra"));
        Assert.assertTrue(Components.contemTexto("Confirme todos os dados antes de gerar o pagamento"));
        Assert.assertTrue(Components.contemTexto("Forma de pagamento:"));
        Assert.assertTrue(Components.contemTexto("Pix"));

    }






}
