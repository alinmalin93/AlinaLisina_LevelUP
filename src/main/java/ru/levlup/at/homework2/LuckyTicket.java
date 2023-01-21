package ru.levlup.at.homework2;

public class LuckyTicket {

    private static Integer intSum(int a) {
        char[] numArray = String.valueOf(a).toCharArray();
        int result = 0;
        for (char num : numArray) {
            result += Character.getNumericValue(num);
        }
        return result;
    }


    public static boolean isLuckyTicket(int ticketNumber) {
        boolean result;
        if (String.valueOf(ticketNumber).length() != 6) {
            result = false;
        } else {
            int firsthalf = Integer.parseInt(Integer.toString(ticketNumber).substring(0, 3));
            int secondthalf = Integer.parseInt(Integer.toString(ticketNumber).substring(3, 6));
            result = intSum(firsthalf).equals(intSum(secondthalf));
        }
        return result;
    }
}
