package vivaTest;

import core.Components;
import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AtualizarEnderecoEntregaTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        //paginaDeLogin.autorizarHttps();
        paginaDeLogin.preencherFormularioDeLogin("es.poc","1234");
        paginaDeLogin.page("https://homolog.vivabr.com.br/solution/agendamento/atualizarLocalizacaoEntrega");

    }

    @AfterEach
    public void aftereEach(){
        Components.captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"AtualizarEnderecoEntrega");
        Components.fecharDriver();
    }

    @Test
    public void pesquisandoAtendimento(){
        Components.escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"PXZ9H35");

        Assert.assertTrue(Components.contemTexto("Atualizar coordenadas"));
    }

    @Test
    public void alterarLocalizacaoInvalidaParaGeoLocalizacao(){
        Components.clicarBotao(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[6]/span"));
        Components.escrever(By.id("location"),"22783113");

        Components.clicarBotao(By.xpath("//*[@id=\"formHidden\"]/div[1]/input[2]"));
        Components.forceWait();
        Components.clicarBotao(By.xpath("//*[@id=\"modalMap\"]/div/div/div[2]/button"));
        Components.forceWait();

        Assert.assertTrue(Components.contemTexto("Editar local de entrega"));
        Assert.assertTrue(Components.contemTexto("-22.985011"));
        Assert.assertTrue(Components.contemTexto("-43.4277561"));
        Assert.assertTrue(Components.contemTexto("O endereço informado não faz parte da região autorizada para seus atendimentos."));
    }

    @Test
    public void alterarLocalizacaoComCepValido(){
        Components.clicarBotao(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[6]/span"));
        Components.escrever(By.id("location"),"29015040");
        Components.clicarBotao(By.xpath("//*[@id=\"formHidden\"]/div[1]/input[2]"));
        Components.forceWait();
        Components.clicarBotao(By.xpath("//*[@id=\"modalMap\"]/div/div/div[2]/button"));
        Components.forceWait();

        Assert.assertTrue(Components.contemTexto("Editar local de entrega"));
        Assert.assertTrue(Components.contemTexto("-20.3200842"));
        Assert.assertTrue(Components.contemTexto("-40.3421163"));
        Assert.assertTrue(Components.contemTexto("Localização atualizada com sucesso!"));
    }









}
