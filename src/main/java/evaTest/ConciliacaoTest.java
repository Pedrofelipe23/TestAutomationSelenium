package evaTest;

import evaPage.ConciliacaoPage;
import core.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConciliacaoTest {

    private ConciliacaoPage conciliar;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("company","company@123");
        this.conciliar = paginaDeLogin.efetuaLoginConciliacao();
        this.conciliar = conciliar.carregarFormulario();
    }

    @AfterEach
    public void aftereEach(){
        this.conciliar.fecharDriver();
    }

    @Test
    public void tentativaDeConciliacao(){

        String placa = "SHP8B44";
        String autDenatran = "";
        String valor = "";

        conciliar.consultaPlacaConciliacao(placa);
        Assert.assertTrue(conciliar.contemTexto("Conciliação Bancaria"));
        Assert.assertTrue(conciliar.isValidaDadosAtendimento(autDenatran, autDenatran, valor));
    }


}
