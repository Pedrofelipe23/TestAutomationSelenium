package evaTest;

import evaPage.EstampagensFeitasNewPage;
import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstampagensFeitasNewTest {

    private EstampagensFeitasNewPage estampagensFeitas;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("sara.0121","1234");
        this.estampagensFeitas = paginaDeLogin.efetuaLoginEstampagens();
        this.estampagensFeitas = estampagensFeitas.carregarFormulario();
    }

    @AfterEach
    public void aftereEach(){
        this.estampagensFeitas.fechar();
    }

    @Test
    public void consultandoPlacaSemProprietario(){

        String placa = "SHN4B07";

        estampagensFeitas.consultaPlaca(placa);
        Assert.assertTrue(estampagensFeitas.isPageEstampagensFeitasNew());
    }

    @Test
    public void consultandoPlacaComProprietarioCadastrado(){

        String placa = "RVJ9A88";
        String proprietario = "LOCALIZA";

        estampagensFeitas.consultaPlaca(placa);
        Assert.assertFalse(estampagensFeitas.contemTexto(proprietario));
    }

}
