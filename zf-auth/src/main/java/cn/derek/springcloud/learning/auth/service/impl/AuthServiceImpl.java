package cn.derek.springcloud.learning.auth.service.impl;

import cn.derek.springcloud.learning.api.vo.user.UserInfo;
import cn.derek.springcloud.learning.auth.feign.IUserService;
import cn.derek.springcloud.learning.auth.jwt.JWTTokenUtils;
import cn.derek.springcloud.learning.auth.service.AuthService;
import cn.derek.springcloud.learning.auth.vo.LoginVM;
import cn.derek.springcloud.learning.common.biz.impl.JWTInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private IUserService userService;

    @Autowired
    private JWTTokenUtils jwtTokenUtils;

    @Override
    public String login(LoginVM loginVM) throws Exception{

        UserInfo info = userService.getUserByUsername(loginVM.getUsername());
        String token = "";
        if (encoder.matches(loginVM.getPassword(), info.getPassword())) {
            token = jwtTokenUtils.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getName()));
        }
        return token;
    }
}
