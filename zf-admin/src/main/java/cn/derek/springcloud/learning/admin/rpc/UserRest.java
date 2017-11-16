package cn.derek.springcloud.learning.admin.rpc;

import cn.derek.springcloud.learning.admin.biz.BaseUserService;
import cn.derek.springcloud.learning.api.vo.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UserRest {

    @Autowired
    private BaseUserService baseUserService;

    @RequestMapping(value = "/user/username/{username}",method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public UserInfo getUserByUsername(@PathVariable("username")String username) {
        return baseUserService.selectByUsername(username);
    }
}
