package EvaPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConciliacaoPage extends PageObject {

    private static final String URL_CONCILIACAO = "http://localhost:8080/eva/atendimento/cobranca";

    public ConciliacaoPage(WebDriver driver) {
        super(driver);
    }

    public ConciliacaoPage carregarFormulario() {
        this.driver.navigate().to(URL_CONCILIACAO);
        return new ConciliacaoPage(driver);
    }

    public boolean isPageConciliacaoPage() {
        return driver.getCurrentUrl().equals(URL_CONCILIACAO);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public void consultaPlacaConciliacao(String placa) {

        driver.findElement(By.xpath("//*[@id=\"table_filter\"]/label/input")).sendKeys(placa);
    }

    public boolean isValidaDadosAtendimento(String autDenatran, String placa,  String valor){

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[8]/span/i")).click();
        WebElement colunaAutDenatran = driver.findElement(By.xpath("//*[@id=\"autori\"]"));
        WebElement colunaPlaca = driver.findElement(By.xpath("//*[@id=\"placa1\"]"));
        WebElement colunaValor = driver.findElement(By.xpath("//*[@id=\"valor\"]"));

        return colunaAutDenatran.getText().equals(autDenatran) && colunaPlaca.getText().equals(placa) && colunaValor.getText().equals(valor);
    }
}
