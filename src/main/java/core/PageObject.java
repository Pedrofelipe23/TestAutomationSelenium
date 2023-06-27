package core;

import com.sun.glass.events.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class PageObject {

    protected static WebDriver driver;

    public PageObject( WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        if (browser == null) {
            driver = new ChromeDriver();
        }else {
            driver = browser;
        }
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS).pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        try {
            Robot robot = new Robot();

            for (int i = 0; i < 1; i++) {
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }
        }catch (AWTException e){
            System.out.println("Erro ao tentar executar robot para ajustar zoom do driver.");
        }

    }

    public static void fechar() {
        driver.quit();
    }

}