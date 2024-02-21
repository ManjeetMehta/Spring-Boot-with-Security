package com.springboot.security.config;

import jdk.jfr.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService()
    {
/*        UserDetails details1 = User
                .withUsername("manjeet")
                .password(passwordEncoder().encode("manjeet"))
                .roles("Admin")
                .build();

        UserDetails details2 = User
                .withUsername("shivansh")
                .password(passwordEncoder().encode("shivansh"))
                .roles("Normal")
                .build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(details1, details2);
        return inMemoryUserDetailsManager;*/

        return new CustomUserDetailService();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/home/public")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        return httpSecurity.build();
    }
}
