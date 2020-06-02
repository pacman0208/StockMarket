package cn.com.sm.util;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.exception.StockException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jdk.nashorn.internal.parser.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class TokenUtil {
    private static final String KEY = "hellostockmarket";
    private static final long EXPIRATION = 30L;//expiration - minutes

    public static Logger logger = LoggerFactory.getLogger(TokenUtil.class);
    /**
     * create token by user
     * @param user
     * @return
     */
    public static String createToken(UsersEntity user){
        if(user.getUsername()==null){
            logger.error("Username is null for user entity");
            throw new StockException(ResultEnum.SERVER_INTERNAL_ERRO);
        }
        JwtBuilder builder = Jwts.builder().setId(user.getUsername()).setSubject("session_token")
                .setIssuedAt(new Date())
                .setExpiration(new Date(EXPIRATION*1000*60))
                .signWith(SignatureAlgorithm.HS256,KEY);
        return builder.compact();
    }


    public static String createToken(UserDetails user){
        if(user.getUsername()==null){
            logger.error("Username is null for user entity");
            throw new StockException(ResultEnum.SERVER_INTERNAL_ERRO);
        }
        JwtBuilder builder = Jwts.builder().setId(user.getUsername()).setSubject("session_token")
                .setIssuedAt(new Date())
                .setExpiration(new Date(EXPIRATION*1000*60))
                .signWith(SignatureAlgorithm.HS256,KEY);
        return builder.compact();
    }
    /**
     * get username from token
     * @param token
     * @return
     */
    public static String getUsernameFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        return claims.getId();
    }

    public static boolean validate(String token,UserDetails userDetails){
        Claims claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        String userName = claims.getId();
        if(userName!=null && userName.equals(userDetails.getUsername())){
            return true;
        }
        return false;
    }
}
