package com.iuri.services;

import com.iuri.domain.Customer;

import java.util.regex.Pattern;

public class CheckCpfStandard {
    public static boolean check(String cpf) {
        String regex = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$";
        return Pattern.matches(regex, cpf);
    }
}
