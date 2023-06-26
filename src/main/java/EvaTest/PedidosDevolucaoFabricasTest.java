package EvaTest;

import PageObject.LoginPage;
import PageObject.PageComponents;
import org.junit.Assert;
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
    public void TentativaDeConfimarPedidoSemAprovarReprovar(){
        PageComponents.contemTexto("Pedidos de Devolução a Aprovar");
        PageComponents.escrever(By.id("table_filter"),"20230623581936");
        PageComponents.clickButtonXpath("//*[@id=\"97c52ded-0a79-40b5-9768-833532640b31\"]");
        PageComponents.clickButtonXpath("/html/body/div[4]/div/div[10]/button[1]");

        Assert.assertTrue(PageComponents.isPage("http://localhost:8080/eva/devolucaoBlank/pedidosDevolucaoFabricas"));
        Assert.assertTrue(PageComponents.contemTexto("Análise do Pedido"));
        Assert.assertTrue(PageComponents.contemTexto("Para salvar o pedido é necessário aprovar ou reprovar."));

    }
}
