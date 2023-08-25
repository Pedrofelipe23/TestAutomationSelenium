package vivaTest;

import core.Components;
import core.LoginPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class RelatoriosTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("es.poc","1234");
        paginaDeLogin.page("https://homolog.vivabr.com.br/solution/multiLojas/relatorioFinanceiroMulti");
    }

    @AfterEach
    public void aftereEach(){
        Components.captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"Relatorios");
        Components.fecharDriver();
    }

    @Test
    public void isPageRelatorios(){
        Components.forceWait();

        Assert.assertTrue(Components.isPage("https://homolog.vivabr.com.br/solution/multiLojas/relatorioFinanceiroMulti"));
        Assert.assertTrue(Components.contemTexto("Relatórios"));
        Assert.assertTrue(Components.contemTexto("\n" +
                "                                Filtros do Relatório\n" +
                "                            "));
    }

    @Test
    public void gerarRelatorioAtendimentos(){
        //Components.obterValorCombo("ljs");
        Components.clicarBotao(By.id("ljs"));
        Components.selecionarCombo("ljs","67c7d9p4-2a7d-4dd1-b525-56axdf2k1vb5");
        Components.forceWait();
        //Components.selecionarCombo("selector1","02 - Atendimentos");

    }

    @Ignore
    public void gerarRelatorioNFs(){

    }
}
