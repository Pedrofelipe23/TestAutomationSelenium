package evaTest;


import core.LoginPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NfeAgerarEvaTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage("");
        paginaDeLogin.preencherFormularioDeLogin("padilha.ernani","654321");

    }

    @AfterEach
    public void aftereEach(){

    }


}
