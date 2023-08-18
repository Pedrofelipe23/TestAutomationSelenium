package vivaTest;

import core.Components;
import core.LoginPage;
import vivaPage.UploadArquivosECVPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class UploadArquivosECVTest {


    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("es.poc", "1234");
        paginaDeLogin.page("http://localhost:8080/eva/vistoria/uploadArquivosECV");
    }

    @AfterEach
    public void aftereEach(){
        Components.captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"UploadArquivosECV");
        Components.fecharDriver();
    }

}
