package cn.gkj.contorller;

import cn.gkj.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserMapper userMapper;
    @RequestMapping("test")
    public String test(){
        System.out.println(userMapper);
        return "test";
    }
}

