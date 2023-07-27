package vivaTest;

import core.LoginPage;
import vivaPage.GerenciarModeloNFPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GerenciarModeloNFTest {

    private GerenciarModeloNFPage modeloNF;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("matheusmws", "1234");
        this.modeloNF = paginaDeLogin.efetuaLoginGerenciarModeloNF().carregaPaginaGerenciarModeloNF();
    }

    @AfterEach
    public void aftereEach(){
        this.modeloNF.fecharDriver();
    }

    //Teste de validações dos inputs.

    @Test
    public void tentativaDeBuscarCepInvalido(){

        String cep = "22456000";

        modeloNF.consultaCEP(cep);
        modeloNF.concluirEdicaoDeModelo();
        Assert.assertEquals("22456000",cep);
        Assert.assertTrue(modeloNF.contemTexto("O CEP informado não existe! "));
        Assert.assertTrue(modeloNF.contemTexto(" Insira um CEP válido!"));
    }

    @Test
    public void tentativaDeConcluirEdicaoComInputCepVazio(){

        String cep = " ";

        modeloNF.consultaCEP(cep);
        modeloNF.concluirEdicaoDeModelo();
        Assert.assertEquals(" ",cep);
        Assert.assertTrue(modeloNF.contemTexto("O campo "));
        System.out.println("CEP");
        Assert.assertTrue(modeloNF.contemTexto(" não foi preenchido."));
    }

    @Test
    public void tentativaDeCadastrarEmailInvalido(){

        String email = "pedro";

        modeloNF.cadastrarEmail(email);
        Assert.assertEquals("pedro",email);
        Assert.assertTrue(modeloNF.contemTexto("Email inválido!"));
        Assert.assertTrue(modeloNF.contemTexto("Por favor, informe um email válido."));
    }

    @Test
    public void tentativaDeCadastrarEmailVazio(){

        String email = " ";

        modeloNF.cadastrarEmail(email);
        modeloNF.concluirEdicaoDeModelo();
        Assert.assertEquals(" ",email);
        Assert.assertTrue(modeloNF.contemTexto("Email inválido!"));
        Assert.assertTrue(modeloNF.contemTexto("Por favor, informe um email válido."));
    }

    @Test
    public void tentativaDeConcluirEdicaoComInputEmailVazio(){

        String email = "";

        modeloNF.cadastrarEmail(email);
        modeloNF.swalConfirm();
        modeloNF.swalConfirm();
        modeloNF.concluirEdicaoDeModelo();
        Assert.assertEquals("",email);
        System.out.println("O campo Email");
        Assert.assertTrue(modeloNF.contemTexto(" não foi preenchido."));
    }

    @Test
    public void tentativaDeCadastrarTelefoneInvalido(){

        String telefone = "12345";

        modeloNF.cadastrarTelefone(telefone);
        Assert.assertEquals("12345", telefone);
        Assert.assertTrue(modeloNF.contemTexto("Telefone inválido! "));
        Assert.assertTrue(modeloNF.contemTexto(" Insira um número de telefone/celular válido."));
    }

    @Test
    public void tentativaDeCadastrarTelefoneVazio(){

        modeloNF.cadastrarTelefone(" ");
        Assert.assertTrue(modeloNF.contemTexto("Telefone inválido! "));
        Assert.assertTrue(modeloNF.contemTexto(" Insira um número de telefone/celular válido."));
    }

    @Test
    public void tentativaDeConcluirEdicaoComInputTelefoneVazio(){

        String telefone = "";

        modeloNF.cadastrarTelefone(telefone);
        modeloNF.swalConfirm();
        modeloNF.swalConfirm();
        modeloNF.concluirEdicaoDeModelo();
        Assert.assertEquals("", telefone);
        System.out.println("O campo Telefone");
        Assert.assertTrue(modeloNF.contemTexto(" não foi preenchido."));
    }

}
