package cn.derek.springcloud.learning.auth.jwt;

import cn.derek.springcloud.learning.common.biz.IJWTInfo;
import cn.derek.springcloud.learning.common.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTTokenUtils {

    @Value("${jwt.expire}")
    private int expire;
    @Value("${jwt.pri-key.path}")
    private String priKeyPath;
    @Value("${jwt.pub-key.path}")
    private String pubKeyPath;

    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.createToken(jwtInfo, expire, priKeyPath);
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getUserInfo(token,pubKeyPath);
    }
}
