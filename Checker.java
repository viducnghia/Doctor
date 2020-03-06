/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class Checker {

    private final Scanner sc = new Scanner(System.in);

    public String checkLength(int length) {
        String s = "";
        while (true) {
            s = sc.nextLine();
            if (s.length() <= length) {
                break;
            } else {
                System.out.println("You must enter a string with length not longer than " + length + " characters");
            }
        }
        return s;
    }

    public String checkInputByRegex(String regex, String mss) {
        String s = "";
        while (true) {
            s = sc.nextLine();
            if (s.toUpperCase().matches(regex)) {
                break;
            } else {
                System.out.println(mss);
            }
        }
        return s;
    }

    public String checkDate(String regex) {
        String s;
        SimpleDateFormat sdf = new SimpleDateFormat(regex);
        sdf.setLenient(false);
        while (true) {
            s = sc.nextLine();
            try {
                sdf.parse(s);
                return s;
            } catch (ParseException e) {
                System.out.println("You must enter date with format " + regex);
            }
        }

    }

    public boolean checkYOrN() {
        String s = "";
        while (true) {
            s = sc.nextLine();
            if (s.toUpperCase().matches("[Y|N]")) {
                return s.toUpperCase().equals("Y");
            } else {
                System.out.println("You must enter y or n");
            }
        }
    }
}
