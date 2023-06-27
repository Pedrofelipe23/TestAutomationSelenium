package vivaPage;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AgendamentosVistoriaPage extends PageObject {

    private static final String URL_AGENDAMENTOS = "https://hompa.eva.inf.br/viva/vistoria/agendamentosVistoria";

    public AgendamentosVistoriaPage(WebDriver driver) {
        super(driver);
    }

    public AgendamentosVistoriaPage carregaPageAgendamentos() {
        this.driver.navigate().to(URL_AGENDAMENTOS);
        return new AgendamentosVistoriaPage(driver);
    }

    public boolean contemTexto(String texto) {
        return driver.getPageSource().contains(texto);
    }

    public void criarAgendamento(){

        driver.findElement(By.id("busca")).click();
        driver.findElement(By.xpath("//div[@id='css_moto']/button")).click();
        /*driver.findElement(By.id("id=hTA1")).click();
        driver.findElement(By.id("id=id=ui-active-item")).click();
        driver.findElement(By.id("id=hTA2")).click();
        driver.findElement(By.id("id=ui-active-item")).click();
        driver.findElement(By.id("id=tMA")).click();
        driver.findElement(By.id("id=ui-active-item")).click();
        driver.findElement(By.id("id=tP")).click();
        driver.findElement(By.id("id=tP")).sendKeys("10");
        driver.findElement(By.id("id=nextModal")).click();
        driver.findElement(By.id("id=tMA")).click();
        driver.findElement(By.id("xpath=//i[@onclick=\"showTimes('Thu Mar 23 2023 00:00:00 GMT-0300" +
                " (Horário Padrão de Brasília)','row0','0',row0,'totalSlots0','workingTime0')\"]")).click();
*/

    }


    public boolean isValidarDatasAgendamentos(String data, String totalVistorias, String hrsLivres, String hrsAgendados) {
        WebElement colunaData = this.driver.findElement(By.xpath("//table[@id='table']/tbody/tr[6]/td[2]"));
        WebElement colunaTotalVistorias = this.driver.findElement(By.xpath("//table[@id='table']/tbody/tr[6]/td[3]"));
        WebElement colunaHrsLivres = this.driver.findElement(By.xpath("//table[@id='table']/tbody/tr[6]/td[4]"));
        WebElement colunaHrsAgendados = this.driver.findElement(By.xpath("//table[@id='table']/tbody/tr[6]/td[5]"));

        System.out.println(colunaData.getText());
        System.out.println(colunaTotalVistorias.getText());
        System.out.println(colunaHrsLivres.getText());
        System.out.println(colunaHrsAgendados.getText());

        return colunaData.getText().equals(data)
                && colunaTotalVistorias.getText().equals(totalVistorias)
                && colunaHrsLivres.getText().equals(hrsLivres)
                && colunaHrsAgendados.getText().equals(hrsAgendados);

    }

    /*public boolean isDatasParaAgendamentos(String data, String totalVistorias, String hrsLivres, String hrsAgendados) {
        WebElement colunaData = this.driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/div/div[2]/div[2]/table/tbody/tr[6]/td[2]"));
        WebElement colunaTotalVistorias = this.driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/div/div[2]/div[2]/table/tbody/tr[6]/td[3]"));
        WebElement colunaHrsLivres = this.driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/div/div[2]/div[2]/table/tbody/tr[6]/td[4]"));
        WebElement colunaHrsAgendados = this.driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div[2]/div/div/div[2]/div[2]/table/tbody/tr[6]/td[5]"));

        System.out.println(colunaData.getText());
        System.out.println(colunaTotalVistorias.getText());
        System.out.println(colunaHrsLivres.getText());
        System.out.println(colunaHrsAgendados.getText());

        return colunaData.getText().equals(data)
                && colunaTotalVistorias.getText().equals(totalVistorias)
                && colunaHrsLivres.getText().equals(hrsLivres)
                && colunaHrsAgendados.getText().equals(hrsAgendados);

    }*/

}
