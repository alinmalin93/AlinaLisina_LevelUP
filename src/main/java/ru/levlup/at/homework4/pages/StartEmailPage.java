package ru.levlup.at.homework4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levlup.at.homework4.browser.BrowserStarter;

public class StartEmailPage extends BrowserStarter {

    public StartEmailPage(WebDriver driver) {
        super(driver);
    }

    private final String START_URL = "https://mail.yandex.ru/";

    @FindBy(css = "body>div>div>div>div:nth-child(2)>button")
    protected static WebElement enterBtn;

    public void open() {
        driver.get(START_URL);
    }
}
