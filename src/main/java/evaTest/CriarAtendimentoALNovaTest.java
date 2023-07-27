package evaTest;

import core.Components;
import core.LoginPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CriarAtendimentoALNovaTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("padilha.ernani","654321");
        paginaDeLogin.efetuaLoginCriarAtendimentoALNova();
    }

    @AfterEach
    public void aftereEach(){
        Components.captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"CriarAtendimentoALNova");
        Components.fecharDriver();
    }

    @Ignore
    public void ConsultarAutorizacaoComDadosInvalidos(){

    }

    @Test
    public void ConsultarAutorizacaoComInputsVazios(){
        Components.clicarBotao(By.id("incluir"));

        Assert.assertTrue(Components.contemTexto("Os campos placa e renavam devem ser preenchidos"));
    }

    @Test
    public void checkValidacaoChassi(){
        Components.clicarBotao(By.id("check"));

        Assert.assertTrue(Components.contemTexto("Validação de Chassi"));
        Assert.assertTrue(Components.contemTexto("Tamanho do chassi para o novo padrão mundial inválido"));
    }

    @Test
    public void tentativaCEPInvalido(){
        Components.escrever(By.id("cep1"),"22222222");
        Components.clicarBotao(By.id("placa"));

        Assert.assertTrue(Components.contemTexto("Aguarde, procurando cep digitado"));
        Assert.assertTrue(Components.contemTexto("CEP inválido"));
    }

    @Test
    public void tentativaTelefoneInvalido(){
        Components.escrever(By.id("telefone"),"12345678");

        Assert.assertTrue(Components.contemTexto("Telefone inválido"));
    }

    @Test
    public void tentativaCPFTerceiroInvalido(){
        Components.escrever(By.id("cpfterceiro"),"12345678");
        Components.clicarBotao(By.id("placa"));

        Assert.assertTrue(Components.contemTexto("CPF Inválido"));
    }

    @Test
    public void tentativaEmailInvalido(){
        Components.escrever(By.id("email"),"teste123");
        Components.clicarBotao(By.id("placa"));

        Assert.assertTrue(Components.contemTexto("E-mail informado incorreto. Por favor, tente novamente."));
    }

    @Test
    public void tentativaDeIncluirComDadosInvalidos(){
        Components.clicarBotao(By.id("incluir2"));

        Assert.assertTrue(Components.contemTexto("Os seguintes campos devem ser preenchidos:"));
        Assert.assertTrue(Components.contemTexto("  Número de Autorização, CPF/CNPJ, Nome do Proprietário, e-mail, Estado, Bairro, Cidade, Número do Endereço, Endereço, CEP, Telefone, Chassi, Cor, Marca e modelo"));
    }

    @Test
    public void tentativaDeCriarAtendimentoComDadosVazios(){
        Components.clicarBotao(By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/div[2]/div/button"));

        Assert.assertTrue(Components.contemTexto("Você deve incluir ao menos um atendimento antes de criar."));
    }


}
