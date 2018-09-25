package cn.gkj.aspect;

import cn.gkj.annotation.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Aspect
@Component
public class MapperAspect{
    public MapperAspect(){
        System.out.println("初始化切面");
    }

    /**
     * 只能使用excution匹配方式
     * bean()匹配方式会嵌套加强（加强不止一次）
     * @target() 也不行代理类没有注解
     */
    @Pointcut("execution(* cn.gkj.demo.mapper.*.*(..))")
    public void pointcut(){
    }

    /**
     * Mapper只提供了接口，所以获取注解需要获得实现的接口
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        for(Class c:point.getTarget().getClass().getInterfaces()){
            Log a=null;
         if((a= (Log) c.getAnnotation(Log.class))!=null){
             System.out.println(a.value()+"begining...");
             break;
         }
        }
        Object proceed = point.proceed();
        System.out.println("执行完毕");
        return proceed;
    }
}
