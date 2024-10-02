package com.learne.security.SecuritySide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static com.learne.security.SecuritySide.ApplicationUserRole.*;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "index.html", "/css/*", "/js/*").permitAll()
                                .requestMatchers("/api/**").hasRole(STUDENT.name())
                                .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder()
                        .username("fati")
                        .password(passwordEncoder.encode("123"))
                        .roles(STUDENT.name())
                        .build();
        UserDetails admin =
                User.builder()
                        .username("youssef")
                        .password(passwordEncoder.encode("456"))
                        .roles(ADMIN.name())
                        .build();
        UserDetails adminAmine =
                User.builder()
                        .username("Amine")
                        .password(passwordEncoder.encode("1212"))
                        .roles(ADMIN_TRAINING.name())
                        .build();
        return new InMemoryUserDetailsManager(
                user,
                admin,
                adminAmine
        );
    }
}
