package vivaTest;

import core.Components;
import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static core.TestRecordManagement.captureScreenshot;

public class UploadArquivosECVTest {


    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("https://homolog.vivabr.com.br/solution/vistoria/uploadArquivosECV");
        paginaDeLogin.preencherFormularioDeLogin("es.poc", "1234");
    }

    @AfterEach
    public void aftereEach(){
        captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"UploadArquivosECV");
        Components.fecharDriver();
    }

    @Test
    public void visualizarDadosNaTela(){
        Components.isPage("https://homolog.vivabr.com.br/solution/vistoria/uploadArquivosECV");
        Components.forceWait();
        Components.clicarBotao(By.xpath("//*[@id=\"table\"]/tbody/tr/td[3]/span/i"));
        Components.forceWait();
        Components.clicarBotao(By.xpath("//*[@id=\"modalDocsBody\"]/button[6]"));

        Assert.assertTrue(Components.contemTexto("Arquivos ECV\n" +
                "                "));
        Assert.assertTrue(Components.contemTexto("ES POC VISTORIAS LTDA"));
        Assert.assertTrue(Components.contemTexto("05.776.666/0001-50"));
        Assert.assertTrue(Components.contemTexto("Clique para baixar"));
    }

    @Test
    public void efetuarUploadComFileInvalido(){
        Components.clicarBotao(By.id("btn"));
        Components.forceWait();
        Components.anexaFile("doc_contratoSocial","C:\\Users\\Pedro\\OneDrive\\Área de Trabalho\\PlanejamentoDeTeste.txt");
        Components.forceWait();

        Assert.assertTrue(Components.contemTexto("Necessário inserir arquivo tipo PDF."));
    }

    @Test
    public void AnexarFilePDFValido(){
        Components.clicarBotao(By.id("btn"));
        Components.forceWait();
        Components.selecionarCombo("novoValor","contratoSocial");
        Components.anexaFile("doc_contratoSocial","C:\\Users\\Pedro\\OneDrive\\Área de Trabalho\\contratoSocial.pdf");
        Components.clicarBotao(By.id("novoValorBot"));
        Components.forceWait();

        Assert.assertTrue(Components.contemTexto("PDF salvo com sucesso."));
    }

}
