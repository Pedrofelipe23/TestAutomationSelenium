package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static core.LogManagement.logSuccess;


public class TestRecordManagement extends Driver {

    public TestRecordManagement(WebDriver browser) {
        super(browser);
    }

    /********* Screenshot ************/

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

    public static void captureScreenshot(String fileName) {
        takeScreenshot(fileName);
        logSuccess("Captura de tela bem-sucedida: " + fileName);
    }

    /********* Target ************/

    public static void deleteFileSpecifiedTarget(String caminho) {
        String caminhoArquivoParaExcluir = "C:\\TestePedro\\TestAutomation\\target\\";

        File arquivoParaExcluir = new File(caminhoArquivoParaExcluir + caminho);

        if (arquivoParaExcluir.exists() && arquivoParaExcluir.isFile()) {
            if (arquivoParaExcluir.delete()) {
                System.out.println("Arquivo excluído com sucesso.");
            } else {
                System.out.println("Não foi possível excluir o arquivo.");
            }
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
