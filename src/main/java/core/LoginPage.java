package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import static core.LogManagement.*;

public class LoginPage extends PageObject {

    //private static final String URL_LOGIN = "http://localhost:8080/eva/login/auth";
    //private static final String URL_LOGIN = "https://homolog.vivabr.com.br/solution/login/auth";
    private static final String URL_LOGIN = "https://homolog.vivabr.com.br/otimiza/login/auth";

    public LoginPage() {
        super(null);
        this.driver.navigate().to(URL_LOGIN);
        logWarning("Atenção ambiente de teste webDriver iniciado com a URL: " + URL_LOGIN);

    }

    public void preencherFormularioDeLogin(String username, String password) {
        logInfo("Digitando username e password: " + username);
        driver.findElement(By.id("j_username")).sendKeys(username);
        driver.findElement(By.id("j_password")).sendKeys(password);
        logInfo("Dados inseridos nos iputs..");
    }

    public void efetuaLogin() {
        driver.findElement(By.id("sendEmail")).submit();
        logSuccess("Login efetuado com sucesso");
    }

    public void autorizarHttps() {
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
    }

    public String getNomeUsuarioLogado() {
        try {
            return driver.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void page(String url){
        efetuaLogin();
        logWarning("aguardando direcionamento para page: " + url);
        driver.navigate().to(url);
        logSuccess("Entrou na page: " + url);
    }

}
