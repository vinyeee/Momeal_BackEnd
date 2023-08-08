package dev.likelion.momeal.service;

import dev.likelion.momeal.entity.UserEntity;
import dev.likelion.momeal.repository.UserRepository;
import org.springframework.stereotype.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public CustomUserDetailsService(
            @Autowired UserRepository userRepository,
            @Autowired PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        final UserEntity testUserEntity = new UserEntity();
        testUserEntity.setUserid("entity_user");
        testUserEntity.setPassword(passwordEncoder.encode("test1pass"));
        this.userRepository.save(testUserEntity);
    }


    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByUserid(userid);
        return new User(userid,userEntity.getPassword(),new ArrayList<>());
    }
}
