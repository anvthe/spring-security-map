package com.rko.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    //authentication
    public UserDetailsService userDetailsService() {
       /* UserDetails admin = User.withUsername("admin").password(encoder.encode("password")).roles("ADMIN").build();
        UserDetails user = User.withUsername("user").password(encoder.encode("password")).roles("USER").build();
        return new InMemoryUserDetailsManager(admin, user);*/

        return new UserInfoUserDetailsService();



    }

    @Bean
    //authorization
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/login").permitAll()
                //.anyRequest().authenticated()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/login/**")
                .authenticated()
                .and().formLogin()
                .and().build();


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}

