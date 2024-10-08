package com.energy.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        http.headers(headers ->
                headers.xssProtection(
                        xss -> xss.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK)
                ).contentSecurityPolicy(
                        cps -> cps.policyDirectives("script-src 'self'")
                ));
        return http.build();
        // // Schakel alle beveiligingsmechanismen uit en maak alle verzoeken toegankelijk
        // httpSecurity.csrf().disable().css
        //         .authorizeHttpRequests()
        //         .anyRequest().permitAll()  // Sta alle verzoeken toe zonder authenticatie
        //         .and()
        //         .formLogin().disable()  // Schakel formuliergebaseerde login uit
        //         .logout().disable();  // Schakel uitloggen uit

        // return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
