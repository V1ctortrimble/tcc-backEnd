package com.unicesumar.ads.tcc.util;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * Component to validate password according to regex
 */
@Component
public class ValidatePasswordUtil {

    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public boolean getMatcher(String pass) {
        Pattern p = Pattern.compile(REGEX_PASSWORD);
        boolean m = p.matcher(pass).find();
        return m;
    }
}
