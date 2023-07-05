package evaTest;

import evaPage.CriarAtendimentoCEMixedPage;
import core.LoginPage;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CriarAtendimentoCEMixedTest {

    private CriarAtendimentoCEMixedPage criarAtendimento;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Pedro.pereira","1234");
        this.criarAtendimento = paginaDeLogin.efetuaLoginCriarAtendimentoCEMixed();
        this.criarAtendimento = criarAtendimento.carregarFormulario();
    }

    @AfterEach
    public void aftereEach(){
        this.criarAtendimento.fecharDriver();
    }

    @Ignore
    public void TentativaDeCriarAtendimentoComNomePrepostoVazio(){

    }
    @Ignore
    public void TentativaDeCriarAtendimentoComNomePrepostoComEspaco(){

    }
    @Ignore
    public void TentativaDeCriarAtendimentoComCpfPrepostoVazio(){

    }
    @Ignore
    public void TentativaDeCriarAtendimentoComCpfPrepostoComString(){

    }
    @Ignore
    public void TentativaDeCriarAtendimentoComCpfPrepostoComEspaco(){

    }

    @Ignore
    public void TentativaDeCriarAtendimentoComCpfPrepostoComValido(){

    }


}
