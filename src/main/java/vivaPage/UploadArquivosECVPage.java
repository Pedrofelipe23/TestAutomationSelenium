package vivaPage;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadArquivosECVPage extends PageObject {

    private static final String URL_ARQUIVOSECV = "http://localhost:8080/eva/vistoria/uploadArquivosECV";
    public UploadArquivosECVPage(WebDriver driver) {
        super(driver);
    }

    public UploadArquivosECVPage carregaPaginaUploadArquivosECV() {
        this.driver.navigate().to(URL_ARQUIVOSECV);
        return new UploadArquivosECVPage(driver);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public boolean isValidaDadosCnpjLoja(String cnpj, String loja) {

        WebElement colunaCnpj = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[1]"));
        WebElement colunaLoja = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[2]/span"));

        System.out.println();
        System.out.println("Validando Dados: ");
        System.out.println(colunaCnpj.getText());
        System.out.println(colunaLoja.getText());

        return colunaCnpj.getText().equals(cnpj) && colunaLoja.getText().equals(loja);
    }

    public void visualizaArquivos() {
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[3]/span")).click();
    }

    public void incluirPDFDocumento() {
        driver.findElement(By.id("btn")).click();
    }

    public void cadastrar() {
        driver.findElement(By.id("novoValorBot")).click();
    }
}
