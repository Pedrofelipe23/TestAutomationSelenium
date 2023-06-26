package VivaTest;

import PageObject.LoginPage;
import VivaPage.MesaSuportePage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MesaSuporteTest {

    private MesaSuportePage mesaSuporte;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("pedro", "1234");
        this.mesaSuporte = paginaDeLogin.efetuaLoginMesaSuporte().carregaPaginaMesaSuporte();
    }

    @AfterEach
    public void aftereEach(){
        this.mesaSuporte.fechar();
    }

    @Test
    public void TentarConsultarVistoriaInvalida(){

        String vistoria = "123"; // o input pede só placa, falta habilitar consulta por chassi

        mesaSuporte.consultaVistoria(vistoria);
        Assert.assertFalse(mesaSuporte.contemTexto("Nenhuma vistoria encontrada."));


    }

    @Test
    public void consultandoVistoriaValida(){

    }

}
