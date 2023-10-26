package core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.getDriver;
import static core.Driver.fecharDriver;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @After
    public void finaliza() throws IOException {
        TakesScreenshot print = (TakesScreenshot) getDriver();
        File arquivo = print.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" +File.separator+ "screenshot" +File.separator+ testName.getMethodName() +".jpg"));
        System.out.println("screenshot " + testName.getMethodName());

        if (Propriedades.FECHAR_BROWSER){
            fecharDriver();
        }
    }

}
