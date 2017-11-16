package cn.derek.springcloud.learning.auth.service;

import cn.derek.springcloud.learning.auth.vo.LoginVM;

public interface AuthService {

    public String login(LoginVM loginVM) throws Exception;
}
