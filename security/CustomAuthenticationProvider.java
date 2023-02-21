package com.example.spring_boot_microservice1_course.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component

public class CustomAuthenticationProvider  implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        System.out.println("this is authentication provider");
       String username= authentication.getName();
       String password= authentication.getCredentials().toString();

       if (username.equals("tom") && password.equals("admin"))
       {
           return new UsernamePasswordAuthenticationToken(username,password, Arrays.asList());
       }
       else
       {

           new BadCredentialsException("Username or password is invalid");
       }

 return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
