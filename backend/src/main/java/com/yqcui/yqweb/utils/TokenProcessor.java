package com.yqcui.yqweb.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenProcessor {
    private static final long EXPIRE_TIME=60*60*1000*24*7; //过期时间7天
    private static final String KEY = "huterox"; //加密秘钥

    /**
     * create token for a userName
     * @param userEmail
     * @return
     */
    public static String createToken(String userEmail){
        Map<String,Object> header = new HashMap();
        header.put("typ","JWT");
        header.put("alg","HS512");
        JwtBuilder builder = Jwts.builder().setHeader(header)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME))
                .setSubject(userEmail)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,KEY);
        return builder.compact();
    }

    /**
     * verify whether the token is valid
     * @param token
     * @return
     */
    public static Claims verify(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

}
