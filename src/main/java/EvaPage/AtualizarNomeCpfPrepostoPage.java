package EvaPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AtualizarNomeCpfPrepostoPage extends PageObject {

    private static final String URL = "http://localhost:8080/eva/atendimentoExtended2/atualizarNomeCpfPreposto";

    public AtualizarNomeCpfPrepostoPage(WebDriver browser) {
        super(browser);
    }

    public AtualizarNomeCpfPrepostoPage carregarFormulario() {
        this.driver.navigate().to(URL);
        return new AtualizarNomeCpfPrepostoPage(driver);
    }

    public void escrever(By by, String texto){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }

    public boolean isPageAtualizarNomeCpfPreposto() {
        System.out.println(URL);
        return driver.getCurrentUrl().equals(URL);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public void clickButtonXpath(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).click();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Erro de timeout para click no button" + e.getMessage());
        }
    }

    public void clicarBotao(String id) {
        driver.findElement(By.id(id)).click();
    }

}
