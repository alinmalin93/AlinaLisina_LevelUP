package ru.levlup.at.homework3.pages;

import static ru.levlup.at.homework3.pages.LetterPage.ADDRESS;
import static ru.levlup.at.homework3.pages.LetterPage.THEME;

import org.openqa.selenium.By;

public class DraftPage {

    public static final By DRAFT_ADDRESS = By.xpath("//span[@title='" + ADDRESS + "']");
    public static final By DRAFT_THEME = By.xpath("//span[contains(@title, '" + THEME + "')]");
    public static final By DRAFT_BODY = By.cssSelector(".mail-MessageSnippet-Item_body>div>span>span:nth-child(2)>span");
    public static final By LETTER_BTN = By.cssSelector("div>a.mail-MessageSnippet>div");
    public static final By EMPTY_BOX = By.cssSelector(".ns-view-messages-empty>div>h1>span");
    public static final String EMPTY_BOX_MESSAGE = "В папке «Черновики» нет писем";
    public static final By BACK_TO_INCOMING = By.cssSelector(".ComposeDoneScreen-Actions>a");



}
