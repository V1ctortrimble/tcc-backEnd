package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.entity.UserEntity;
import com.unicesumar.ads.tcc.repository.UserRepository;
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
    public static final String FAILED_QUERY_USER = "Failed to query user";

    private final UserRepository repository;

    /**
     * User search method informed in the request
     * @return UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(()-> new UsernameNotFoundException("User not found!"));
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils
                .createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils
                .createAuthorityList("ROLE_USER");
        return new User(user.getUsername(), user.getPassword(),
                user.getAdmin() ? authorityListAdmin : authorityListUser);




    }
}
