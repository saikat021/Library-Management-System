package com.StudentLibrary.Studentlibrary.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/author/**").hasAuthority("ADMIN")
                .antMatchers("/book/createBook").hasAuthority("ADMIN")
                .antMatchers("/book/**").hasAnyAuthority("STUDENT","ADMIN")
                .antMatchers("/student/deleteStudent").hasAuthority("ADMIN")
                .antMatchers("/student/**").hasAuthority("STUDENT")
                .antMatchers("/transaction/**").hasAuthority("STUDENT");

    }
    @Bean
    public BCryptPasswordEncoder BEencoder(){
        return new BCryptPasswordEncoder();
    }

}
