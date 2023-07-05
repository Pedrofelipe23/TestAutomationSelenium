package vivaTest;

import core.LoginPage;
import vivaPage.EnviaVistoriaDetranPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnviaVistoriaDetranTest {

    private EnviaVistoriaDetranPage enviaVistoria;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("matheusmws", "1234");
        this.enviaVistoria = paginaDeLogin.efetuaLoginEnviaVistoriaDetran().carregaPaginaEnviaVistoriaDetran();
    }

    @AfterEach
    public void aftereEach(){
        this.enviaVistoria.fecharDriver();
    }

    @Test
    public void TentativaDeEnvioVistoriaDetran(){

        enviaVistoria.enviaDetran();
        enviaVistoria.swalConfirm();
        Assert.assertTrue(enviaVistoria.contemTexto("Vistoria(s) Não Enviada(s)"));
        Assert.assertTrue(enviaVistoria.contemTexto("Sucesso"));
        Assert.assertTrue(enviaVistoria.contemTexto("A seguinte vistoria não consta resultado registrado e não foi enviada: RQR9B14"));
    }

    @Test
    public void TentativaDeEnvioVistoriasMultiplasParaDetran(){

        enviaVistoria.allCheckBox();
        enviaVistoria.enviaDetranMultiplos();
        enviaVistoria.swalConfirm();
        Assert.assertTrue(enviaVistoria.contemTexto("As seguintes vistorias não constam resultado registrado e não foram enviadas: SFT5H25, MTA6I67, MSY2E66, RQR9B14, PQG9F35"));
    }

    @Test
    public void TentaEnviarVistoriasMultiplasSemCheckBox(){

        enviaVistoria.enviaDetranMultiplos();
        enviaVistoria.swalConfirm();
        Assert.assertTrue(enviaVistoria.contemTexto("Atenção"));
        Assert.assertTrue(enviaVistoria.contemTexto("Você deve selecionar ao menos uma vistoria para enviar ao DETRAN."));
    }

}
