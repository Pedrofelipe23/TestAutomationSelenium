package core;

import evaPage.*;
import vivaPage.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {

    private static final String URL_LOGIN = "http://localhost:8080/eva/login/auth";

    public LoginPage() {
        super(null);
        this.driver.navigate().to(URL_LOGIN);
    }

    public void preencherFormularioDeLogin(String username, String password) {
        driver.findElement(By.id("j_username")).sendKeys(username);
        driver.findElement(By.id("j_password")).sendKeys(password);
    }

    public void efetuaLogin() {
        driver.findElement(By.id("sendEmail")).submit();
    }

    public void autorizarHttps() {
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
    }

    public String getNomeUsuarioLogado() {
        try {
            return driver.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

//*************** Telas Projeto Eva ***************

    public PesquisaStatusPage efetuaLoginPesquisaStatus() {
        efetuaLogin();
        return new PesquisaStatusPage(driver);
    }

    public EstampagensFeitasNewPage efetuaLoginEstampagens() {
        efetuaLogin();
        return new EstampagensFeitasNewPage(driver);
    }

    public ConciliacaoPage efetuaLoginConciliacao() {
        efetuaLogin();
        return new ConciliacaoPage(driver);
    }

    public NfeAgerarEvaPage efetuaLoginNfe() {
        efetuaLogin();
        return new NfeAgerarEvaPage(driver);
    }

    public IncluirProtocolosLocadoraPage efetuaLoginIncluirProtocolosLocadora() {
        efetuaLogin();
        return new IncluirProtocolosLocadoraPage(driver);
    }

    public EnviarAutorizacaoDetranMultPage efetuarLoginEnviarAutorizacaoDetranMulti(){
        efetuaLogin();
        return new EnviarAutorizacaoDetranMultPage(driver);
    }

    public UpdateCertificatePage efetuaLoginUpdateCertificate() {
        efetuaLogin();
        return new UpdateCertificatePage(driver);
    }

    public CriarAtendimentoCEMixedPage efetuaLoginCriarAtendimentoCEMixed() {
        efetuaLogin();
        return new CriarAtendimentoCEMixedPage(driver);
    }

    public AtualizarNomeCpfPrepostoPage efetuaLoginAtualizarNomeCpfPreposto() {
        efetuaLogin();
        return new AtualizarNomeCpfPrepostoPage(driver);
    }

    public void efetuarLoginPedidosDevolucaoFabricas() {
        efetuaLogin();
        driver.navigate().to("http://localhost:8080/eva/devolucaoBlank/pedidosDevolucaoFabricas");
    }



//*************** Telas Projeto ViVA ***************

    public CriarAtendimentov2Page efetuaLoginv2() {
        efetuaLogin();
        return new CriarAtendimentov2Page(driver);
    }

    public SuporteVistoriaPage efetuaLoginSuporte() {
        efetuaLogin();
        return new SuporteVistoriaPage(driver);
    }

    public AgendamentosVistoriaPage efetuaLogin2() {
        efetuaLogin();
        return new AgendamentosVistoriaPage(driver);
    }

    public GerenciarPagamentosVistoriaPage efetuaLoginPagamentos() {
        efetuaLogin();
        return new GerenciarPagamentosVistoriaPage(driver);
    }

    public LinksECVsPage efetuaLoginECV() {
        efetuaLogin();
        return new LinksECVsPage(driver);
    }

    public LinksBoroscopioPage efetuaLoginBoroscopio() {
        efetuaLogin();
        return new LinksBoroscopioPage(driver);
    }

    public VistoriasPage efetuaLoginVistorias() {
        efetuaLogin();
        return new VistoriasPage(driver);
    }

    public MesaSuportePage efetuaLoginMesaSuporte() {
        efetuaLogin();
        return new MesaSuportePage(driver);
    }

    public GerenciarModeloNFPage efetuaLoginGerenciarModeloNF() {
        efetuaLogin();
        return new GerenciarModeloNFPage(driver);
    }

    public EnviaVistoriaDetranPage efetuaLoginEnviaVistoriaDetran() {
        efetuaLogin();
        return new EnviaVistoriaDetranPage(driver);
    }

    public UploadArquivosECVPage efetuarLoginUploadArquivosECV(){
        efetuaLogin();
        return new UploadArquivosECVPage(driver);
    }

    public void efetuarLoginMudarLocalInstalacao() {
        efetuaLogin();
        driver.navigate().to("http://localhost:8080/eva/vistoria/mudarLocalInstalacao");
    }


//*************** Telas Projeto EvaDigital ***************
    public void efetuaLoginEmplacamentoDigital() {
        efetuaLogin();
        driver.navigate().to("http://localhost:8080/eva/primeiroEmplacamentoDigital/emplacamentoDigital");
    }

    public void efetuaLoginEnderecoProprietario() {
        efetuaLogin();
        driver.navigate().to("http://localhost:8080/eva/primeiroEmplacamentoDigital/enderecoProprietario");
    }
}
