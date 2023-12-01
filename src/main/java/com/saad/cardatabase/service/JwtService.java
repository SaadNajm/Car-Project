package com.saad.cardatabase.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpHeaders;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtService {
 static final int EXPIRATIONTIME=800000;
 static final String PREFIX="Bearer";
 static final Key KEY=Keys.secretKeyFor(SignatureAlgorithm.HS256);

public String getToken(String username){
    String token=Jwts.builder()
            .setSubject(username)
            .setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
            .signWith(KEY)
            .compact();
    return token;
}
public String getAuthUser(HttpServletRequest request){
    String token=request.getHeader(HttpHeaders.AUTHORIZATION);
    if(token!=null){
         String user=Jwts.parserBuilder()
                 .setSigningKey(KEY)
                 .build()
                 .parseClaimsJws(token.replace(PREFIX,""))
                 .getBody()
                 .getSubject();
        if (user != null)
            return user;

    }
    return null;
}


}
