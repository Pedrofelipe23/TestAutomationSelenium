package vivaTest;

import core.LoginPage;
import vivaPage.GerenciarPagamentosVistoriaPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GerenciarPagamentosVistoriaTest {

    private GerenciarPagamentosVistoriaPage pagamentos;


    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("Pedro.pereira","1234");
        this.pagamentos = paginaDeLogin.efetuaLoginPagamentos().carregaPagePagamento();
    }

    @AfterEach
    public void aftereEach(){
        this.pagamentos.fecharDriver();
    }

    @Test
    public void consultandoVistoriaPagamentos(){

        String placa = "PQG9F33";
        String chassi = "9C2KD0810FR428499 (NORMAL)";
        String proprietario = "VANDERLEI MARTINS FARIAS";
        String cpfProprietario = "021.856.747-22";
        String vencimento = "28/03/2023 16:18:03";
        String status = "Aguardando pagamento";
        String valor = "R$ 138,00";
        String venda = "28/03/2023";
        String hrvenda = "28/03/2023";

        pagamentos.consultaVistoria(placa);
        Assert.assertFalse(pagamentos.isValidaDadosConsultaVistoria(chassi,placa,proprietario,vencimento,valor,venda));
    }

    @Test
    public void visualizandoPix(){

        pagamentos.visulizaPixQrcode();

    }
}
