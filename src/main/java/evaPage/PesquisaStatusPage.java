package evaPage;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PesquisaStatusPage extends PageObject {

    private static final String URL_PESQUISA_STATUS = "http://localhost:8080/eva/administrativo/pesquisaStatus";


    public PesquisaStatusPage(WebDriver browser){
        super(browser);

    }

    public PesquisaStatusPage carregarFormulario() {
        this.driver.navigate().to(URL_PESQUISA_STATUS);
        return new PesquisaStatusPage(driver);
    }

    public boolean isRetornoConsulta(String placa, String nomeDaLoja, String cnpj, String dataDeEntrada, String estadoDaAutorizacao) {
        WebElement linhaDaTabela = this.driver.findElement(By.id("table_wrapper"));
        WebElement colunaPlaca = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaNomeDaLoja = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaCnpj = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        WebElement colunaDataDeEntrada = linhaDaTabela.findElement(By.cssSelector("td:nth-child(4)"));
        WebElement colunaEstadoDaAutorizacao = linhaDaTabela.findElement(By.cssSelector("td:nth-child(5)"));

        return colunaPlaca.getText().equals(placa)
        && colunaNomeDaLoja.getText().equals(nomeDaLoja)
        && colunaCnpj.getText().equals(cnpj)
        && colunaDataDeEntrada.getText().equals(dataDeEntrada)
        && colunaEstadoDaAutorizacao.getText().equals(estadoDaAutorizacao);

    }


    public void consultaStatusPlaca(String placa) {
        driver.findElement(By.id("busca")).sendKeys(placa);
        driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
    }

    public void swalConfirmacao() {
        driver.findElement(By.xpath("//button[@class = 'swal2-cancel swal2-styled']")).click();
    }

    public void copiarTexto(){
        driver.findElement(By.xpath("//button[@class = 'swal2-confirm swal2-styled']")).click();
        driver.findElement(By.xpath("//button[@class = 'swal2-confirm swal2-styled']")).click();
    }

    public void swalLojaNaoEncotrada(){
        driver.findElement(By.xpath("//button[@class = 'swal2-confirm swal2-styled']")).click();
    }

    public boolean isPagePesquisaStatus() {
        return driver.getCurrentUrl().equals(URL_PESQUISA_STATUS);
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource().contains(texto);
    }

}
