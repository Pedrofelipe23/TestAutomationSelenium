package vivaTest;

import core.Components;
import core.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MinhasVistoriasTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("es.poc","1234");
        paginaDeLogin.page("http://localhost:8080/eva/vistoria/gerenciarPagamentosVistoria");
    }

    @AfterEach
    public void aftereEach(){
        Components.captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"MinhasVistoria");
        Components.fecharDriver();
    }

    @Test
    public void TesteInputDepesquisa(){
        Components.escrever(By.xpath("//*[@id=\"table_filter\"]/label/input"),"GDG5J22");

    }

}
