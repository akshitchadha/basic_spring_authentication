package com.example.spring_boot_microservice1_course.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomAuthenticationProvider  customAuthenticationProvider;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//         InMemoryUserDetailsManager userDetailsService=new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("tom").password(passwordEncoder
//                ().encode("admin")).authorities("read").build();
//        userDetailsService.createUser(user);
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      System.out.println("this is authentication manager");
      auth.authenticationProvider(customAuthenticationProvider);
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic();
    http.authorizeRequests().antMatchers("/hello").authenticated().anyRequest().denyAll();
    http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
    }


    @Bean
    public  BCryptPasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }
}
