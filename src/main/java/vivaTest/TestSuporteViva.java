package vivaTest;

import core.LoginPage;
import vivaPage.SuporteVistoriaPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSuporteViva {

    private SuporteVistoriaPage suporte;


    @BeforeEach
    public void beforeEach()  {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.autorizarHttps();
        paginaDeLogin.preencherFormularioDeLogin("ygor.vidal", "1234");
        this.suporte = paginaDeLogin.efetuaLoginSuporte();
        this.suporte = suporte.carregarSuporte();
    }

    @AfterEach
    public void aftereEach() {
        this.suporte.fecharDriver();
    }


    @Test
    public void cardVistoria() {

        suporte.consultaVistoria("HNM9G62");

        String Valor = "10";
        String lacre = "009879515";
        String numLaudo = "2508";
        String anoLaudo = "2023";
        String anoFabricacao = "2022";
        String anoModelo = "2022";
        String numMotor = "DWDB00011";
        String numCambio = "830510W0099022";
        String tipoCarroceria = "Passageiro";
        String cmt = "1.4";

        Assert.assertTrue(suporte.isPageSuporteViva());
        Assert.assertTrue(suporte.contemTexto("VISTORIA"));
        Assert.assertFalse(suporte.isInputsVistoria(Valor,lacre,numLaudo,anoLaudo,anoFabricacao,anoModelo,numMotor,numCambio,tipoCarroceria,cmt));

    }

    @Test
    public void cardProprietario() {

        suporte.consultaVistoria("HNM9G62");

        String nome = "SANDRA LINS";
        String cpf = "88496562700";
        String email = "wj@wj.com.br";
        String telefone = "21999999999";

        suporte.isInputProprietario(nome,cpf,email,telefone);
        Assert.assertTrue(suporte.contemTexto("PROPRIETÁRIO"));
        Assert.assertFalse(suporte.isValidarProprietario(nome, cpf, email, telefone));
    }

    @Test
    public void cardVeiculo() {

        suporte.consultaVistoria("HNM9G62");

        String descricao = "VW/ VOYAGE 1.0 MPI (FLEX)/ PRETO";
        String chassi = "4NFFR41H4UUDX6787";
        String categoria = "PARTICULAR / PRETO";
        String renavam = "02659362518";
        String tipoVeiculo = "CARRO";
        String nomeCondutor = "FABIO SANTOS";
        String cpfCondutor = "16776548722";

        Assert.assertTrue(suporte.contemTexto("VEÍCULO"));
        Assert.assertFalse(suporte.isInputsVeiculo(descricao, chassi, categoria, renavam, tipoVeiculo, nomeCondutor, cpfCondutor));
    }


}
