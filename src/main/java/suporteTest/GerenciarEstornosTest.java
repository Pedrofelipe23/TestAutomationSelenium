package suporteTest;

import core.Components;
import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static core.Driver.fecharDriver;
import static core.TestRecordManagement.captureScreenshot;
import static core.TestRecordManagement.deleteFileSpecifiedTarget;

public class GerenciarEstornosTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("http://hompa.eva.inf.br/solution/suporte/gerenciarEstornos");
        paginaDeLogin.preencherFormularioDeLogin("pedro","1234");
    }

    @AfterEach
    public void aftereEach(){
        captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"gerenciarEstornos");
        fecharDriver();
        deleteFileSpecifiedTarget("screenshot\\"+"gerenciarEstornos_20231009_134755.jpg");
    }

    @Test
    public void isPageGerenciarEstornosTrue (){
        Assert.assertTrue(Components.isPage("http://hompa.eva.inf.br/solution/suporte/gerenciarEstornos"));
    }

    @Test
    public void filtrandoEstornoComPlaca(){
        Components.escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"OPL5J90");
    }

    @Test
    public void verificandoComprovantePagamento(){
        Components.clicarBotao(By.xpath("//*[@id=\"table\"]/tbody/tr/td[6]/div/c-button[2]"));
        Components.forceWait();

        Assert.assertTrue(Components.contemTexto("Esta solicitação não possui "));
        Assert.assertTrue(Components.contemTexto(" comprovante de pagamento anexado."));
    }

    @Test
    public void tentativaDeAprovarEstornoSemAnexoJustificativa(){
        Components.clicarBotao(By.xpath("//*[@id=\"#approve_8448dc20-63ac-11ee-a329-0256a74c8350\"]"));
        Components.clicarBotao(By.xpath("//*[@id=\"modal_8448dc20-63ac-11ee-a329-0256a74c8350\"]/div/div/footer/c-button[2]"));

        Assert.assertTrue(Components.contemTexto("Necessário inserir comprovante!"));
        Assert.assertTrue(Components.contemTexto("\n" +
                "                        Resposta à Solicitação\n" +
                "                    "));
    }

    @Test
    public void tentativaDeReprovarEstornoSemJustificativa(){
        Components.clicarBotao(By.xpath("//*[@id=\"#approve_8448dc20-63ac-11ee-a329-0256a74c8350\"]"));
        Components.clicarBotao(By.xpath("//*[@id=\"modal_8448dc20-63ac-11ee-a329-0256a74c8350\"]/div/div/footer/c-button[1]"));

        Assert.assertTrue(Components.contemTexto("Necessário preencher justificativa!"));
    }

}
