package EvaTest;

import EvaPage.EnviarAutorizacaoDetranMultPage;
import PageObject.LoginPage;
import PageObject.PageComponents;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnviarAutorizacaoDetranMultTest {

    private EnviarAutorizacaoDetranMultPage enviarAutDetran;

    @BeforeEach
    public void beforeEach()  {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Pedro.pereira", "1234");
        this.enviarAutDetran = paginaDeLogin.efetuarLoginEnviarAutorizacaoDetranMulti();
        this.enviarAutDetran = enviarAutDetran.carregarPage();
    }

    @AfterEach
    public void aftereEach() {
        this.enviarAutDetran.fechar();
    }

    @Test
    public void tentativaDeEnviarEstampagemSingle(){

        enviarAutDetran.clickButtonXpath("//*[@id=\"table\"]/tbody/tr[1]/td[7]/span");
        enviarAutDetran.clickButtonXpath("/html/body/div[3]/div/div[10]/button[1]");
        Assert.assertTrue(enviarAutDetran.isPageEnviarAutorizacaoDetranMult());
        Assert.assertTrue(enviarAutDetran.contemTexto("Estampagens a enviar ao DETRAN"));
        Assert.assertTrue(enviarAutDetran.contemTexto("Autorização de estampagem não encontrada"));
    }

    @Test
    public void tentativaDeEnviarEstampagensMultiSemSelecionarAtendimentos(){

        enviarAutDetran.clickButton("allChecks");
        Assert.assertTrue(enviarAutDetran.contemTexto("Selecione ao menos um atendimento."));
    }

    @Test
    public void tentativaDeEnviarEstamoagensMultiSelecionandoTodosAtendimentos(){

        enviarAutDetran.clickButton("checkAll");
        enviarAutDetran.clickCheck("allChecks");
        Assert.assertTrue(enviarAutDetran.contemTexto("Enviando autorizações, aguarde..."));
    }

}
