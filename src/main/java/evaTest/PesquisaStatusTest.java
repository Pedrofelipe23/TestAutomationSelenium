package evaTest;

import core.Components;
import core.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class PesquisaStatusTest {


    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("http://localhost:8080/eva/administrativo/pesquisaStatus");
        paginaDeLogin.preencherFormularioDeLogin("mundo.placas","Aa02468");
    }

    @AfterEach
    public void aftereEach(){
        Components.fecharDriver();
    }




}
