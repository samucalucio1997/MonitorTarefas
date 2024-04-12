package com.tarefa.monitor.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tarefa.monitor.repository.UsuarioRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterChain extends OncePerRequestFilter{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            jakarta.servlet.FilterChain filterChain) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String token = "";
        var authorization = request.getHeader("Authorization");
        if (authorization != null) {
            token = authorization.replace("Bearer ", "");
            var subject = TokenUtil.getSubject(token);
            var user =  this.usuarioRepository.findByNome(subject);
            var usernameT = new UsernamePasswordAuthenticationToken(user, null, 
            user.getAuthorities());  
            SecurityContextHolder.getContext().setAuthentication(usernameT);
        }
        filterChain.doFilter(request, response);
    }

}
