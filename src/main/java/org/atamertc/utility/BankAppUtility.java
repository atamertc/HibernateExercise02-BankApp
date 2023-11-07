package org.atamertc.utility;

import java.util.Scanner;

public class BankAppUtility {
    static Scanner scanner = new Scanner(System.in);

    public static int intVeriAlma(String query) {
        System.out.println(query);
        int value = Integer.parseInt(scanner.nextLine());
        return value;
    }

    public static double doubleVeriAlma(String query) {
        System.out.println(query);
        double value = Double.parseDouble(scanner.nextLine());
        return value;
    }

    public static String stringVeriAlma(String query) {
        System.out.println(query);
        String value = scanner.nextLine();
        return value;
    }

    public static long longVeriAlma(String query) {
        System.out.println(query);
        long value = Long.parseLong(scanner.nextLine());
        return value;
    }





}
