package vivaPage;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CriarAtendimentov2Page extends PageObject {

    //private static final String URL_CRIARATENDIMENTO = "http://mt.vivabr.com.br/viva/vistoria/criarAtendimentoVistoriav2";
    private static final String URL_CRIARATENDIMENTO = "http://localhost:8080/eva/vistoria/criarAtendimentoVistoriav2";

    public CriarAtendimentov2Page(WebDriver driver) {
        super(driver);

    }

    public CriarAtendimentov2Page carregarPage() {
        this.driver.navigate().to(URL_CRIARATENDIMENTO);
        return new CriarAtendimentov2Page(driver);
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource().contains(texto);
    }

    public void consultarIntegracao(String placa, String cpfInteressado, String cpfVistoriador) {

        driver.findElement(By.id("placa")).sendKeys(placa);
        driver.findElement(By.id("cpfInteressado")).sendKeys(cpfInteressado);
        driver.findElement(By.id("cpfVistoriador")).sendKeys(cpfVistoriador);
        driver.findElement(By.id("incluir")).click();
    }

    public void informacoesProprietario(String valor, String cpfProprietario, String email, String telefone) {

        driver.findElement(By.id("valorAtend")).sendKeys(valor);
        driver.findElement(By.id("cpfp2")).sendKeys(cpfProprietario);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("telefone")).sendKeys(telefone);
    }

    public void informacoesContato(String cep, String numEndereco, String complemento, String municipio) {

        driver.findElement(By.id("cep1")).sendKeys(cep);
        driver.findElement(By.id("numero")).sendKeys(numEndereco);
        driver.findElement(By.id("complemento")).sendKeys(complemento);
        driver.findElement(By.id("municipio")).sendKeys(municipio);
        driver.findElement(By.xpath("//html/body/div/section[1]/main/form/div[2]/button[2]")).click();
        driver.findElement(By.xpath("//html/body/div/section[1]/main/form/div[2]/button[2]")).click();
    }

    public boolean isValidaConsultaDaIntegracao(String placa, String cpfInteressado, String cpfVistoriador) {

        WebElement inputPlaca = this.driver.findElement(By.id("placa"));
        WebElement inputCpfInteressado = this.driver.findElement(By.id("cpfInteressado"));
        WebElement inputCpfVistoriador = this.driver.findElement(By.id("cpfVistoriador"));

        System.out.println(placa);
        System.out.println(cpfInteressado);
        System.out.println(cpfVistoriador);

        return inputPlaca.getText().equals(placa) && inputCpfInteressado.getText().equals(cpfInteressado)
                && inputCpfVistoriador.getText().equals(cpfVistoriador);
    }

    public boolean isValidaInformacoesVeiculo(String marcaModeloCor, String chassi, String renavam, String valor) {

        WebElement inputMarcaModeloCor = this.driver.findElement(By.id("descMarcaModelo"));
        WebElement inputChassi = this.driver.findElement(By.id("chassi"));
        WebElement inputRenavam = this.driver.findElement(By.id("renavam"));
        WebElement inputValor = this.driver.findElement(By.id("valorAtend"));

        System.out.println(marcaModeloCor);
        System.out.println(chassi);
        System.out.println(renavam);
        System.out.println(valor);

        return inputMarcaModeloCor.getText().equals(marcaModeloCor) && inputChassi.getText().equals(chassi)
                && inputRenavam.getText().equals(renavam) && inputValor.getText().equals(valor);
    }

    public boolean isValidaAtendimento(String placa,String chassi,String valor,String proprietario,String terceiro){

        WebElement inputPlaca = this.driver.findElement(By.cssSelector("text-3xl font-semibold"));
        WebElement inputChassi = this.driver.findElement(By.cssSelector("ml-2 capitalize font-semibold"));
        WebElement inputValor = this.driver.findElement(By.cssSelector("ml-2 capitalize font-normal"));
        WebElement inputProprietario = this.driver.findElement(By.cssSelector("ml-2 capitalize font-semibold"));
        WebElement inputTerceiro = this.driver.findElement(By.cssSelector("ml-2 capitalize font-semibold"));

        System.out.println(placa);
        System.out.println(chassi);
        System.out.println(valor);
        System.out.println(proprietario);
        System.out.println(terceiro);

        return inputPlaca.getText().equals(placa) && inputChassi.getText().equals(chassi)
                && inputValor.getText().equals(valor) && inputProprietario.getText().equals(proprietario) && inputTerceiro.getText().equals(valor);
    }

    public void CPFIntegracao(String cpf) {
        driver.findElement(By.id("cpfInteressado")).sendKeys(cpf);
        System.out.println(cpf);
    }

    public void incluir(){
        driver.findElement(By.id("incluir")).click();
    }

    public void confirmSwal(){
        driver.findElement(By.xpath("//html/body/div[2]/div/div[10]/button[1]"));
        System.out.println("Swal - OK");
    }

    public void CPFProprietario(String cpfProprietario) {
        driver.findElement(By.id("cpfp2")).sendKeys(cpfProprietario);
        System.out.println(cpfProprietario);
    }

    public void CPFInteressado(String cpfInteressado) {
        driver.findElement(By.id("cpfterceiro")).sendKeys(cpfInteressado);
        System.out.println(cpfInteressado);
    }
}
