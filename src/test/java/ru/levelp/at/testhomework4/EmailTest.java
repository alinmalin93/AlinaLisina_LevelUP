package ru.levelp.at.testhomework4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.levlup.at.homework4.pages.AuthorizationPage.LOGIN_NAME;
import static ru.levlup.at.homework4.pages.DraftPage.EMPTY_BOX_MESSAGE;
import static ru.levlup.at.homework4.utils.PropReader.getLogin;
import static ru.levlup.at.homework4.utils.PropReader.getLoginName;

import org.junit.jupiter.api.Test;
import ru.levlup.at.homework4.pages.AuthorizationPage;
import ru.levlup.at.homework4.pages.DraftPage;
import ru.levlup.at.homework4.pages.LetterPage;
import ru.levlup.at.homework4.pages.MainPage;
import ru.levlup.at.homework4.pages.SendLetterPage;
import ru.levlup.at.homework4.pages.StartEmailPage;
import java.io.IOException;

public class EmailTest extends CommonTest {

    @Test
    void speedyGonsalesTest1() throws IOException {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        DraftPage draftPage = new DraftPage(driver);
        LetterPage letterPage = new LetterPage(driver);
        MainPage mainPage = new MainPage(driver);
        SendLetterPage sendLetterPage = new SendLetterPage(driver);
        StartEmailPage startEmailPage = new StartEmailPage(driver);

        startEmailPage.open();
        authorizationPage.authorization(); // авторизируемся
        assertEquals(getLogin(), mainPage.getTextAutorizationVerify()); // проверяем автоизацию
        letterPage.createLetter(); // создаем письмо
        letterPage.closeLetter(); // закрываем письмо
        mainPage.goToDraftPage(); // переходим в Черновики
        assertEquals(getLoginName(), draftPage.getDraftAddressText()); // проверяем наличие письма в Черновиках
        draftPage.openLetter(); // открываем письмо
        letterPage.sendLetter(); // отправляем письмо
        draftPage.backToIncoming(); // переходим во входящие
        mainPage.goToDraftPage(); // переходим в Черновики
        assertEquals(EMPTY_BOX_MESSAGE, draftPage.getEmptyBoxMessage()); // проверяем отсутствие писем в Черновиках
        mainPage.goToSendLettersPage(); // переходим в Отправленные
        assertEquals(LOGIN_NAME, sendLetterPage.getSendAddressText()); // проверяем наличие письма в Отправленных
        mainPage.logOut(); // разлогиниваемся
    }

//    @Test
//    void speedyGonsalesTest2() {
//    AuthorizationPage authorizationPage = new AuthorizationPage(driver);
//    DraftPage draftPage = new DraftPage(driver);
//    LetterPage letterPage = new LetterPage(driver);
//    MainPage mainPage = new MainPage(driver);
//    SendLetterPage sendLetterPage = new SendLetterPage(driver);
//    StartEmailPage startEmailPage = new StartEmailPage(driver);
//        authorization(); // авторизируемся
//        assertEquals(LOGIN, getText(AUTHORIZATION_CHECK_ELEM)); // проверяем авторизацию
//        createLetter(); // создаем письмо
//        click(SEND_LETTER_BTN); // отправляем письмо
//        click(BACK_TO_INCOMING); // открываем Входящие
//        click(OPEN_TEST_FOLDER); // переходим в папку Тест
//        assertEquals(LOGIN_NAME, getText(SEND_ADDRESS)); // сверяем отправителя
//        logOut();
//    }
//
//    @Test
//    void speedyGonsalesTest3() throws InterruptedException {
//        authorization(); // авторизируемся
//        assertEquals(LOGIN, getText(AUTHORIZATION_CHECK_ELEM)); // проверяем авторизацию
//        createLetter2(); // создаем письмо
//        click(SEND_LETTER_BTN); // отправляем письмо
//        click(BACK_TO_INCOMING); // открываем Входящие
//        refresh();
//        assertEquals(LOGIN_NAME, getText(SEND_ADDRESS)); // сверяем отправителя
//        click(CHECKBOX_IN_INCOMING);
//    }
}
