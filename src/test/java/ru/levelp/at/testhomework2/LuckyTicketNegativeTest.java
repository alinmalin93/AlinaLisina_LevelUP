package ru.levelp.at.testhomework2;

import static org.testng.Assert.assertEquals;
import static ru.levlup.at.homework2.LuckyTicket.isLuckyTicket;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LuckyTicketNegativeTest {

    @DataProvider (name = "negativeProvider")
    public static Object [][] testDataNegative() {
        return new Object[][] {
            {6, false},
            {33358, false},
            {4544000, false},
            {868311, false}
        };
    }

    @Test(dataProvider = "negativeProvider")
    public void negativeTest(int num, boolean res) {
        assertEquals(isLuckyTicket(num), res);
    }

}
