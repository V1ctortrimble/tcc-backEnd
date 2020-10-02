package com.unicesumar.ads.tcc.util;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.unicesumar.ads.tcc.util.CorsConstants.*;

/**
 * Component for CORS authorization
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilterUtil implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, ALLOW_ORIGIN);
        response.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

        if ("OPTIONS".equals(request.getMethod()) && ALLOW_ORIGIN.equals(request.getHeader("Origin"))) {
            response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, DELETE, PUT, OPTIONS");
            response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, "Authorization, Content-Type, Accept");
            response.setHeader(ACCESS_CONTROL_MAX_AGE, "3600");
            response.setStatus(HttpServletResponse.SC_OK);
        }
        chain.doFilter(req, resp);
    }
}