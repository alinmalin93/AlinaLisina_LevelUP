package ru.levlup.at.homework3.pages;

import static ru.levlup.at.homework3.pages.LetterPage.ADDRESS;

import org.openqa.selenium.By;

public class SendLetterPage {

    public static final By SEND_ADDRESS = By.xpath("//span[@title='" + ADDRESS + "']");
}
