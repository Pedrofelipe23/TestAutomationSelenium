package evaDigitalTest;

import core.Components;
import core.LoginPage;
import core.TestRecordManagement;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class EmplacamentoDigitalTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Pedro.pereira","1234");
        paginaDeLogin.efetuaLoginEmplacamentoDigital();
    }

    @AfterEach
    public void aftereEach(){
        Components.captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"EmplacamentoDigital");
        Components.fecharDriver();
    }

    @Test
    public void consultandoChassiInvalido(){
        Components.escrever(By.id("chassi"),"9362CKFW98B02003255");
        Assert.assertTrue(Components.contemTexto("O campo deve conter no máximo 15 caracteres"));
        Assert.assertTrue(Components.isPage("http://localhost:8080/eva/primeiroEmplacamentoDigital/emplacamentoDigital"));
    }

    @Test
    public void consultandoChassiVazio(){
        Components.escrever(By.id("chassi")," ");
        Assert.assertTrue(Components.contemTexto("Chassi é obrigatório"));
    }

    @Test
    public void consultandoCPFInvalido(){
        Components.escrever(By.id("cpf"),"111");
        Assert.assertTrue(Components.contemTexto("CPF inválido"));
    }

    @Test
    public void consultandoCPFVazio(){
        Components.escrever(By.id("cpf")," ");
        Assert.assertTrue(Components.contemTexto("CPF é obrigatório"));
    }

    @Test
    public void consultandoSemPreencherDados(){
        Components.clicarBotao(By.id("btn-search"));
        Assert.assertTrue(Components.contemTexto("Chassi é obrigatório"));
        Assert.assertTrue(Components.contemTexto("CPF é obrigatório"));
    }

    @Test
    public void consultandoDadosValidos(){
        Components.escrever(By.id("chassi"),"9362CKFW98B0200");
        Components.escrever(By.id("cpf"),"13847966064");
        Components.clicarBotao(By.id("btn-search"));

        Assert.assertTrue(Components.contemTexto("Primeiro Emplacamento Digital"));
    }
}
