package evaPage;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateCertificatePage extends PageObject {

    private static final String URL = "http://localhost:8080/eva/atendimentoPublico/updateCertificate";

    public UpdateCertificatePage(WebDriver browser) {
        super(browser);
    }

    public UpdateCertificatePage carregarFormulario() {
        this.driver.navigate().to(URL);
        return new UpdateCertificatePage(driver);
    }

    public boolean isPageUpdateCertificate() {
        return driver.getCurrentUrl().equals(URL);
    }

    public void clickButton(String id) {
        try {
            driver.findElement(By.id(id)).click();
            Thread.sleep(500);

        } catch (InterruptedException e) {
            System.out.println("Erro de timeout para click no button" + e.getMessage());
        }
    }

    public void anexaFile(String id) {
        String caminhoArquivo = "C:\\Users\\Pedro\\OneDrive\\Área de Trabalho\\10402862000102_prod.pfx";

        WebElement inputArquivo = driver.findElement(By.id(id));
        inputArquivo.sendKeys(caminhoArquivo);
    }

    public void escrever(By by, String texto){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

}
