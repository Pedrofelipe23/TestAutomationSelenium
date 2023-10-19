package suporteTest;

import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static core.Components.*;
import static core.PageObject.fecharDriver;
import static core.TestRecordManagement.captureScreenshot;

public class GerenciarUsuarioSuporteTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("https://suporte.vivabr.com.br/viva/suporte/gerenciarUsuarioSuporte");
        paginaDeLogin.preencherFormularioDeLogin("davi.santos","1234");
        paginaDeLogin.efetuaLogin();
    }

    @AfterEach
    public void aftereEach(){
        captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"GerenciarUsuarioSuporte");
        fecharDriver();
    }

    @Test
    public void pesquisarUsuarioPorNome(){
        escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"Pedro Pereira");
        forceWait();

        Assert.assertTrue(isPage("https://suporte.vivabr.com.br/viva/suporte/gerenciarUsuarioSuporte"));
        Assert.assertTrue(contemTexto("Gerenciamento de Usuários"));
        Assert.assertTrue(contemTexto("Pedro Pereira"));
    }

    @Test
    public void pesquisarUsuarioPorLogin(){
        escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"pedrofelipe");
        forceWait();

        Assert.assertTrue(contemTexto("pedrofelipe"));
    }

    @Test
    public void pesquisarUsuarioPorCPF(){
        escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"16776548722");
        forceWait();

        Assert.assertTrue(contemTexto("167.765.487-22"));
    }

    @Test
    public void editandoInformacoesUsuario(){
        escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"pedrofelipe");
        clicarBotao(By.xpath("//*[@id=\"table\"]/tbody/tr/td[7]/span"));
        forceWait();

        Assert.assertTrue(contemTexto("Editar Usuário"));
    }





}
