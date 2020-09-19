package com.unicesumar.ads.tcc.configuration;


import com.unicesumar.ads.tcc.security.JWTAuthenticationFilter;
import com.unicesumar.ads.tcc.security.JWTLoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuration class for JWT authentication
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Entrypoint definition and filtering method
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/api/home").permitAll()
                .antMatchers("/v2/api-docs", "/swagger-resources/**",
                        "/swagger-ui.html", "/webjars/**", "/swagger.json").permitAll()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JWTLoginFilter("/api/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * Method of creating a standard user in Memory
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}password123!@#")
                .roles("ADMIN");
    }
}
