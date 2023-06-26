package VivaPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnviaVistoriaDetranPage extends PageObject {

    private static final String URL_ENVIADETRAN = "http://localhost:8080/eva/vistoria/enviaVistoriaDetran";

    public EnviaVistoriaDetranPage(WebDriver driver) {
        super(driver);
    }

    public EnviaVistoriaDetranPage carregaPaginaEnviaVistoriaDetran() {
        this.driver.navigate().to(URL_ENVIADETRAN);
        return new EnviaVistoriaDetranPage(driver);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public void enviaDetran() {
        try{
            driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[7]/div")).click();
            Thread.sleep(2000);
        }catch(InterruptedException  ex){
            System.out.println(ex.getMessage());
        }
    }

    public void swalConfirm(){
        driver.findElement(By.xpath("/html/body/div[3]/div/div[10]/button[1]"));
    }


    public void enviaDetranMultiplos() {
        try{
            driver.findElement(By.xpath("//*[@id=\"table_wrapper\"]/div[2]/div/div[1]/div/table/thead/tr/th[1]/div/button")).click();
            Thread.sleep(2000);
        }catch(InterruptedException  ex){
            System.out.println(ex.getMessage());
        }
    }

    public void allCheckBox() {
        try{
            driver.findElement(By.id("checkAll")).click();
            driver.findElement(By.xpath("//*[@id=\"477c3dc8-9291-48e2-8d2d-fd81e1e4630b\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"f0e11cde-1205-4b61-b6c3-953ec48c808d\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"2651575c-4be3-4e68-8187-0b43da85bfa0\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"32575e75-3482-4319-8d11-673e392fe48c\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"31b0f804-4404-442e-a956-c448a220b87c\"]")).click();
            Thread.sleep(2000);
        }catch(InterruptedException  ex){
            System.out.println(ex.getMessage());
        }
    }
}
