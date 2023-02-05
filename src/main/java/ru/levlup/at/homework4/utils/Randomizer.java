package ru.levlup.at.homework4.utils;

public class Randomizer {

    public static String RandInt() {
        int rand = (int) (Math.random() * (1000 + 1));
        return Integer.toString(rand);
    }
}
