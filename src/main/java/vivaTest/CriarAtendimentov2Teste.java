package vivaTest;

import core.LoginPage;
import vivaPage.CriarAtendimentov2Page;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CriarAtendimentov2Teste {

    private CriarAtendimentov2Page criarAtendimento;


    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Pedro.pereira","1234");
        this.criarAtendimento = paginaDeLogin.efetuaLoginv2().carregarPage();
    }

    @AfterEach
    public void aftereEach(){
        this.criarAtendimento.fechar();
    }

    @Ignore
    public void consultandoIntegracao(){

        String placa = "PQG9F33";
        String cpfInteressado = "02185674722";
        String cpfVistoriador = "02185674722";

        criarAtendimento.consultarIntegracao(placa, cpfInteressado,cpfVistoriador);

        Assert.assertTrue(criarAtendimento.contemTexto("Informações Gerais"));
        Assert.assertFalse(criarAtendimento.isValidaConsultaDaIntegracao(placa, cpfInteressado,cpfVistoriador));
    }

    @Ignore
    public void consultandoIntegracaoEincluindoAtendimento(){

        String placa = "PQG9F33";
        String cpfInteressado = "02185674722";
        String cpfVistoriador = "02185674722";
        String marcaModeloCor = "HONDA/NXR160 BROS ESDD    / BRANCA";
        String chassi = "9C2KD0810FR428499";
        String renavam = "1048599989";
        String valor = "100,00";
        String nomeProprietario = "VANDERLEI MARTINS FARIAS";
        String cpfProprietario = "16776548722";
        String email = "wj@wj.com.br";
        String telefone = "21999999999";
        String cep = "22783113";
        String numEndereco = "10";
        String complemento = "casa abc";
        String municipio = "Rio de Janeiro";

        criarAtendimento.consultarIntegracao(placa, cpfInteressado,cpfVistoriador);
        criarAtendimento.informacoesProprietario(valor, cpfProprietario,email,telefone);
        criarAtendimento.informacoesContato(cep,numEndereco,complemento,municipio);

        Assert.assertTrue(criarAtendimento.contemTexto("Informações Gerais"));
        Assert.assertFalse(criarAtendimento.isValidaConsultaDaIntegracao(placa, cpfInteressado,cpfVistoriador));
        Assert.assertFalse(criarAtendimento.isValidaInformacoesVeiculo(marcaModeloCor,chassi,renavam,valor));
    }

    /**************** Teste de validação de CPFs na tela ****************/
    @Test
    public void consultandoCPFIntegracaoInvalido(){

        criarAtendimento.CPFIntegracao("1234");
        criarAtendimento.incluir();
        criarAtendimento.confirmSwal();
        Assert.assertTrue(criarAtendimento.contemTexto("CPF Inválido"));
    }

    @Test
    public void consultandoCPFIntegracaoValido(){

        criarAtendimento.CPFIntegracao("16776548722");
        criarAtendimento.incluir();
        Assert.assertTrue(criarAtendimento.contemTexto("CPF/CNPJ Proprietário"));
    }

    @Test
    public void consultandoCPFProprietarioInvalido(){

        criarAtendimento.CPFProprietario("123456");
        criarAtendimento.incluir();
        criarAtendimento.confirmSwal();
        Assert.assertTrue(criarAtendimento.contemTexto("CPF Inválido"));
    }

    @Test
    public void consultandoCPFProprietarioValido(){

        criarAtendimento.CPFProprietario("16776548722");
        criarAtendimento.incluir();
        Assert.assertTrue(criarAtendimento.contemTexto("Informações do Proprietário"));
    }

    @Test
    public void consultandoCPFInteressadoInvalido(){
        criarAtendimento.CPFInteressado("654321");
        criarAtendimento.incluir();
        criarAtendimento.confirmSwal();
        Assert.assertTrue(criarAtendimento.contemTexto("CPF Inválido"));
    }
}
