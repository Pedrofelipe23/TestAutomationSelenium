package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestRecordManagement extends PageObject{

    private static BufferedWriter logWriter;
    //private static final String LOG_FILE = "C:\\TestePedro\\TestAutomation\\target\\logs\\test.log";

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

    public static void openLog(String logName) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmm");

            String logFileName = logName + "_" + dateFormat.format(new Date()) + ".log";
            String logFilePath = "C:\\TestePedro\\TestAutomation\\target\\logs\\" + logFileName;
            logWriter = new BufferedWriter(new FileWriter(logFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao gerar o arquivo de log: " + e.getMessage());
        }
    }

    public static void logInteraction(String message) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String logMessage = "[" + dateFormat.format(new Date()) + "] " + message;
            logWriter.append(logMessage);
            logWriter.newLine();
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao gravar as interações de log: " + e.getMessage());
        }
    }

    public static void closeLog() {
        try {
            logWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao fecharDriver e salvar arquivo de log: " + e.getMessage());
        }
    }
    /*public static void log(String mensagem) {
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
    }*/

    /*public static void saveBrowserLogs() {
        // Obtenha os logs do navegador
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);

        // Crie um arquivo de log com base na data e hora atual
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String logFileName = "test_" + dateFormat.format(new Date()) + ".log";
        String logFilePath = "C:\\TestePedro\\TestAutomation\\target\\logs\\" + logFileName;
        File logFile = new File(logFilePath);
        logFile.getParentFile().mkdirs(); // Cria os diretorios pai, se necessário

        try (FileOutputStream fos = new FileOutputStream(logFile)) {
            // Escreva as entradas de log no arquivo
            for (LogEntry entry : logs) {
                String logMessage = entry.getMessage();
                fos.write(logMessage.getBytes());
                fos.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            Logger.getLogger(PageObject.class.getName()).log(Level.SEVERE, "Erro ao gravar o arquivo de log", e);
        }
    }*/
}