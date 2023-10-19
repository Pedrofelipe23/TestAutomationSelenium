package evaTest;

import core.LoginPage;
import core.Components;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static core.TestRecordManagement.captureScreenshot;

public class PedidosDevolucaoFabricasTest {

    @BeforeEach
    public void beforeEach()  {
        LoginPage paginaDeLogin = new LoginPage("http://localhost:8080/eva/devolucaoBlank/pedidosDevolucaoFabricas");
        paginaDeLogin.preencherFormularioDeLogin("Feitosa", "1234");
    }

    @AfterEach
    public void aftereEach() {
        captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"PedidosDevolucaoFabricas");
        Components.fecharDriver();
    }

    @Test
    public void tentativaDeConfimarPedidoSemAprovarReprovar(){
        Components.forceWait();
        Components.escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"20230626581180");
        Components.clicarBotao(By.id("fcf83b4a-6890-4c6a-92e2-2baa44191388"));
        Components.clicarBotao(By.cssSelector("#modalAnalise > div > div > div.modal-footer > button.btn.btn-primary"));

        Assert.assertTrue(Components.isPage("http://localhost:8080/eva/devolucaoBlank/pedidosDevolucaoFabricas"));
        Assert.assertTrue(Components.contemTexto("Pedidos de Devolução"));
        Assert.assertTrue(Components.contemTexto("Análise do Pedido"));
        Assert.assertTrue(Components.contemTexto("Para salvar o pedido é necessário aprovar ou reprovar."));
    }

    @Test
    public void tentativaDeReprovarPedidoSemEscreverJustificativa(){
        Components.forceWait();
        Components.escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"20230626581180");
        Components.clicarBotao(By.id("fcf83b4a-6890-4c6a-92e2-2baa44191388"));
        Components.forceWait();
        Components.selecionarCombo("selector1","Reprovado");
        Components.clicarBotao(By.cssSelector("#modalAnalise > div > div > div.modal-footer > button.btn.btn-primary"));

        Assert.assertTrue(Components.obterValorCombo("selector1").equals("Reprovado"));
        Assert.assertTrue(Components.contemTexto("Aprovar ou reprovar:"));
        Assert.assertTrue(Components.contemTexto("A justificativa é obrigatória para reprovar."));
    }

    @Ignore
    public void reprovandoPedidoDevolucao(){
        Components.forceWait();
        Components.escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"20230626581501");
        Components.clicarBotao(By.id("eb68589c-b1e6-4abd-8683-611c98341ca8"));
        //inserir select
        Components.selecionarCombo("selector1","2");
        Components.obterValorCombo("selector1").equals("Reprovado");
        Components.escrever(By.id("motivo"),"Reprovado teste Pedro");
        Components.clicarBotao(By.cssSelector("#modalAnalise > div > div > div.modal-footer > button.btn.btn-primary"));

        Assert.assertTrue(Components.verificarOpcaoCombo("selector1","Reprovado"));
    }

    @Ignore
    public void aprovandoPedidoDevolucao(){

    }
}
