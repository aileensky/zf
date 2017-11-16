package cn.derek.springcloud.learning.admin.rest;

import cn.derek.springcloud.learning.admin.biz.BaseUserService;
import cn.derek.springcloud.learning.common.reponse.TableResultResponse;
import cn.derek.springcloud.learning.common.utils.Query;
import cn.derek.springcloud.learning.admin.entity.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("baseuser")
public class BaseUserResource {

    @Autowired
    private BaseUserService baseUserService;

    @GetMapping(value = "/list")
    public TableResultResponse<BaseUser> list(Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        return baseUserService.selectByQuery(query);
    }

}
