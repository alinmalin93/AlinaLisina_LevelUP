package ru.levlup.at.homework3.browser;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserStarter {

    private static WebDriver driver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }

    public static WebDriver driver = driver();
    public static final String START_URL = "https://mail.yandex.ru/";

    public static void browserSetUp() {
        driver.get(START_URL);
    }

    public static void browserClose() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        driver.close();
    }
}
