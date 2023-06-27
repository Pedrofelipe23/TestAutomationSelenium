package evaTest;

import evaPage.UpdateCertificatePage;
import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class UpdateCertificateTest {

    private UpdateCertificatePage updateCertificate;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Feitosa","1234");
        this.updateCertificate = paginaDeLogin.efetuaLoginUpdateCertificate();
        this.updateCertificate = updateCertificate.carregarFormulario();
    }

    @AfterEach
    public void aftereEach(){
        this.updateCertificate.fechar();
    }

    @Test
    public void tentativaDeAtualizarCertificadoSemAnexarFile(){
        updateCertificate.escrever(By.id("senhaCert"), "4321");
        updateCertificate.clickButton("btnCertificado1");

        Assert.assertTrue(updateCertificate.contemTexto("O envio do certificado é obrigatório!"));
        updateCertificate.escrever(By.id("senhaCert"), "4321");
        updateCertificate.clickButton("btnCertificado1");
    }

    @Test
    public void tentativaDeAtualizarCertificadoDiferenteDoClienteAutenticadoAtual(){
        updateCertificate.anexaFile("uplodFile");
        updateCertificate.escrever(By.id("senhaCert"), "4321");
        updateCertificate.clickButton("btnCertificado1");

    }

    @Test
    public void tentativaDeAtualizacaoCertificadoComSenhaInvalida(){
        updateCertificate.anexaFile("uplodFile");
        updateCertificate.escrever(By.id("senhaCert"), "4321");
        updateCertificate.clickButton("btnCertificado1");

        Assert.assertTrue(updateCertificate.isPageUpdateCertificate());
        Assert.assertTrue(updateCertificate.contemTexto("Atualizar Cerfiticado"));
        Assert.assertTrue(updateCertificate.contemTexto("Seu certificado não foi validado no sistema emplaca do SERPRO ou sua senha está errada. " +
                "Favor verificar se seu contrato está ativo no DENATRAN/SERPRO, e se a senha digitada está correta."));
    }

    @Test
    public void tentativaDeAtualizacaoCertificadoValido(){
        updateCertificate.anexaFile("uplodFile");
        updateCertificate.escrever(By.id("senhaCert"), "Adminwj001");
        updateCertificate.clickButton("btnCertificado1");

        Assert.assertTrue(updateCertificate.contemTexto("Atualizar Cerfiticado"));
    }

}
