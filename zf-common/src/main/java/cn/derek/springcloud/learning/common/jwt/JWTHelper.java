package cn.derek.springcloud.learning.common.jwt;

import cn.derek.springcloud.learning.common.Constants;
import cn.derek.springcloud.learning.common.biz.IJWTInfo;
import cn.derek.springcloud.learning.common.biz.impl.JWTInfo;
import cn.derek.springcloud.learning.common.utils.RsaKeyHelper;
import cn.derek.springcloud.learning.common.utils.StringHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;


public class JWTHelper {

    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();

    public static String createToken(IJWTInfo userInfo, int expire, String rsaPriKeyPath) throws Exception{
        String compactJws = Jwts.builder()
                .setSubject(userInfo.getUsername())
                .claim(Constants.STR_USER_ID, userInfo.getId())
                .claim(Constants.STR_USER_NAME, userInfo.getName())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(rsaPriKeyPath))
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .compact();
        return compactJws;
    }

    public static Jws<Claims> parseToken(String token, String rsaPubKeyPath) throws Exception{
        return Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(rsaPubKeyPath)).parseClaimsJws(token);
    }

    public static IJWTInfo getUserInfo(String token, String rsaPubKeyPath) throws Exception{
        Jws<Claims> claims = parseToken(token, rsaPubKeyPath);
        Claims body = claims.getBody();
        String id = StringHelper.getObjectValue(body.get(Constants.STR_USER_ID));
        String name = StringHelper.getObjectValue(body.get(Constants.STR_USER_ID));
        String userName = body.getSubject();
        JWTInfo JWTInfo = new JWTInfo(id, name, userName);
        return JWTInfo;
    }
}
