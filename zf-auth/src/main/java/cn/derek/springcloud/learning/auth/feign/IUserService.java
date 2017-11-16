package cn.derek.springcloud.learning.auth.feign;


import cn.derek.springcloud.learning.api.vo.user.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "zf-admin")
public interface IUserService {

    @RequestMapping(value = "/api/user/username/{username}", method = RequestMethod.GET)
    public UserInfo getUserByUsername(@PathVariable("username") String username);
}
