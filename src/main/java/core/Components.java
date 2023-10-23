package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

import static core.LogManagement.*;

public class Components extends PageObject {

    public Components(WebDriver driver) {
        super(driver);
    }

    public static boolean isPage(String URL) {
        return driver.getCurrentUrl().equals(URL);
    }

    /********* TextField e TextArea ************/

    public static void escrever(By by, String texto){
        try {
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(texto);
            logInfo("Texto digitado no campo com sucesso: " + by +", value: "+ texto);
        }catch (Exception e){
            e.printStackTrace();
            logError("Erro ao escrever no campo de texto: " + e.getMessage());
        }
    }

    public static String obterValorCampo(String id_campo) {
        return driver.findElement(By.id(id_campo)).getAttribute("value");
    }

    public static boolean contemTexto(String texto) {
       try {
           logSuccess("Contem o texto: "+ texto);
           System.out.println(texto);
       }catch (Exception e){
           e.printStackTrace();
           logError("Erro: não foi possivel capturar texto" + e.getMessage());
       }
        return driver.getPageSource().contains(texto);
    }

    /********* Radio e Check ************/

    public void clicarRadio(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isRadioMarcado(String id){
        return driver.findElement(By.id(id)).isSelected();
    }

    public static void clicarCheck(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isCheckMarcado(String id){
        return driver.findElement(By.id(id)).isSelected();
    }

    /********* Combo ************/

    public static void selecionarCombo(String id, String valor) {
        try {
            WebElement element = driver.findElement(By.id(id));
            Select combo = new Select(element);
            //combo.selectByVisibleText(valor);
            combo.selectByValue(valor); // value
            logInfo("Valor selecionado com sucesso: " + id +", value: " + valor);
        }catch (Exception e){
            e.printStackTrace();
            logError("Erro: não foi possivel capturar texto " + e.getMessage());
        }

    }

    public void deselecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public static String obterValorCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> obterValoresCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for(WebElement opcao: allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int obterQuantidadeOpcoesCombo(String id){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public static boolean verificarOpcaoCombo(String id, String opcao){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for(WebElement option: options) {
            if(option.getText().equals(opcao)){
                return true;
            }
        }
        return false;
    }

    /********* Botao ************/

    public static void clicarBotaoId(String id) {
        driver.findElement(By.id(id)).click();
    }

    public static void clicarBotao(By by) {
        try {
            driver.findElement(by).click();
            logInfo("Botão de pesquisa clicado com sucesso: " + by);
        }catch (Exception e){
            e.printStackTrace();
            logError("Erro ao clicar no button: " + e.getMessage());
        }
    }

    public String obterValueElemento(String id) {
        return driver.findElement(By.id(id)).getAttribute("value");
    }

    public static void clickButtonXpath(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Erro de timeout para click no button" + e.getMessage());
        }
    }

    /********** tipoDATA **************/

    public void selectDate(String id, String xpath){
        WebElement inputDate = driver.findElement(By.id(id));
        inputDate.click();
        WebElement dateToSelect = driver.findElement(By.xpath(xpath));
        dateToSelect.click();
    }

    /********* anexarFile ************/

    public static void anexaFile(String id, String caminhoDoArquivo) {
        WebElement inputArquivo = driver.findElement(By.id(id));
        inputArquivo.sendKeys(caminhoDoArquivo);
    }

    /********* Link ************/

    public void clicarLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    /********* Textos ************/

    public String obterTexto(By by) {
        return driver.findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    /********* Alerts ************/

    public String alertaObterTexto(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String alertaObterTextoEAceita(){
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;

    }

    public String alertaObterTextoENega(){
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;

    }

    public void alertaEscrever(String valor) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    /********* Frames e Janelas ************/

    public void entrarFrame(String id) {
        driver.switchTo().frame(id);
    }

    public void sairFrame(){
        driver.switchTo().defaultContent();
    }

    public void trocarJanela(String id) {
        driver.switchTo().window(id);
    }

    /************** Espera AJAX *********************/

    public static void forceWait(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Erro para forçar espera " + e.getMessage());
        }
    }

    /*public void waitRequest(By by, String text){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.textToBe(by,text));
    }*/

    /************** JS *********************/

    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(cmd, param);
    }


    /************** Tabela *********************/

    public void clicarBotaoTabela(String idTabela, String colunaBusca, String colunaBotao, String valor){
        //procurar coluna do registro
        WebElement tabela = driver.findElement(By.xpath(idTabela));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //encontrar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        celula.findElement(By.xpath(".//input")).click();

    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
        int idLinha = -1;
        for(int i = 0; i < linhas.size(); i++) {
            if(linhas.get(i).getText().equals(valor)) {
                idLinha = i+1;
                break;
            }
        }
        return idLinha;
    }

    protected int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for(int i = 0; i < colunas.size(); i++) {
            if(colunas.get(i).getText().equals(coluna)) {
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }
}
