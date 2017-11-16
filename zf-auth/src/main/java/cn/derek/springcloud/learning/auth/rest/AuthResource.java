package cn.derek.springcloud.learning.auth.rest;

import cn.derek.springcloud.learning.auth.jwt.JwtAuthenticationResponse;
import cn.derek.springcloud.learning.auth.service.AuthService;
import cn.derek.springcloud.learning.auth.vo.LoginVM;
import cn.derek.springcloud.learning.common.reponse.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    @Autowired
    private AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(LoginVM loginVM) throws Exception{
        final String token = authService.login(loginVM);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }
}
