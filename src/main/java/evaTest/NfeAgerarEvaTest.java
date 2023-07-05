package evaTest;

import evaPage.NfeAgerarEvaPage;
import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NfeAgerarEvaTest {

    private NfeAgerarEvaPage nfeAgerar;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("padilha.ernani","654321");
        this.nfeAgerar = paginaDeLogin.efetuaLoginNfe();
        this.nfeAgerar = nfeAgerar.carregarFormulario();
    }

    @AfterEach
    public void aftereEach(){
        this.nfeAgerar.fecharDriver();
    }

    @Test
    public void consultandoNotaFiscal(){

        String texto = "Teste TextArea @1234";

        nfeAgerar.consutaNfe();
        nfeAgerar.textAreaNfe(texto);
        Assert.assertTrue(nfeAgerar.contemTexto("GERAR NFe"));
        Assert.assertFalse(nfeAgerar.contemTexto("O modelo da sua nota fiscal não foi gerado. Favor comunicar o suporte para a criação correta."));
    }
}
