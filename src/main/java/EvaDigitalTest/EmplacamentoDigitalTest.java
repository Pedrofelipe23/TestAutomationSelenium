package EvaDigitalTest;

import EvaDigitalPage.EmplacamentoDigitalPage;
import PageObject.LoginPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class EmplacamentoDigitalTest {
    private EmplacamentoDigitalPage emplacamento;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Pedro.pereira","1234");
        this.emplacamento = paginaDeLogin.efetuaLoginEmplacamentoDigital();
        this.emplacamento = emplacamento.carregarFormulario();
    }

    @AfterEach
    public void aftereEach(){
        this.emplacamento.fechar();
    }

    @Test
    public void consultandoChassiInvalido(){
        emplacamento.escrever(By.id("chassi"),"9362CKFW98B020032");
        Assert.assertTrue(emplacamento.contemTexto("O campo deve conter no máximo 15 caracteres"));
        Assert.assertTrue(emplacamento.isPageEmplacamentoDigital());
    }

    @Test
    public void consultandoChassiVazio(){
        emplacamento.escrever(By.id("chassi")," ");
        Assert.assertTrue(emplacamento.contemTexto("Chassi é obrigatório"));
    }

    @Test
    public void consultandoCPFInvalido(){
        emplacamento.escrever(By.id("cpf"),"111");
        Assert.assertTrue(emplacamento.contemTexto("CPF inválido"));
    }

    @Test
    public void consultandoCPFVazio(){
        emplacamento.escrever(By.id("cpf")," ");
        Assert.assertTrue(emplacamento.contemTexto("CPF é obrigatório"));

    }

    @Test
    public void consultandoDadosValidos(){
        emplacamento.escrever(By.id("chassi"),"9362CKFW98B0200");
        emplacamento.escrever(By.id("cpf"),"13847966064");
        emplacamento.clicarBotao("btn-search");

        Assert.assertTrue(emplacamento.contemTexto("Primeiro Emplacamento Digital"));
    }
}
