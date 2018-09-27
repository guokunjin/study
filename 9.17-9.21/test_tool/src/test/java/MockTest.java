import base.Claculate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {
    @Mock
    Claculate claculate;
    @Test
    public void test(){
        //调用真实方法
        when(claculate.add(anyInt(),anyInt())).thenCallRealMethod();
        System.out.println(claculate.add(1,9));

        when(claculate.subtract(1,2)).thenReturn(-1);
        when(claculate.multiply(4,2)).thenReturn(8);
        when(claculate.divide(4,2)).thenReturn(2);
        //除数为0的情况抛出算数异常
        //注：使用参数匹配时，全部参数不能直接使用，如指定需使用ArgumentMatchers的方法返回类型值
        when(claculate.divide(anyInt(),eq(0))).thenThrow(ArithmeticException.class);
        Assert.assertEquals(claculate.add(1,2),3);
        Assert.assertEquals(claculate.subtract(1,2),-1);
        Assert.assertEquals(claculate.multiply(4,2),8);
        Assert.assertEquals(claculate.divide(4,2),2);
        try{
            claculate.divide(2,0);
        }catch (ArithmeticException e){
            System.out.println("算数异常");
        }
    }

    /**
     * spy包装对象
     */
    @Test
    public void test2(){
        List list = new LinkedList();
        List spy = spy(list);
        //改变list返回的结果
        doReturn("foo").when(spy).get(0);
        System.out.println(spy.get(0));
    }
}
