package EvaDigitalPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmplacamentoDigitalPage extends PageObject {

    private static final String URL = "http://localhost:8080/eva/primeiroEmplacamentoDigital/emplacamentoDigital";

    public EmplacamentoDigitalPage(WebDriver browser) {
        super(browser);
    }

    public EmplacamentoDigitalPage carregarFormulario() {
        this.driver.navigate().to(URL);
        return new EmplacamentoDigitalPage(driver);
    }

    public boolean isPageEmplacamentoDigital() {
        return driver.getCurrentUrl().equals(URL);
    }

    public void escrever(By by, String texto){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public void clicarBotao(String id) {
        driver.findElement(By.id(id)).click();
    }
}
