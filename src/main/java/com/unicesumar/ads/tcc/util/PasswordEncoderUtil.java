package com.unicesumar.ads.tcc.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderUtil {
    public String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
