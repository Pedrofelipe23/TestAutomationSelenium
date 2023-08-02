package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage extends PageObject {

    private static final String URL_LOGIN = "http://localhost:8080/eva/login/auth";
    //private static final String URL_LOGIN = "https://homolog.vivabr.com.br/viva/login/auth";

    public LoginPage() {
        super(null);
        this.driver.navigate().to(URL_LOGIN);
    }

    public void preencherFormularioDeLogin(String username, String password) {
        driver.findElement(By.id("j_username")).sendKeys(username);
        driver.findElement(By.id("j_password")).sendKeys(password);
    }

    public void efetuaLogin() {
        driver.findElement(By.id("sendEmail")).submit();
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
        driver.navigate().to(url);
    }



}
