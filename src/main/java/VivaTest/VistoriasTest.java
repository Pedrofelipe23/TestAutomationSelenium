package VivaTest;

import PageObject.LoginPage;
import VivaPage.VistoriasPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VistoriasTest {

    private VistoriasPage vistorias;


    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("daniel.poc","1234");
        this.vistorias = paginaDeLogin.efetuaLoginVistorias().carregarPage();
    }

    @AfterEach
    public void aftereEach(){
        this.vistorias.fechar();
    }

    @Test
    public void consultandoDetalhesVistoriaBlockchain(){

        String proprietario = "VANDERLEI MARTINS FARIAS";
        String condutor = "FABIO SANTOS";

        vistorias.consultaVistoria();

        Assert.assertTrue(vistorias.contemTexto("Consulta de Blockchain"));
        Assert.assertFalse(vistorias.isValidaBlockchain(proprietario,condutor));
    }
}
