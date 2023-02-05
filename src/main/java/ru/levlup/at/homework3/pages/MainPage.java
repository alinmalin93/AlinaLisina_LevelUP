package ru.levlup.at.homework3.pages;

import static ru.levlup.at.homework3.browser.BrowserActions.click;

import org.openqa.selenium.By;

public class MainPage {

    public static final By AUTHORIZATION_CHECK_ELEM = By.cssSelector("div.legouser>a>span.user-account__name");
    public static final By NEW_LETTER_BTN = By.cssSelector(".ns-view-compose-buttons-box>div>div>div>a");
    public static final By DRAFT_BTN = By.xpath("//div[contains(@aria-label, 'Черновики')]");
    public static final By SEND_BTN = By.xpath("//div[contains(@aria-label, 'Отправленные')]");
    public static final By USER_ACC_BTN = By.cssSelector("div.legouser>a.user-account");
    public static final By LOGOUT_BTN = By.cssSelector(".menu__group>li:nth-child(6)");
    public static final By OPEN_TEST_FOLDER = By.cssSelector(".qa-LeftColumn-UserFolderNodeContent>div");

    public static final By CHECKBOX_IN_INCOMING = By.cssSelector("div.ns-view-toolbar-buttons>div:nth-child(1)>div:nth-child(1)>label>span");

    public static final By DELETE_BTN = By.cssSelector("div.ns-view-container-desc>div:nth-child(5)");

    public static final By DELETED_BTN = By.xpath("//div[contains(@aria-label, 'Удалённые')]");

    public static void logOut() {
        click(USER_ACC_BTN);
        click(LOGOUT_BTN);
    }

}
