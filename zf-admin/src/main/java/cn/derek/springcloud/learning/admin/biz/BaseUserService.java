package cn.derek.springcloud.learning.admin.biz;

import cn.derek.springcloud.learning.common.reponse.TableResultResponse;
import cn.derek.springcloud.learning.common.utils.Query;
import cn.derek.springcloud.learning.admin.entity.BaseUser;
import cn.derek.springcloud.learning.admin.mapper.BaseUserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BaseUserService {

    @Autowired
    private BaseUserMapper baseUserMapper;

    public BaseUser selectByUsername(String username){
        BaseUser baseUser = new BaseUser();
        baseUser.setUsername(username);
        return baseUserMapper.selectOne(baseUser);
    }

    public TableResultResponse<BaseUser> selectByQuery(Query query) {
        Example example = new Example(BaseUser.class);
        Example.Criteria criteria = example.createCriteria();
        for (Map.Entry<String, Object> entry : query.entrySet()) {
            criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
        }
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<BaseUser> list = baseUserMapper.selectByExample(example);
        return new TableResultResponse<BaseUser>(result.getTotal(), list);
    }
}
