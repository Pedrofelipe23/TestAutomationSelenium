package suporteTest;

import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Objects;

import static core.Components.*;
import static core.Driver.fecharDriver;
import static core.TestRecordManagement.captureScreenshot;

public class GerenciarUsuarioSuporteTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("http://localhost:8080/eva/suporte/gerenciarUsuarioSuporte");
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
        forceWait();
        clicarBotao(By.xpath("//*[@id=\"table\"]/tbody/tr/td[7]/span"));

        if (!Objects.equals(obterValorCampo("nomeProp1"), "Pedro Felipe Pereira") && !Objects.equals(obterValorCampo("cpfp1"), "16776548722") && !Objects.equals(obterValorCampo("email"), "pedropereira.wj@gmail.com")){
            escrever(By.id("nomeProp1"),"Pedro Felipe Pereira");
            escrever(By.id("cpfp1"),"16776548722");
            escrever(By.id("email"),"pedropereira.wj@gmail.com");
            forceWait();
            clicarBotao(By.id("btnUpdate"));
            clicarBotao(By.id("btnUpdate"));

            Assert.assertEquals(obterValorCampo("nomeProp1"),"Pedro Felipe Pereira");
            Assert.assertEquals(obterValorCampo("cpfp1"),"16776548722");
            Assert.assertEquals(obterValorCampo("email"),"pedropereira.wj@gmail.com");
        }else {
            escrever(By.id("nomeProp1"),"Pedro Pereira");
            escrever(By.id("cpfp1"),"12345678910");
            escrever(By.id("email"),"wj@wj.com");
            forceWait();
            clicarBotao(By.id("btnUpdate"));
            clicarBotao(By.id("btnUpdate"));

            Assert.assertEquals(obterValorCampo("nomeProp1"),"Pedro Pereira");
            Assert.assertEquals(obterValorCampo("cpfp1"),"12345678910");
            Assert.assertEquals(obterValorCampo("email"),"wj@wj.com");
        }
        forceWait();
        clicarBotao(By.xpath("/html/body/div[4]/div/div[10]/button[1]"));

        Assert.assertTrue(contemTexto("Usuário editado com sucesso"));
    }

    @Test
    public void habilitarDesabilitarUsuario(){
        escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"pedrofelipe");
        forceWait();
        clicarBotao(By.id("1a556969-9c08-4ddf-95b0-bfc1787ebfa5"));

        if (!Objects.equals(obterValorCampo("swal2-content"), "Deseja desabilitar este usuário?")){
            forceWait();
            clicarBotao(By.xpath("/html/body/div[3]/div/div[10]/button[1]"));
            forceWait();
            clicarBotao(By.xpath("/html/body/div[3]/div/div[10]/button[1]"));

            Assert.assertTrue(contemTexto("Deseja desabilitar este usuário?"));
            Assert.assertTrue(contemTexto("Usuário desabilitado com sucesso!"));
        }else {
            forceWait();
            clicarBotao(By.xpath("/html/body/div[3]/div/div[10]/button[1]"));
            forceWait();
            clicarBotao(By.xpath("/html/body/div[3]/div/div[10]/button[1]"));

            Assert.assertTrue(contemTexto("Deseja habilitar este usuário?"));
            Assert.assertTrue(contemTexto("Usuário habilitado com sucesso!"));
        }
        escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"pedrofelipe");
        forceWait();
    }







}
