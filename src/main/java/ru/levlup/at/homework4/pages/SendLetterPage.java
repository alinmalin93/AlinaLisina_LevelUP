package ru.levlup.at.homework4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levlup.at.homework4.browser.BrowserStarter;

public class SendLetterPage extends BrowserStarter {

    public SendLetterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@title='testoviyt3sttest@yandex.ru']")
    private WebElement sendAddress;

    public String getSendAddressText() {
        return sendAddress.getAttribute("textContent");
    }
}
