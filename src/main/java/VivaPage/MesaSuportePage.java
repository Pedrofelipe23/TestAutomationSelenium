package VivaPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MesaSuportePage extends PageObject {

    private static final String URL_MESASUPORTE = "http://localhost:8080/eva/suporte/mesaSuporte";

    public MesaSuportePage(WebDriver driver) {
        super(driver);
    }

    public MesaSuportePage carregaPaginaMesaSuporte() {
        this.driver.navigate().to(URL_MESASUPORTE);
        return new MesaSuportePage(driver);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public void consultaVistoria(String vistoria) {

        driver.findElement(By.xpath("//*[@id=\"searchVistoriaInput\"]")).sendKeys(vistoria);
        driver.findElement(By.xpath("//*[@id=\"btnSearchVistoria\"]")).click();
        System.out.println("Consultou a Vistoria: " + vistoria);
    }
}
