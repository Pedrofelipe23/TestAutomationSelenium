package EvaPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NfeAgerarEvaPage extends PageObject {

    private static final String URL_NFE = "http://localhost:8080/eva/atendimento/nfeAgerarEva";

    public NfeAgerarEvaPage(WebDriver driver) {
        super(driver);
    }

    public NfeAgerarEvaPage carregarFormulario() {
        this.driver.navigate().to(URL_NFE);
        return new NfeAgerarEvaPage(driver);
    }

    public boolean isPageConciliacaoPage() {
        return driver.getCurrentUrl().equals(URL_NFE);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public void consutaNfe() {

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[7]/span[1]")).click();
    }

    public void textAreaNfe(String texto){

        driver.findElement(By.xpath("//*[@id=\"obsNF\"]")).sendKeys(texto);
        driver.findElement(By.xpath("//*[@id=\"modalCompletaInfo\"]/div/div/div[3]/button[2]")).click();
        driver.findElement(By.xpath("//html/body/div[4]/div/div[10]/button[1]")).click();
    }
}
