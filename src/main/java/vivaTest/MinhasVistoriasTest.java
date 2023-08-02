package vivaTest;

import core.Components;
import core.LoginPage;
import vivaPage.VistoriasPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class MinhasVistoriasTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("es.poc","1234");
        paginaDeLogin.page("http://localhost:8080/eva/vistoria/gerenciarPagamentosVistoria");
    }

    @AfterEach
    public void aftereEach(){
        Components.captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"Vistoria");
        Components.fecharDriver();
    }


}
