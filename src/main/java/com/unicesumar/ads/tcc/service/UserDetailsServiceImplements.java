package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.entity.UserEntity;
import com.unicesumar.ads.tcc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 * UserDetailsService implementation class to find the request user
 */
@Repository
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

        try {
            UserEntity user = repository.findByUsername(username);

            if (user == null){
                throw new UsernameNotFoundException(USER_NOT_FOUND);
            }
            return user;
        }catch (Exception e){
            throw new UsernameNotFoundException(FAILED_QUERY_USER);
        }
    }
}
