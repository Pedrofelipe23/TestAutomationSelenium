package evaTest;

import evaPage.AtualizarNomeCpfPrepostoPage;
import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AtualizarNomeCpfPrepostoTest {

    private AtualizarNomeCpfPrepostoPage atualizarPreposto;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Pedro.pereira","1234");
        this.atualizarPreposto = paginaDeLogin.efetuaLoginAtualizarNomeCpfPreposto();
        this.atualizarPreposto = atualizarPreposto.carregarFormulario();
    }

    @AfterEach
    public void aftereEach(){
        this.atualizarPreposto.fechar();
    }

    @Test
    public void consultandoPlacaInvalida(){
        atualizarPreposto.escrever(By.id("busca"),"RPI2I84");
        atualizarPreposto.clickButtonXpath("//*[@id=\"div\"]/div[1]/button");

        Assert.assertTrue(atualizarPreposto.isPageAtualizarNomeCpfPreposto());
        Assert.assertTrue(atualizarPreposto.contemTexto("Não foram encontrados resultados, verifique se a placa informada está atrelada à um CNPJ e à sua loja."));
    }
    @Test
    public void consultandoPlacaValidaVisualizandoModalParaAtualizarDadosPreposto(){
        atualizarPreposto.escrever(By.id("busca"),"OHO4G42");
        atualizarPreposto.clickButtonXpath("//*[@id=\"div\"]/div[1]/button");
        atualizarPreposto.clickButtonXpath("//*[@id=\"table\"]/tbody/tr/td[5]/button");

        Assert.assertTrue(atualizarPreposto.contemTexto("Alterar Nome e CPF Preposto"));
    }
    @Test
    public void altualizandoNomePreposto(){
        atualizarPreposto.escrever(By.id("busca"),"OHO4G42");
        atualizarPreposto.clickButtonXpath("//*[@id=\"div\"]/div[1]/button");
        atualizarPreposto.clickButtonXpath("//*[@id=\"table\"]/tbody/tr/td[5]/button");
        atualizarPreposto.escrever(By.id("nomePreposto"),"PedroTest07");
        atualizarPreposto.clicarBotao("salvarAlteracoes");

        Assert.assertTrue(atualizarPreposto.contemTexto("Salvo com sucesso."));
    }
    @Test
    public void altualizandoCpfPreposto(){
        atualizarPreposto.escrever(By.id("busca"),"OHO4G42");
        atualizarPreposto.clickButtonXpath("//*[@id=\"div\"]/div[1]/button");
        atualizarPreposto.clickButtonXpath("//*[@id=\"table\"]/tbody/tr/td[5]/button");
        atualizarPreposto.escrever(By.id("cpfPreposto"),"13957856272");
        atualizarPreposto.clicarBotao("salvarAlteracoes");

        Assert.assertTrue(atualizarPreposto.contemTexto("Salvo com sucesso."));
    }
    @Test
    public void TentativaDeAtualizarCpfPrepostoComDadosInvalidos(){
        atualizarPreposto.escrever(By.id("busca"),"OHO4G42");
        atualizarPreposto.clickButtonXpath("//*[@id=\"div\"]/div[1]/button");
        atualizarPreposto.clickButtonXpath("//*[@id=\"table\"]/tbody/tr/td[5]/button");
        atualizarPreposto.escrever(By.id("cpfPreposto"),"444444444");
        atualizarPreposto.clicarBotao("salvarAlteracoes");

        Assert.assertTrue(atualizarPreposto.contemTexto("CPF inválido, favor colocar um número de CPF válido."));
    }

}
