package EvaTest;

import PageObject.LoginPage;
import PageObject.PageComponents;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PedidosDevolucaoFabricasTest {


    @BeforeEach
    public void beforeEach()  {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Feitosa", "1234");
        paginaDeLogin.efetuarLoginPedidosDevolucaoFabricas();
    }

    @AfterEach
    public void aftereEach() {
        PageComponents.fechar();
    }

    @Test
    public void tentativaDeConfimarPedidoSemAprovarReprovar(){
        PageComponents.forceWait();
        PageComponents.escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"20230626581180");
        PageComponents.clicarBotao(By.id("fcf83b4a-6890-4c6a-92e2-2baa44191388"));
        PageComponents.clicarBotao(By.cssSelector("#modalAnalise > div > div > div.modal-footer > button.btn.btn-primary"));

        Assert.assertTrue(PageComponents.isPage("http://localhost:8080/eva/devolucaoBlank/pedidosDevolucaoFabricas"));
        Assert.assertTrue(PageComponents.contemTexto("Pedidos de Devolução"));
        Assert.assertTrue(PageComponents.contemTexto("Análise do Pedido"));
        Assert.assertTrue(PageComponents.contemTexto("Para salvar o pedido é necessário aprovar ou reprovar."));
    }

    @Test
    public void tentativaDeReprovarPedidoSemEscreverJustificativa(){
        PageComponents.forceWait();
        PageComponents.escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"20230626581180");
        PageComponents.clicarBotao(By.id("fcf83b4a-6890-4c6a-92e2-2baa44191388"));
        PageComponents.forceWait();
        //inserir select
        PageComponents.selecionarCombo("selector1","Reprovado");
        PageComponents.clicarBotao(By.cssSelector("#modalAnalise > div > div > div.modal-footer > button.btn.btn-primary"));

        Assert.assertTrue(PageComponents.obterValorCombo("selector1").equals("Reprovado"));
        Assert.assertTrue(PageComponents.contemTexto("Aprovar ou reprovar:"));
        Assert.assertTrue(PageComponents.contemTexto("A justificativa é obrigatória para reprovar."));
    }

    @Ignore
    public void reprovandoPedidoDevolucao(){
        PageComponents.forceWait();
        PageComponents.escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"20230626581501");
        PageComponents.clicarBotao(By.id("eb68589c-b1e6-4abd-8683-611c98341ca8"));
        //inserir select
        PageComponents.selecionarCombo("selector1","2");
        PageComponents.obterValorCombo("selector1").equals("Reprovado");
        PageComponents.escrever(By.id("motivo"),"Reprovado teste Pedro");
        PageComponents.clicarBotao(By.cssSelector("#modalAnalise > div > div > div.modal-footer > button.btn.btn-primary"));

        Assert.assertTrue(PageComponents.verificarOpcaoCombo("selector1","Reprovado"));
    }

    @Ignore
    public void aprovandoPedidoDevolucao(){

    }
}
