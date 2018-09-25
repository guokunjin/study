package cn.gkj.demo.mapper;

import cn.gkj.annotation.Log;
import cn.gkj.demo.entry.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@Log("UserMapper日志记录")
public interface UserMapper {
    int deleteByPrimaryKey(String username);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}