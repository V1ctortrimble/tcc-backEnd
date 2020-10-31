package com.unicesumar.ads.tcc.util;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static com.unicesumar.ads.tcc.util.constants.UtilsConstants.REGEX_PASSWORD;

/**
 * Component to validate password according to regex
 */
@Component
public class ValidatePasswordUtil {

    public boolean getMatcher(String pass) {
        Pattern p = Pattern.compile(REGEX_PASSWORD);
        boolean m = p.matcher(pass).find();
        return m;
    }
}
