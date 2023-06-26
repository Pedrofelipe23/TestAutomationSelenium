package VivaPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksBoroscopioPage extends PageObject {

    private static final String URL_BOROSCOPIO = "http://localhost:8080/eva/vistoria/linksBoroscopio";

    public LinksBoroscopioPage(WebDriver driver) {
        super(driver);
    }

    public LinksBoroscopioPage carregaPaginaLinksBoroscopio() {
        this.driver.navigate().to(URL_BOROSCOPIO);
        return new LinksBoroscopioPage(driver);
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource().contains(texto);
    }

    public void cadastraNewBoroscopio(String nome, String link) {

        driver.findElement(By.xpath("//html/body/div/div/div/div[2]/div/button")).click();
        driver.findElement(By.id("nome")).sendKeys(nome);
        driver.findElement(By.id("linkBoroscopio")).sendKeys(link);
        driver.findElement(By.xpath("//*[@id=\"modalBoroscópio\"]/div/div/div[3]/button")).click();
        driver.findElement(By.xpath("//html/body/div[2]/div/div[10]/button[1]")).click();

        System.out.println("Cadastrou novo Boroscópio:");
        System.out.println(nome);
        System.out.println(link);
    }

    public boolean isValidaDadosBoroscopio(String nome, String link) {

        WebElement colunaNome = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[2]/td[1]/div/span"));
        WebElement colunaLink = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[2]/td[2]/div/span"));

        System.out.println();
        System.out.println("Validando Dados do Novo Boroscópio:");
        System.out.println(colunaNome.getText());
        System.out.println(colunaLink.getText());

        return colunaNome.getText().equals(nome) && colunaLink.getText().equals(link);
    }

    public void editaBoroscopioLink(String newNome, String newLink){

        driver.findElement(By.xpath("//*[@id=\"0a0800e0-f7f4-4838-a93f-46bd9a9e7541\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"0a0800e0-f7f4-4838-a93f-46bd9a9e7541\"]/div/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"swal-input1\"]")).sendKeys(newNome);
        driver.findElement(By.xpath("//*[@id=\"swal-input2\"]")).sendKeys(newLink);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[10]/button[1]")).click();
    }

    public void habilitaEdesabilitaBoroscopio() {

        driver.findElement(By.xpath("//*[@id=\"c72d4bcd-c7b1-49c5-ab3d-cbc9fa9faa63\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"c72d4bcd-c7b1-49c5-ab3d-cbc9fa9faa63\"]/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//html/body/div[2]/div/div[10]/button[1]")).click();
        driver.findElement(By.xpath("//html/body/div[2]/div/div[10]/button[1]")).click();
    }

    public void excluirBoroscopio() {

        driver.findElement(By.xpath("//*[@id=\"9fdb1dee-0c02-4ab3-801c-db67cd2db859\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"9fdb1dee-0c02-4ab3-801c-db67cd2db859\"]/div/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//html/body/div[2]/div/div[10]/button[1]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[10]/button[1]")).click();
    }


}
