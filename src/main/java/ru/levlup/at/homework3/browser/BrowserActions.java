package ru.levlup.at.homework3.browser;

import static ru.levlup.at.homework3.browser.BrowserStarter.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BrowserActions {

    public static void input(By selector, String text) {
        driver.findElement(selector).sendKeys(text);
    }

    public static void click(By selector) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                WebElement button = new WebDriverWait(driver, Duration.ofSeconds(7))
                    .until(ExpectedConditions.elementToBeClickable(selector));
                button.click();
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println(e);
            }
            attempts++;
        }
    }

    public static String getText(By selector) {
        return driver.findElement(selector).getAttribute("textContent");
    }

    public static Boolean isSelected(By selector) {
        return  driver.findElement(selector).isSelected();
    }
}
