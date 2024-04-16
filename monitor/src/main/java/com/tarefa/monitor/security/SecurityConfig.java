package com.tarefa.monitor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private FilterChain filterChain;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(n -> {
            try {
                n.disable().sessionManagement(management -> management
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(pr -> {pr
                
                .requestMatchers(HttpMethod.POST, "/usuario/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/usuario/criarUser").permitAll()
                .requestMatchers(HttpMethod.POST, "/task/cadastrarTarefa").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/task/atualizar").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/task/removerTarefa").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/task/concluir").hasRole("ADMIN")
               .anyRequest().authenticated();});
            } catch (Exception e) {
               e.printStackTrace();
            } 
        });
       return http.addFilterBefore(filterChain, UsernamePasswordAuthenticationFilter.class).build();
    }

   @Bean
   public AuthenticationManager AuthenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
           return authenticationConfiguration.getAuthenticationManager();
   }

   @Bean
   public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
   }
}
