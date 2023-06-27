package vivaPage;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GerenciarModeloNFPage extends PageObject {

    private static final String URL_MODELONF = "http://localhost:8080/eva/vistoria/gerenciarModeloNF";

    public GerenciarModeloNFPage(WebDriver driver) {
        super(driver);
    }

    public GerenciarModeloNFPage carregaPaginaGerenciarModeloNF() {
        this.driver.navigate().to(URL_MODELONF);
        return new GerenciarModeloNFPage(driver);
    }

    public boolean contemTexto(String texto) {
        System.out.println(texto);
        return driver.getPageSource().contains(texto);
    }

    public void concluirEdicaoDeModelo(){

        try{
            driver.findElement(By.id("criarModelo")).click();
            Thread.sleep(2000);
        }catch(InterruptedException  ex){
            System.out.println(ex.getMessage());
        }
    }

    public void consultaCEP(String cep) {

        try{
            driver.findElement(By.id("cepPrestador")).clear();
            driver.findElement(By.id("cepPrestador")).sendKeys(cep);
            System.out.println("Consultando CEP: " + cep);

            Thread.sleep(2000);
        }catch(InterruptedException  ex){
            System.out.println(ex.getMessage());
        }
    }

    public void cadastrarEmail(String email) {

        driver.findElement(By.id("emailPrestador")).clear();
        driver.findElement(By.id("emailPrestador")).sendKeys(email);
        System.out.println("Cadastrando EMAIL: " + email);
    }

    public void cadastrarTelefone(String telefone) {

        driver.findElement(By.id("telefonePrestador")).clear();
        driver.findElement(By.id("telefonePrestador")).sendKeys(telefone);
        System.out.println("Cadastrando TELEFONE: " + telefone);
    }

    public void swalConfirm(){
        try{
            driver.findElement(By.xpath("/html/body/div/div/div[10]/button[1]")).click();

            Thread.sleep(2000);
        }catch(InterruptedException  ex){
            System.out.println(ex.getMessage());
        }
    }
}
