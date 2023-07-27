package vivaTest;

import core.Components;
import core.LoginPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CriarAtendimentoVistoriaWSTest {

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencherFormularioDeLogin("matheusmws","1234");
        paginaDeLogin.efetuaLoginCriarAtendimentoVistoriaWS();
    }

    @AfterEach
    public void aftereEach(){
        Components.captureScreenshot("C:\\TestePedro\\TestAutomation\\target\\screenshot\\"+"CriarAtendimentoVistoriaWS");
        //Components.fecharDriver();
    }

    @Test
    public void verificarUrlHompa(){

        Assert.assertTrue(Components.isPage("http://hompa.eva.inf.br/viva/vistoria/criarAtendimentoVistoriaWS"));
    }

    @Test
    public void criandoVistoriaValidaComProcuracao(){
        //Consultar Intgração
        Assert.assertTrue(Components.contemTexto("Consultar Integração"));
        Components.escrever(By.id("chassi"),"9BRBY3BE4P4039374"); //chassi
        Components.escrever(By.id("numLaudo"),"123456"); //num_laudo

        //Informações do Veículo
        Assert.assertTrue(Components.contemTexto("Informações do Veículo"));
        Components.escrever(By.id("placa"),"QCG8E53"); //placa
        Components.escrever(By.id("descMarcaModelo"),"TOYOTA/COROLLA APREMIUMH/BRANCA"); //marca/modelo/cor
        Components.escrever(By.id("numeroCRV"),"1234"); //numeroCRV
        Components.escrever(By.id("renavam"),"1319889023"); //renavam
        Components.escrever(By.id("rntrc"),"1234"); //rntcr
        Components.escrever(By.id("combustivel"),"ALCOOL-GASOL"); //combustivel
        Components.escrever(By.id("numMotor"),"KD08E1G451101"); //n do motor
        Components.escrever(By.id("cmt"),"1324"); //cap. maxima tração
        Components.escrever(By.id("anoFab"),"2020"); //ano fabricaçao
        Components.escrever(By.id("anoModelo"),"2020"); //ano modelo
        Components.escrever(By.id("cilindradas"),"20000"); //cilindradas
        Components.escrever(By.id("lotacao"),"1"); //lotacao
        Components.escrever(By.id("ccpe"),"0.00"); //cap. carga/potencia/eixo
        Components.escrever(By.id("categoria"),"passeio"); //categoria
        Components.escrever(By.id("pbt"),"10"); //pbt
        Components.escrever(By.id("etc"),"PASSAGEIRO/MOTOCICLETA/NENHUMA"); //especie/tipo/carroceria
        Components.escrever(By.id("observacoes"),"teste"); //observações
        Components.forceWait();

        //Informações do Proprietário
        Assert.assertTrue(Components.contemTexto("Informações do Proprietário"));
        Components.escrever(By.id("cep1"),"22783113"); //CEP
        Components.forceWait();
        Components.escrever(By.id("nomeProp"),"PEDRO TESTE PROPRIETARIO"); //nome proprietario
        Components.escrever(By.id("cpfp2"),"25242556000115"); //cpf/cnpj
        Components.forceWait();
        Components.escrever(By.id("email"),"pedrofelipee23@gmail.com"); //e-mail
        Components.escrever(By.id("telefone"),"21999999999"); //telefone

        //Informações Gerais
        Assert.assertTrue(Components.contemTexto("Informações Gerais"));
        Components.escrever(By.id("valorAtend"),"20000"); //valor

        //Informações da Procuração
        Assert.assertTrue(Components.contemTexto("Informações da Procuração"));
        //Components.escrever(By.id("cpfterceiro"),"16776548722"); //CPF interessado
        //Components.escrever(By.id("nomeTerceiro"),"PEDRO TESTE PROCURACAO"); //nome interessado
        //Components.escrever(By.id("emailProcuracao"),"pedropereira.wj@gmail.com"); //email interessado
        //Components.forceWait();

        //Incluir
        Components.clicarBotao(By.id("incluir2"));



    }
}