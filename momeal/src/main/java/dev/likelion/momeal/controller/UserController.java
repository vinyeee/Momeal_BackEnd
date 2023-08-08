package dev.likelion.momeal.controller;

import dev.likelion.momeal.dto.UserDto;
import dev.likelion.momeal.entity.UserEntity;
import dev.likelion.momeal.infra.AuthenticationFacade;
import dev.likelion.momeal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final AuthenticationFacade authenticationFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/user/admin")
    public String adminHome(){
        return "admin.html";
    }

    @GetMapping("/home")
    public String home(Authentication authentication){
        try{
//            logger.info("connected user: {}",principal.getName());
//            logger.info("connected user: {}",authentication.getName());
            logger.info("connected user: {}", SecurityContextHolder.getContext().getAuthentication().getName());
        }catch (NullPointerException e){
            logger.info("no user logged in");
        }

        return "index";
    }

    @GetMapping("/user/login")
    public String login(){
        return "login-form.html";
    }

    @GetMapping("/user/signup")
    public String singUp(){
        return "signup-form";
    }



    @PostMapping("/user/signup")
    public String signupRequest(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password_check") String passwordCheck
    ){
        if(!password.equals(passwordCheck)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        UserEntity newUser = new UserEntity();
        newUser.setUserid(username);
        newUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(newUser);
        return "redirect:/home";
    }


}
