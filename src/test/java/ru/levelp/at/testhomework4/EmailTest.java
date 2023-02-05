package ru.levelp.at.testhomework4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.levlup.at.homework4.pages.AuthorizationPage.getLoginName;
import static ru.levlup.at.homework4.pages.DraftPage.EMPTY_BOX_MESSAGE;
import static ru.levlup.at.homework4.pages.LetterPage.getBody;
import static ru.levlup.at.homework4.pages.LetterPage.getTheme;
import static ru.levlup.at.homework4.pages.LetterPage.getTheme2;
import static ru.levlup.at.homework4.utils.PropReader.getLogin;


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
        StartEmailPage startEmailPage = new StartEmailPage(driver);

        startEmailPage.open();
        authorizationPage.authorization(); // авторизируемся
        assertEquals(getLogin(), mainPage.getTextAutorizationVerify()); // проверяем автоизацию
        letterPage.createLetter(); // создаем письмо
        letterPage.closeLetter(); // закрываем письмо
        mainPage.goToDraftPage(); // переходим в Черновики
        assertEquals(getLoginName(), draftPage.getDraftAddressText()); // проверяем наличие письма в Черновиках адресату
        assertEquals(getTheme(), draftPage.getDraftThemeText()); // проверяем наличие письма в Черновиках по теме
        assertEquals(getBody(), draftPage.getDraftBodyText()); // проверяем наличие письма в Черновиках по телу
        draftPage.openLetter(); // открываем письмо
        letterPage.sendLetter(); // отправляем письмо
        draftPage.backToIncoming(); // переходим во входящие
        mainPage.goToDraftPage(); // переходим в Черновики
        assertEquals(EMPTY_BOX_MESSAGE, draftPage.getEmptyBoxMessage()); // проверяем отсутствие писем в Черновиках
        mainPage.goToSendLettersPage(); // переходим в Отправленные
        assertEquals(getLoginName(), draftPage.getDraftAddressText()); // проверяем наличие письма в Отправленных адресату
        assertEquals(getTheme(), draftPage.getDraftThemeText()); // проверяем наличие письма в Отправленных по теме
        assertEquals(getBody(), draftPage.getDraftBodyText()); // проверяем наличие письма в Отправленных по телу
        mainPage.logOut(); // разлогиниваемся
    }

    @Test
    void speedyGonsalesTest2() throws IOException {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        DraftPage draftPage = new DraftPage(driver);
        LetterPage letterPage = new LetterPage(driver);
        MainPage mainPage = new MainPage(driver);
        StartEmailPage startEmailPage = new StartEmailPage(driver);

        startEmailPage.open();
        authorizationPage.authorization(); // авторизируемся
        assertEquals(getLogin(), mainPage.getTextAutorizationVerify()); // проверяем автоизацию
        letterPage.createLetter(); // создаем письмо
        letterPage.sendLetter(); // отправляем письмо
        draftPage.backToIncoming(); // переходим во входящие
        mainPage.goToTestFolder(); // переходим в папку Тест
        assertEquals(getLoginName(), draftPage.getDraftAddressText()); // проверяем наличие письма в папке Тест по адресату
        assertEquals(getTheme(), draftPage.getDraftThemeText()); // проверяем наличие письма в папке Тест по теме
        assertEquals(getBody(), draftPage.getDraftBodyText()); // проверяем наличие письма в папке Тест по телу
        mainPage.logOut();
    }

    @Test
    void speedyGonsalesTest3() throws IOException {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        DraftPage draftPage = new DraftPage(driver);
        LetterPage letterPage = new LetterPage(driver);
        MainPage mainPage = new MainPage(driver);
        StartEmailPage startEmailPage = new StartEmailPage(driver);

        startEmailPage.open();
        authorizationPage.authorization(); // авторизируемся
        assertEquals(getLogin(), mainPage.getTextAutorizationVerify()); // проверяем автоизацию
        letterPage.createLetter2(); // создаем письмо
        letterPage.sendLetter(); // отправляем письмо
        draftPage.backToIncoming(); // переходим во входящие
        mainPage.clickRefreshBtn(); // обновляем страницу
        assertEquals(getLoginName(), draftPage.getDraftAddressText()); // проверяем наличие письма во Входящих по адресату
        assertEquals(getTheme2(), draftPage.getDraftTheme2Text()); // проверяем наличие письма во Входящих по теме
        assertEquals(getBody(), draftPage.getDraftBodyText()); // проверяем наличие письма во Входящих по телу
        mainPage.chooseCheckBox(); // выбираем чек-бокс
        mainPage.clickDeleteBtn(); // удаляем письма по выбранному чек-боксу
        mainPage.doToDeletedPage(); // переходим в удаленные
        assertEquals(getLoginName(), draftPage.getDraftAddressText()); // проверяем наличие письма в Корзине по адресату
        assertEquals(getTheme2(), draftPage.getDraftTheme2Text()); // проверяем наличие письма в Корзине по теме
        assertEquals(getBody(), draftPage.getDraftBodyText()); // проверяем наличие письма в Корзине по телу
        mainPage.logOut();
  }
}
