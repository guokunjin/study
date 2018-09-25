import cn.gkj.Application;
import cn.gkj.demo.mapper.QuestionnaireMapper;
import cn.gkj.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class AopTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionnaireMapper questionnaireMapper;

    @Test
    public void test(){
        System.out.println(userMapper.selectByPrimaryKey("joker"));
        System.out.println(questionnaireMapper.selectByPrimaryKey(1));
    }

}
