package vivaTest;

import core.LoginPage;
import vivaPage.LinksECVsPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinksECVsTest {

    private LinksECVsPage linksECV;


    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Pedro.pereira","1234");
        this.linksECV = paginaDeLogin.efetuaLoginECV().carregaPagePagamento();
    }

    @AfterEach
    public void aftereEach(){
        this.linksECV.fecharDriver();
    }

    @Test
    public void cadastrandoECVvalido(){

        String nome = "teste";
        String link = "http://localhost:8080/eva/vistoria/linksECV";

        linksECV.cadastraNewECV(nome,link);
        Assert.assertTrue(linksECV.contemTexto("Cadastrar Câmera"));
        Assert.assertTrue(linksECV.isValidaDadosCadastrados(nome,link));
    }

    @Test
    public void TentarCadastrarECVcomDadosInvalidos(){

        String nome = " ";
        String link = " ";

        linksECV.cadastraNewECV(nome,link);
        Assert.assertTrue(linksECV.contemTexto("Necesssário preencher nome e link corretamente."));
    }

    @Test
    public void editandoNomeLinkCamera(){

        String newNome = "ECVTESTE999";
        String newLink = "http://localhost:8080/999999999";

        linksECV.editaNomeLink(newNome,newLink);
        Assert.assertTrue(linksECV.contemTexto("ECVTESTE03"));
    }

    @Test
    public void desabilitandoCameraECV(){

        linksECV.habilitaEdesabilitaCamera();
        Assert.assertFalse(linksECV.contemTexto("Tem certeza que deseja desabilitar esta câmera?"));
        Assert.assertFalse(linksECV.contemTexto("Câmera ECVTESTE01 desabilitada com sucesso!"));
    }

    @Test
    public void habilitandoCamera(){

        linksECV.habilitaEdesabilitaCamera();
        Assert.assertFalse(linksECV.contemTexto("Tem certeza que deseja habilitar esta câmera?"));
        Assert.assertFalse(linksECV.contemTexto("Câmera ECVTESTE01 habilitada com sucesso!"));
    }

    @Test
    public void excluindoCameraECV(){

        linksECV.excluirCamera();
        Assert.assertFalse(linksECV.contemTexto("Tem certeza que deseja excluir esta câmera?"));
        Assert.assertFalse(linksECV.contemTexto("Câmera excluída com sucesso!"));
    }
}
