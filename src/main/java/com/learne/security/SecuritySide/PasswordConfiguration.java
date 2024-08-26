package com.learne.security.SecuritySide;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordConfiguration {
    public static void main (String[] args) {

        PasswordEncoder encoder = new BCryptPasswordEncoder(5);

        String clairCode = "Eddafir";
        String encodedPass = encoder.encode(clairCode);
        System.out.println(encodedPass);
    }
}
