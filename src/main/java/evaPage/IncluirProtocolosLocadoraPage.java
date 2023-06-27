package evaPage;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class IncluirProtocolosLocadoraPage extends PageObject{
    private static final String URL = "http://localhost:8080/eva/processoExterno/incluirProtocolosLocadora";

    public IncluirProtocolosLocadoraPage(WebDriver browser) {
        super(browser);
    }

    public IncluirProtocolosLocadoraPage carregarFormulario() {
        this.driver.navigate().to(URL);
        return new IncluirProtocolosLocadoraPage(driver);
    }

    public boolean isPageIncluirProtocolosLocadora() {
        return driver.getCurrentUrl().equals(URL);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public void campoDescricao(String texto) {
        driver.findElement(By.id("descricao")).sendKeys(texto);
    }

    public void buttonIncluir(){
        driver.findElement(By.id("include")).click();
    }

    public void swalComfirm() {
        driver.findElement(By.xpath("//html/body/div[3]/div/div[10]/button[1]")).click();
    }

    public void campoChaveDeAcesso(String nNota) {
        driver.findElement(By.id("nNota")).sendKeys(nNota);
    }

    public void buttonConfirmarCriacao() {
        driver.findElement(By.id("confirmCreate")).click();
    }

    public void anexarArquivo() {

        //UPLOAD ARQUIVO
        driver.findElement(By.xpath("//*[@id=\"csvFile\"]")).sendKeys("C:"+ File.separator+"Users"
                + File.separator+"Pedro" +File.separator+"OneDrive"+File.separator+"Área de Trabalho" +File.separator+"Teste-protocolo.xlsx");
    }
}
