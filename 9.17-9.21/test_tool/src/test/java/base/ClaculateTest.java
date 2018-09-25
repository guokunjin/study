package base;

import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

public class ClaculateTest {
    Claculate claculate;


    @Before
    public void init(){
        claculate=new Claculate();
        System.out.println("每个测试项初始化操作");
    }
    @After
    public void over(){
        System.out.println("每个测试项后执行的操作");
    }

    @Test
    public void add() {
        System.out.println(claculate.add(4,5));
        assertEquals(5,claculate.add(2,3));
    }

    @Test
    public void subtract() {
        assertEquals(4, new Claculate().subtract(9, 5));
    }

    @Test
    public void multiply() {
        assertEquals(6, new Claculate().multiply(2, 3));
    }

    @Test
    public void divide() {
        assertEquals(3, new Claculate().divide(9, 0));
    }


    @Test
    @Ignore
    public void ignore(){
        System.out.println("被忽略的测试");
    }
}