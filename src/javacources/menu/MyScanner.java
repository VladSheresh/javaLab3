package javacources.menu;

import java.util.Scanner;

public class MyScanner {

    private static Scanner instance;

    public static Scanner getInstance() {
        if (instance == null) {
            instance = new Scanner(System.in);
        }
        return instance;
    }
}
