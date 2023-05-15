package ambyint.ToDoList.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    static String url = PropertyFileReader.getPropertyValue("ambyint.url");

    public static void openChrome() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    public static void launchUrl() {
        driver.get().get(url);
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeAllWindows() {
        driver.get().quit();
    }



}
