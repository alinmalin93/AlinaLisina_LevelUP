package ru.levlup.at.homework3.browser;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserStarter {

    private static WebDriver driver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }

    private static final ChromeOptions options = new ChromeOptions().addArguments("--start-maximized");
    public static WebDriver driver = new ChromeDriver(options);

    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public static final String START_URL = "https://mail.yandex.ru/";

    public static void browserSetUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(START_URL);
    }

    public static void browserClose() {
        driver.quit();
    }
}
