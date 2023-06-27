package vivaPage;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VistoriasPage extends PageObject {

    private static final String URL_VISTORIAS = "http://mt.vivabr.com.br/viva/vistoria/minhasVistorias";

    public VistoriasPage(WebDriver driver) {
        super(driver);
    }

    public VistoriasPage carregarPage() {
        this.driver.navigate().to(URL_VISTORIAS);
        return new VistoriasPage(driver);
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource().contains(texto);
    }

    public void consultaVistoria() {

        try{

            driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[8]/div/button")).click();
            driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[8]/div/ul/li/a")).click();

            WebElement blockchain = driver.findElement(By.xpath("//*[@id=\"buttonblockChain\"]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", blockchain);
            Thread.sleep(500);
            blockchain.click();

        }catch (InterruptedException e){
            System.out.println("Erro do scroll " + e.getMessage());
        }
    }

    public boolean isValidaBlockchain(String proprietario, String condutor) {

        WebElement colunaProprietario = this.driver.findElement(By.xpath("//*[@id=\"modalBodyTr\"]"));
        WebElement colunaCondutor = this.driver.findElement(By.xpath("//*[@id=\"modalBodyTr\"]/tr[1]/td[1]/div/div[2]/div[1]"));

        driver.findElement(By.xpath("//*[@id=\"modalBlockChain\"]/div/div/div[3]/button")).click();

        System.out.println(proprietario);
        System.out.println(condutor);

        return colunaProprietario.getText().equals(proprietario) && colunaCondutor.getText().equals(condutor);
    }
}
