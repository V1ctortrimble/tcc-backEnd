package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.UsersEntity;
import com.unicesumar.ads.tcc.data.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * UserDetailsService implementation class to find the request user
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplements implements UserDetailsService {

    public static final String USER_NOT_FOUND = "User not found!";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    private final UsersRepository repository;

    /**
     * User search method informed in the request
     * @return UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsersEntity user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(()-> new UsernameNotFoundException(USER_NOT_FOUND));
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils
                .createAuthorityList(ROLE_USER, ROLE_ADMIN);
        List<GrantedAuthority> authorityListUser = AuthorityUtils
                .createAuthorityList(ROLE_USER);
        return new User(user.getUsername(), user.getPassword(),
                user.getAdmin() ? authorityListAdmin : authorityListUser);
    }
}
