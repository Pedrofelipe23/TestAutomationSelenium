package core;

import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogManagement extends PageObject{
    private static final Object lockObject = new Object();

    public LogManagement(WebDriver browser) {
        super(browser);
    }

    public static void logInfo(String message) {
        String formattedMessage = formatLogMessage("INFO", message);
        writeLog(formattedMessage);
    }

    public static void logWarning(String message) {
        String formattedMessage = formatLogMessage("WARNING", message);
        writeLog(formattedMessage);
    }

    public static void logError(String message) {
        String formattedMessage = formatLogMessage("ERROR", message);
        writeLog(formattedMessage);
    }

    public static void logSuccess(String message) {
        String formattedMessage = formatLogMessage("SUCCESS", message);
        writeLog(formattedMessage);
    }

    private static String formatLogMessage(String logLevel, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "[" + timestamp + "] [" + logLevel + "] " + message;
    }

    private static void writeLog(String logMessage) {
        synchronized (lockObject) {
            String logFilePath = "C:\\TestePedro\\TestAutomation\\target\\logs\\" + "log" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".txt";

            try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
                writer.println(logMessage);
            } catch (IOException e) {
                // Trate qualquer exceção ocorrida ao gravar o log
                System.out.println("Erro ao escrever o log: " + e.getMessage());
            }
        }
    }
}
