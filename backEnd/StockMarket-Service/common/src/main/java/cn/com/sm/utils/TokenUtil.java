package cn.com.sm.utils;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.exception.StockException;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final String KEY = "hellostockmarket";
    private static final long EXPIRATION = 30L;//expiration - minutes
    public static final String USERNAME = "username";
    public static final String ID = "id";

    public static Logger logger = LoggerFactory.getLogger(TokenUtil.class);


    /**
     * create token by user
     * @param user
     * @return
     */
    public static String createToken(UsersEntity user){
        if(user.getUsername()==null){
            logger.error("Username is null for user entity");
            throw new StockException(ResultEnum.SERVER_INTERNAL_ERROR);
        }
        Map<String,Object> map = new HashMap<>();
//        map.put(USERNAME,user.getUsername());
        map.put(ID,user.getId());
        JwtBuilder builder = Jwts.builder().setClaims(map).setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION*1000*60))
                .signWith(SignatureAlgorithm.HS256,KEY);
        return builder.compact();
    }
    /**
     * get username from token
     * @param token
     * @return
     */
    public static String getAttrFromToken(String token,String key){
        try {
            Claims claims = getClaimsFromToken(token);
            return claims.get(key).toString();
        }catch (SignatureException e){
            throw new StockException(ResultEnum.TOKEN_INVALIDATE);
        }
    }

    /**
     * get id from token
     * @param token
     * @return
     */
    public static String getIdFromToken(String token){
        try {
            return getAttrFromToken(token,ID);
        }catch (SignatureException e){
            throw new StockException(ResultEnum.TOKEN_INVALIDATE);
        }

    }

    /**
     * validate username in token same as the given user
     * @param token
     * @param userDetails
     * @return
     */
    public static boolean validate(String token,UsersEntity userDetails){
        String userName = getUsernameFromToken(token);
        if(userName!=null && userName.equals(userDetails.getUsername())){
            return true;
        }
        return false;
    }

    /**
     * get claims from token
     * @param token
     * @return
     */
    private static Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

    /**
     * get username from token
     * @param token
     * @return
     */
    public static String getUsernameFromToken(String token){
        return getClaimsFromToken(token).getSubject();
    }

    /**
     * is token expired
     * @param token
     * @return
     */
    public static boolean isTokenExpired(String token){
        Date expire = getClaimsFromToken(token).getExpiration();
        return new Date().after(expire);
    }
    public static void main(String[] args) {
        UsersEntity user = new UsersEntity();
        user.setId(123);
        user.setUsername("jack");
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsZWUiLCJpZCI6MSwiZXhwIjoxNTkyMjc1NjUzLCJpYXQiOjE1OTIyNzM4NTN9.Tgvfi3wnO2hPofNpj1t7lNH6YO9MxidzUX4byBFf8sE";
        System.out.println("token:"+token);
        System.out.println("id from token:"+getIdFromToken(token));
        System.out.println("name from token:"+getUsernameFromToken(token));
        System.out.println("is token expired:"+isTokenExpired(token));
    }
}
