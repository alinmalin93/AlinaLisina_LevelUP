package ru.levelp.at.testhomework2;

import static org.testng.Assert.assertEquals;
import static ru.levlup.at.homework2.LuckyTicket.isLuckyTicket;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LuckyTicketPositiveTest {

    @DataProvider(name = "positiveProvider")
    public static Object[][] testDataPositive() {
        return new Object[][] {
            {112211, true},
            {342009, true}
        };
    }

    @Test(dataProvider = "positiveProvider")
    public void positiveTest(int num, boolean res) {
        assertEquals(isLuckyTicket(num), res);
    }
}
