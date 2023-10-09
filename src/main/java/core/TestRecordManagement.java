package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestRecordManagement extends PageObject{

    public TestRecordManagement(WebDriver browser) {
        super(browser);
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
            System.out.println("Falha ao tirar screenshot: " + e.getMessage());
        }
    }
}
