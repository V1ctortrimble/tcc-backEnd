package com.unicesumar.ads.tcc.security;

/**
 * Define JWT properties
 */
public class JTWConstants {

    static final long EXPIRATION_TIME = 86400000L;
    static final String SECRET = "TccSecret";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";

}
