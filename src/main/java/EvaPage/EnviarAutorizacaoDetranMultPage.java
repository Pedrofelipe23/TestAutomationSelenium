package EvaPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnviarAutorizacaoDetranMultPage extends PageObject {

    public static final String URL = "http://localhost:8080/eva/atendimentoExtended2/enviarAutorizacaoDetranMulti";

    public EnviarAutorizacaoDetranMultPage(WebDriver browser) {
        super(browser);
    }

    public EnviarAutorizacaoDetranMultPage carregarPage(){
        this.driver.navigate().to(URL);
        return new EnviarAutorizacaoDetranMultPage(driver);
    }

    public boolean isPageEnviarAutorizacaoDetranMult() {
        return driver.getCurrentUrl().equals(URL);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public void clickButton(String id){
        try {
            driver.findElement(By.id(id)).click();
            Thread.sleep(500);
        }catch (InterruptedException e){
            System.out.println("Erro de timeout para click no button" + e.getMessage());
        }

    }

    public void clickButtonXpath(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).click();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Erro de timeout para click no button" + e.getMessage());
        }
    }

    public void clickCheck(String id) {
        driver.findElement(By.id(id)).click();
    }

}
