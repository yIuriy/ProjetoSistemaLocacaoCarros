package com.iuri.services;

import java.util.regex.Pattern;

public class CheckPlateStandard {
    public static boolean check(String plate){
        String regex = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$";
        return Pattern.matches(regex, plate);
    }
}
