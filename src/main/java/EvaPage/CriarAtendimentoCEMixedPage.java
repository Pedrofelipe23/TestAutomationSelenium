package EvaPage;

import PageObject.PageObject;
import org.openqa.selenium.WebDriver;

public class CriarAtendimentoCEMixedPage extends PageObject {

    private static final String URL = "http://localhost:8080/eva/atendimentoExtended2/criarAtendimentoCEMixed";

    public CriarAtendimentoCEMixedPage(WebDriver browser) {
        super(browser);
    }

    public CriarAtendimentoCEMixedPage carregarFormulario() {
        this.driver.navigate().to(URL);
        return new CriarAtendimentoCEMixedPage(driver);
    }
}
