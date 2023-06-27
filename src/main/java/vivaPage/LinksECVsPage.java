package vivaPage;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksECVsPage extends PageObject {

    private static final String URL_ECV = "http://localhost:8080/eva/vistoria/linksECV";

    public LinksECVsPage(WebDriver driver) {
        super(driver);
    }

    public LinksECVsPage carregaPagePagamento() {
        this.driver.navigate().to(URL_ECV);
        return new LinksECVsPage(driver);
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource().contains(texto);
    }

    public void cadastraNewECV(String nome, String link) {

        driver.findElement(By.xpath("//html/body/div/div/div/div[2]/div/button")).click();
        driver.findElement(By.id("nome")).sendKeys(nome);
        driver.findElement(By.id("linkECV")).sendKeys(link);
        driver.findElement(By.xpath("//*[@id=\"modalECV\"]/div/div/div[3]/button")).click();
        driver.findElement(By.xpath("//html/body/div[2]/div/div[10]/button[1]")).click();

        System.out.println("Cadastrei nova ECV:");
        System.out.println(nome);
        System.out.println(link);
    }

    public boolean isValidaDadosCadastrados(String nome, String link) {

        WebElement colunaNome = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[1]/div/span"));
        WebElement colunaLink = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[2]/div/span"));

        System.out.println();
        System.out.println("Validando Dados:");
        System.out.println(colunaNome.getText());
        System.out.println(colunaLink.getText());

        return colunaNome.getText().equals(nome) && colunaLink.getText().equals(link);
    }

    public void editaNomeLink(String newNome, String newLink){

        driver.findElement(By.xpath("//*[@id=\"2f046253-5147-4298-b816-06a1092c2ad6\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"2f046253-5147-4298-b816-06a1092c2ad6\"]/div/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"swal-input1\"]")).sendKeys(newNome);
        driver.findElement(By.xpath("//*[@id=\"swal-input2\"]")).sendKeys(newLink);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[10]/button[1]")).click();
    }


    public void habilitaEdesabilitaCamera() {

        driver.findElement(By.xpath("//*[@id=\"e796c39c-f22a-4b1c-816c-28687ae4177f\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"e796c39c-f22a-4b1c-816c-28687ae4177f\"]/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//html/body/div[2]/div/div[10]/button[1]")).click();
        driver.findElement(By.xpath("//html/body/div[2]/div/div[10]/button[1]")).click();
    }

    public void excluirCamera() {

        driver.findElement(By.xpath("//*[@id=\"ad969c34-4179-4482-81d1-c22b488a9c1f\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"ad969c34-4179-4482-81d1-c22b488a9c1f\"]/div/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//html/body/div[2]/div/div[10]/button[1]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[10]/button[1]")).click();
    }
}
