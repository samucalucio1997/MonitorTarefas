package com.tarefa.monitor.security;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tarefa.monitor.model.Usuario;

public class TokenUtil {
     public static String encode(Usuario usuario){
       return JWT.create()
       .withIssuer("auth")
       .withSubject(usuario.getNome())
       .withClaim("id", usuario.getId().toString())
       .withExpiresAt(LocalDateTime.now()
       .plusDays(1L)
       .toInstant(ZoneOffset.of("-03:00")))
       .sign(Algorithm.HMAC256("goth"));
     }
 
     public static String getSubject(String token){
        return JWT.require(Algorithm.HMAC256("goth"))
        .withIssuer("auth").build().verify(token).getSubject();
      }

    }
