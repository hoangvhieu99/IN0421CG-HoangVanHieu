package utils;

import java.util.Scanner;

public class ScannerSingeton {

    private static Scanner scanner = new Scanner(System.in);

    private ScannerSingeton() { }

    public static Scanner getInstance( ) {
        if (scanner == null){
            return scanner = new Scanner(System.in);
        }

        return scanner;
    }
}
