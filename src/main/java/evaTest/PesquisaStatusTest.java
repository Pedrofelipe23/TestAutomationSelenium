package evaTest;

import evaPage.PesquisaStatusPage;
import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PesquisaStatusTest {

    private PesquisaStatusPage pesquisaStatus;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("mundo.placas","Aa02468");
        this.pesquisaStatus = paginaDeLogin.efetuaLoginPesquisaStatus();
        this.pesquisaStatus = pesquisaStatus.carregarFormulario();
    }

    @AfterEach
    public void aftereEach(){
        this.pesquisaStatus.fechar();
    }

    @Test
    public void pesquisaRetornoStatusValido(){

        pesquisaStatus.consultaStatusPlaca("OEN5C91");

        String placa = "NVK9J85";
        String loja = "GUIMARAES PLACAS";
        String cnpj = "09235081000183";
        String data = "01/07/2020";
        String estadoDaAut = "CONCLUIDA";

        Assert.assertTrue(pesquisaStatus.isPagePesquisaStatus());
        Assert.assertTrue(pesquisaStatus.contemTexto("Pesquisar Status"));
        Assert.assertFalse(pesquisaStatus.isRetornoConsulta(placa,loja,cnpj,data,estadoDaAut));

    }

    @Test
    public void pesquisaComPlacaInvalida(){

        pesquisaStatus.consultaStatusPlaca("OEN5C99");
        pesquisaStatus.swalLojaNaoEncotrada();

        Assert.assertTrue(pesquisaStatus.isPagePesquisaStatus());
        Assert.assertTrue(pesquisaStatus.contemTexto("Placa não encontrada, verificar placa inserida."));

    }


}
