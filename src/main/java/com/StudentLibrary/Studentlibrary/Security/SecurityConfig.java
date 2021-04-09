package com.StudentLibrary.Studentlibrary.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
        http.csrf().disable().httpBasic().and()
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/author/**").hasAuthority("ADMIN")
                .antMatchers("/book/createBook").hasAuthority("ADMIN")
                .antMatchers("/book/**").hasAnyAuthority("STUDENT","ADMIN")

                .antMatchers(HttpMethod.PUT,"/student/**").hasAnyAuthority("STUDENT","ADMIN")
                .antMatchers(HttpMethod.POST,"/student/**").hasAuthority("STUDENT")
                .antMatchers(HttpMethod.GET,"/student/").hasAuthority("STUDENT")
                .antMatchers("/student/**").hasAuthority("ADMIN")


                .antMatchers(HttpMethod.POST,"/transaction/**").hasAuthority("STUDENT")
                .antMatchers(HttpMethod.GET,"/transaction/").hasAuthority("STUDENT")
                .antMatchers(HttpMethod.GET,"/transaction/all").hasAuthority("ADMIN")
                .antMatchers("/").permitAll();



    }
    @Bean
    public BCryptPasswordEncoder BEencoder(){
        return new BCryptPasswordEncoder();
    }

}
