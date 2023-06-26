package VivaPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuporteVistoriaPage extends PageObject {

    private static final String URL_SUPORTE = "https://hompa.eva.inf.br/viva/suporte/suporteViva";


    public SuporteVistoriaPage(WebDriver browser)  {
        super(browser);

    }

    public SuporteVistoriaPage carregarSuporte()  {
        this.driver.navigate().to(URL_SUPORTE);
        return new SuporteVistoriaPage(driver);
    }

    public boolean isPageSuporteViva() {
        return driver.getCurrentUrl().equals(URL_SUPORTE);
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource().contains(texto);
    }

    public void consultaVistoria(String vistoria) {
        driver.findElement(By.id("searchEva")).sendKeys(vistoria);
        driver.findElement(By.id("searchAttendance")).click();
    }

    public boolean isInputsVistoria(String valor, String lacre, String numLaudo, String anoLaudo, String anoFabricacao,
                                    String anoModelo, String numMotor, String numCambio, String tipoCarroceria, String cmt) {

        driver.findElement(By.id("lock-close-os")).click();

        WebElement inputValor = this.driver.findElement(By.xpath("//input[@id='valor']"));
        WebElement inputLacre = this.driver.findElement(By.id("numLaudoVtr"));
        WebElement inputNumLaudo = this.driver.findElement(By.id("numLaudoVtr"));
        WebElement inputAnoLaudo = this.driver.findElement(By.id("anoLaudoVtr"));
        WebElement inputAnoFabVeiculo = this.driver.findElement(By.id("anoFabVeiculoVtr"));
        WebElement inputAnoModVeiculo = this.driver.findElement(By.id("anoModVeiculoVtr"));
        WebElement inputNumMotor = this.driver.findElement(By.id("numeroMotorVtr"));
        WebElement inputNumCambio = this.driver.findElement(By.id("numeroCaixaCambioVtr"));
        WebElement inputTipoCarroceria = this.driver.findElement(By.id("especieTipoCarroceriaVtr"));
        WebElement inputCmt = this.driver.findElement(By.id("cmtVtr"));

        driver.findElement(By.id("lock-open-os")).click();

        System.out.println(inputValor.getText());


        return inputValor.getText().equals(valor)&& inputLacre.getText().equals(lacre)
                && inputNumLaudo.getText().equals(numLaudo) && inputAnoLaudo.getText().equals(anoLaudo)
                && inputAnoFabVeiculo.getText().equals(anoFabricacao) && inputAnoModVeiculo.getText().equals(anoModelo)
                && inputNumMotor.getText().equals(numMotor) && inputNumCambio.getText().equals(numCambio)
                && inputTipoCarroceria.getText().equals(tipoCarroceria) && inputCmt.getText().equals(cmt);
    }

    public void isInputProprietario(String nome, String cpf, String email, String telefone) {

        driver.findElement(By.id("lock-close-prop")).click();
        driver.findElement(By.id("nomeProprietario")).sendKeys(nome);
        driver.findElement(By.id("cpfcnpj")).sendKeys(cpf);
        driver.findElement(By.id("emailProprietario")).sendKeys(email);
        driver.findElement(By.id("telefone")).sendKeys(telefone);
        driver.findElement(By.id("lock-open-prop")).click();
    }

    public boolean isValidarProprietario(String nome, String cpf, String email, String telefone) {

        //driver.findElement(By.id("lock-close-prop")).click();
        WebElement inputNome =  this.driver.findElement(By.id("nomeProprietario"));
        WebElement inputCpf =  this.driver.findElement(By.id("cpfcnpj"));
        WebElement inputEmail =  this.driver.findElement(By.id("emailProprietario"));
        WebElement inputTelefone =  this.driver.findElement(By.id("telefone"));
        //driver.findElement(By.id("lock-open-prop")).click();

        return inputNome.getText().equals(nome) && inputCpf.getText().equals(cpf)
                && inputEmail.getText().equals(email) && inputTelefone.getText().equals(telefone);
    }

    public boolean isInputsVeiculo(String descricao, String chassi, String categoria, String renavam,String tipoVeiculo, String nomeCondutor, String cpfCondutor) {

        driver.findElement(By.id("lock-close-veic")).click();
        //driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();

        WebElement cardVeiculo = this.driver.findElement(By.id("card-veic"));
        WebElement inputDescricao = cardVeiculo.findElement(By.id("descMarcaModelo"));
        WebElement inputChassi = cardVeiculo.findElement(By.id("chassi"));
        WebElement inputCategoria = cardVeiculo.findElement(By.id("categoriaVeiculo"));
        WebElement inputRenavam = cardVeiculo.findElement(By.id("renavam"));
        WebElement inputTipoVeiculo = cardVeiculo.findElement(By.id("moto"));
        WebElement inputNomeCondutor = cardVeiculo.findElement(By.id("nomeEntrega"));
        WebElement inputCpfCondutor = cardVeiculo.findElement(By.id("cpfEntrega"));

        driver.findElement(By.id("lock-open-veic")).click();

        return inputDescricao.getText().equals(descricao) && inputChassi.getText().equals(chassi)
                && inputCategoria.getText().equals(categoria) && inputRenavam.getText().equals(renavam)
                && inputTipoVeiculo.getText().equals(tipoVeiculo) && inputNomeCondutor.getText().equals(nomeCondutor)
                && inputCpfCondutor.getText().equals(cpfCondutor);
    }

}
