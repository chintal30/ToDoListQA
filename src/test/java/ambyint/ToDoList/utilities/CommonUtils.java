package ambyint.ToDoList.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtils {
    public static void waitDefininte(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_LLLL_yyyy_HH_mm_ss"));
    }

    public static void takePageVisibleScreenshot() {
        File screenshotFile = ((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        File toPNGFile = new File("screenShots/" + getCurrentDateTime() + ".png");
        try {
            FileHandler.copy(screenshotFile, toPNGFile); // FileHandler from Selenium
        } catch (IOException e) {
        }
    }


}