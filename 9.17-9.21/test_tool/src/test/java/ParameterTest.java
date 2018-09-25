package base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterTest {

    int except;  //用来存储预期结果
    int input1;  //用来存储第一个输入参数
    int input2;  //用来存储第二个输入参数

    @Parameterized.Parameters
    public static Collection<Object[]> initTestData() {
        return Arrays.asList(
                new Object[][]{
                        {3, 1, 2},
                        {10, 5, 5},
                        {5, 4, 2},
                        {7, 3, 4}}
        );
    }

    public ParameterTest(int except, int input1, int input2) {
        this.except = except;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void testAdd() {
        assertEquals(except, new Claculate().add(input1, input2));
    }
}
