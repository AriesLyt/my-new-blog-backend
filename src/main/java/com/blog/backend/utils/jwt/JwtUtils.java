package com.blog.backend.utils.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Slf4j
public class JwtUtils {

    private final static String secretKey = "tNTaMC1B0Kzdl1q0LKJy7MooRbuwaebz+ariesBlogjwtKEy";
//    private final static SecretKey Key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secretKey));
    private final static SecureDigestAlgorithm<SecretKey, SecretKey> Algorithm = Jwts.SIG.HS256;

    private final static String issuer = "Aries_author";


    public static String createJwt(TokenBean tokenBean) {
        Date now = new Date();
        int expirationGap = 1000 * 60 * 60;
        Date expiration = new Date(now.getTime() + expirationGap);
        SecretKey Key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secretKey));
        String jwt = Jwts.builder()
                .subject(tokenBean.getUsername())
                .issuer(issuer)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(Key, Algorithm)
                .compact();
        log.info(jwt);
        return jwt;
    }
}