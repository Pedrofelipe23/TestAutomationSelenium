package VivaPage;

import PageObject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GerenciarPagamentosVistoriaPage extends PageObject {

    private static final String URL_PAGAMENTOS = "http://localhost:8080/eva/vistoria/gerenciarPagamentosVistoria";

    public GerenciarPagamentosVistoriaPage(WebDriver driver) {
        super(driver);
    }

    public GerenciarPagamentosVistoriaPage carregaPagePagamento() {
        this.driver.navigate().to(URL_PAGAMENTOS);
        return new GerenciarPagamentosVistoriaPage(driver);
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource().contains(texto);
    }

    public void consultaVistoria(String placa)  {

        driver.findElement(By.xpath("//*[@id=\"table_filter\"]/label/input")).sendKeys(placa);
    }

    public boolean isValidaDadosConsultaVistoria(String chassi, String placa, String proprietario, String vencimento, String valor, String venda) {

        WebElement colunaChassi = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[2]"));
        WebElement colunaPlaca = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[3]"));
        WebElement colunaProprietario = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[4]"));
        WebElement colunaVencimento = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[5]"));
        WebElement colunaValor = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[6]"));
        WebElement colunaVenda = this.driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[7]"));

        System.out.println(colunaChassi.getText());
        System.out.println(colunaPlaca.getText());
        System.out.println(colunaProprietario.getText());
        System.out.println(colunaVencimento.getText());
        System.out.println(colunaValor.getText());
        System.out.println(colunaVenda.getText());

        return colunaChassi.getText().equals(chassi)
                && colunaPlaca.getText().equals(placa)
                && colunaProprietario.getText().equals(proprietario)
                && colunaVencimento.getText().equals(vencimento)
                && colunaValor.getText().equals(valor)
                && colunaVenda.getText().equals(venda);
    }

    public void visulizaPixQrcode(){

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[2]/td[8]/div/button")).click(); //dropdown escolha opção
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[2]/td[8]/div/ul/li[1]/a")).click(); // visualizar pix
    }

}
