package VivaTest;

import PageObject.LoginPage;
import VivaPage.LinksBoroscopioPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinksBoroscopioTest {

    private LinksBoroscopioPage boroscopio;


    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Pedro.pereira","1234");
        this.boroscopio = paginaDeLogin.efetuaLoginBoroscopio().carregaPaginaLinksBoroscopio();
    }

    @AfterEach
    public void aftereEach(){
        this.boroscopio.fechar();
    }

    @Test
    public void cadastrandoBoroscopiovalido(){

        String nome = "TesteBoroscopio03";
        String link = "http://localhost:8080/eva/vistoria";

        boroscopio.cadastraNewBoroscopio(nome,link);
        Assert.assertTrue(boroscopio.contemTexto("Cadastrar Boroscópio"));
        Assert.assertTrue(boroscopio.isValidaDadosBoroscopio(nome,link));
    }

    @Test
    public void TentarCadastrarBoroscopiocomDadosInvalidos(){

        String nome = " ";
        String link = " ";

        boroscopio.cadastraNewBoroscopio(nome,link);
        Assert.assertTrue(boroscopio.contemTexto("Necesssário preencher nome e link corretamente."));
    }

    @Test
    public void editandoNomeLinkBoroscopio(){

        String newNome = "TesteBoroscopio9999";
        String newLink = "http://localhost:8080/999999999";

        boroscopio.editaBoroscopioLink(newNome,newLink);
        Assert.assertTrue(boroscopio.contemTexto("TesteBoroscopio02"));
    }

    @Test
    public void desabilitandoBoroscopio(){

        boroscopio.habilitaEdesabilitaBoroscopio();
        Assert.assertFalse(boroscopio.contemTexto("Tem certeza que deseja desabilitar este boroscópio?"));
        Assert.assertFalse(boroscopio.contemTexto("Boroscópio teste001 desabilitado com sucesso!"));
    }

    @Test
    public void habilitandoBoroscopio(){

        boroscopio.habilitaEdesabilitaBoroscopio();
        Assert.assertFalse(boroscopio.contemTexto("Tem certeza que deseja habilitar este boroscópio?"));
        Assert.assertFalse(boroscopio.contemTexto("Boroscópio teste001 habilitado com sucesso!"));
    }

    @Test
    public void excluindoBoroscopio(){

        boroscopio.excluirBoroscopio();
        Assert.assertFalse(boroscopio.contemTexto("Tem certeza que deseja excluir este boroscópio?"));
        Assert.assertFalse(boroscopio.contemTexto("Boroscópio excluído com sucesso!"));
    }
}
