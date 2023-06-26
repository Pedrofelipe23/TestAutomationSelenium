package EvaPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstampagensFeitasNewPage extends PageObject {

    private static final String URL_ESTAMPAGENS = "http://localhost:8080/eva/atendimento/estampagensfeitasNew";

    public EstampagensFeitasNewPage(WebDriver driver) {
        super(driver);
    }

    public EstampagensFeitasNewPage carregarFormulario() {
        this.driver.navigate().to(URL_ESTAMPAGENS);
        return new EstampagensFeitasNewPage(driver);
    }

    public boolean isPageEstampagensFeitasNew() {
        return driver.getCurrentUrl().equals(URL_ESTAMPAGENS);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public void consultaPlaca(String placa) {
        driver.findElement(By.xpath("//*[@id=\"table_filter\"]/label/input")).sendKeys(placa);
        System.out.println(placa);
    }
}
