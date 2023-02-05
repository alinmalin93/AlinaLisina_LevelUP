package ru.levlup.at.homework3.browser;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions extends BrowserStarter {

    public static WebElement findElem(By elem) {
        return driver.findElement(elem);
    }

    public static void input(By selector, String text) {
        findElem(selector).sendKeys(text);
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
        WebElement elem = wait.until(ExpectedConditions.visibilityOf(findElem(selector)));
        return elem.getAttribute("textContent");
    }


    public static Boolean isSelected(By selector) {
        return  driver.findElement(selector).isSelected();
    }

    public static void refresh() {
        driver.navigate().refresh();
    }
}
