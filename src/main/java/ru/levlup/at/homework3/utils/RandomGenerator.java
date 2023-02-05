package ru.levlup.at.homework3.utils;

public class RandomGenerator {

    public static String RandInt() {
        int rand = (int) (Math.random() * (1000 + 1));
        return Integer.toString(rand);
    }

    public static void main(String[] args) {
        System.out.println(RandInt());
    }
}
