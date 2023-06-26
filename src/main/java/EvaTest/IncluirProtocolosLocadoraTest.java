package EvaTest;

import EvaPage.IncluirProtocolosLocadoraPage;
import PageObject.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class IncluirProtocolosLocadoraTest {
    public IncluirProtocolosLocadoraPage incluirProtocolo;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("padilha.ernani","654321");
        this.incluirProtocolo = paginaDeLogin.efetuaLoginIncluirProtocolosLocadora();
        this.incluirProtocolo = incluirProtocolo.carregarFormulario();
    }

    @AfterEach
    public void aftereEach(){
        this.incluirProtocolo.fechar();
    }

    @Test
    public void tentativaIncluirAnexo(){

        incluirProtocolo.anexarArquivo();
        incluirProtocolo.buttonIncluir();
        incluirProtocolo.swalComfirm();

        Assert.assertTrue(incluirProtocolo.contemTexto("Você deve digitar uma descrição"));
    }

    @Test
    public void tentativaIncluirProtocoloSoDescricao(){

        incluirProtocolo.campoDescricao("Teste de descrição 01");
        incluirProtocolo.buttonIncluir();
        incluirProtocolo.swalComfirm();

        Assert.assertTrue(incluirProtocolo.isPageIncluirProtocolosLocadora());
        Assert.assertTrue(incluirProtocolo.contemTexto("Você deve escolher um arquivo para o envio."));
    }

    @Test
    public void tentativaIncluirProtocoloSoChaveDeAcesso(){

        incluirProtocolo.campoChaveDeAcesso("12345678901234567890123456789012345678901234");
        incluirProtocolo.buttonIncluir();
        incluirProtocolo.swalComfirm();

        Assert.assertTrue(incluirProtocolo.contemTexto("Você deve escolher um arquivo para o envio."));
    }

    @Test
    public void tentativaIncluirSemDados(){

        incluirProtocolo.buttonIncluir();
        incluirProtocolo.swalComfirm();

        Assert.assertTrue(incluirProtocolo.contemTexto("Você deve escolher um arquivo para o envio."));
    }

    @Test
    public void tentativaDeConfirmarCriaçãoSemDados(){

        incluirProtocolo.buttonConfirmarCriacao();
        incluirProtocolo.buttonConfirmarCriacao();
        incluirProtocolo.swalComfirm();


        Assert.assertTrue(incluirProtocolo.contemTexto("Importe a tabela e preencha as informações para prosseguir")); // erro de português encontrado
    }

    @Test
    public void tentativaDeIncluirProtocoloSemDescricao(){

        incluirProtocolo.anexarArquivo();
        incluirProtocolo.campoChaveDeAcesso("12345678901234567890123456789012345678901234");
        incluirProtocolo.buttonIncluir();

        Assert.assertTrue(incluirProtocolo.contemTexto("Você deve digitar uma descrição"));
    }

    @Test
    public void tentativaDeIncluirProtocoloComChaveDeAcessoInvalido(){

        incluirProtocolo.anexarArquivo();
        incluirProtocolo.campoChaveDeAcesso("12345678901234567890123456789012345678901234");
        incluirProtocolo.campoDescricao("Teste Descrição 099");
        incluirProtocolo.buttonIncluir();

        Assert.assertTrue(incluirProtocolo.contemTexto("Numero da chave de acesso inválida, caso não queira informar uma chave de acesso, limpe o campo e tente novamente.")); // erro de português acentuação
    }

    @Test
    public void incluindoProtocoloConfirmandoCriacao(){
        incluirProtocolo.anexarArquivo();
        incluirProtocolo.campoDescricao("Teste Descrição 071");
        incluirProtocolo.buttonIncluir();
        incluirProtocolo.buttonConfirmarCriacao();

        Assert.assertTrue(incluirProtocolo.contemTexto("Criaçao realizada com sucesso, n° o lote para essa operação é"));
    }



}
