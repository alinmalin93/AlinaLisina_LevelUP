package ru.levlup.at.homework3.pages;

import static ru.levlup.at.homework3.pages.LetterPage.ADDRESS;
import static ru.levlup.at.homework3.pages.LetterPage.BODY;
import static ru.levlup.at.homework3.pages.LetterPage.THEME;
import static ru.levlup.at.homework3.pages.LetterPage.THEME2;

import org.openqa.selenium.By;

public class SendLetterPage {

    public static final By SEND_ADDRESS = By.xpath("//span[@title='" + ADDRESS + "']");

    public static final By SEND_THEME = By.xpath("//span[@title='" + THEME + "']");
    public static final By SEND_THEME2 = By.xpath("//span[@title='" + THEME2 + "']");


    public static final By SEND_BODY = By.xpath("//span[@title='" + BODY + "']");

}
