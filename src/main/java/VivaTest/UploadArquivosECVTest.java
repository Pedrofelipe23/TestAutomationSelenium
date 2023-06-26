package VivaTest;

import PageObject.LoginPage;
import VivaPage.UploadArquivosECVPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UploadArquivosECVTest {

    private UploadArquivosECVPage uploadArquivo;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("matheusmws", "1234");
        this.uploadArquivo = paginaDeLogin.efetuarLoginUploadArquivosECV().carregaPaginaUploadArquivosECV();
    }

    @AfterEach
    public void aftereEach(){
        this.uploadArquivo.fechar();
    }

    @Test
    public void visualisandoArquivosParaBaixar(){

        uploadArquivo.visualizaArquivos();
        Assert.assertTrue(uploadArquivo.isValidaDadosCnpjLoja("24.829.329/0001-28","OTIMIZA VISTORIAS"));
        Assert.assertTrue(uploadArquivo.contemTexto("Clique para baixar"));
    }

    @Test
    public void tentantivaDeCadastroDocumentoSemAnexarPDF(){

        uploadArquivo.incluirPDFDocumento();
        uploadArquivo.cadastrar();
        Assert.assertTrue(uploadArquivo.contemTexto("Necessário escolher o tipo de arquivo."));
    }

}
