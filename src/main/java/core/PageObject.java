package core;

import com.sun.glass.events.KeyEvent;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class PageObject {

    private static final String LOG_FILE = "C:\\TestePedro\\TestAutomation\\target\\logs\\test.log";

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
        if(Propriedades.FECHAR_BROWSER){
            driver.quit();
        }
    }

    public static void takeScreenshot(String fileName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Obter a data e hora atual
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = dateFormat.format(currentDate);

            // Incluir a data e hora no nome do arquivo
            String screenshotName = fileName + "_" + timestamp + ".jpg";

            File destinationFile = new File(screenshotName);
            FileUtils.copyFile(sourceFile, destinationFile);
            System.out.println("Screenshot saved: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }

    public static void log(String mensagem) {
        String timestamp = getTimestamp();
        String logMessage = timestamp + " - " + mensagem;

        writeLog(logMessage);
    }

    private static void writeLog(String logMensagem) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(logMensagem);
        } catch (IOException e) {
            System.out.println("Falha ao gravar no arquivo de log: " + e.getMessage());
        }
    }

    private static String getTimestamp() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(currentDate);
    }

}