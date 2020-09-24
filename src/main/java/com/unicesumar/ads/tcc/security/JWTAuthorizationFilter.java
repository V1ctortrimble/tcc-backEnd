package com.unicesumar.ads.tcc.security;

import com.unicesumar.ads.tcc.service.UserDetailsServiceImplements;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.unicesumar.ads.tcc.security.JTWConstants.*;


public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final UserDetailsServiceImplements userDetailsServiceImplements;


    public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
                                  UserDetailsServiceImplements userDetailsServiceImplements) {
        super(authenticationManager);
        this.userDetailsServiceImplements = userDetailsServiceImplements;
    }

    /**
     * Checks if the header is with the token
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(HEADER_STRING);
        if(header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }
    /**
     * Parse the token and retrieve the user to validate their authorization if the reader has the token
     */
    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if(token == null) return null;
        String username = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                .getBody()
                .getSubject();
        UserDetails userDetails = userDetailsServiceImplements.loadUserByUsername(username);
        return username != null ? new UsernamePasswordAuthenticationToken(username, null,
                userDetails.getAuthorities()) : null;
    }
}
