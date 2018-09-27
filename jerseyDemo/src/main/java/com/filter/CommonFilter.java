package com.filter;

import com.error.AppException;
import com.error.ExceptionType;
import com.filter.tag.Log;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;

@Log
@Provider
@Priority(Priorities.USER)//优先级，决定执行顺序
public class CommonFilter implements ContainerRequestFilter,ContainerResponseFilter {
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("request过滤");
        List<String> auth = containerRequestContext.getHeaders().get("credentils");
        if(auth.get(0).equals("123456")){
            System.out.println("有效凭证");
        }else{
            System.out.println("无效凭证，禁止访问");
            throw new AppException(ExceptionType.NO_PERM);
        }
        UriInfo uriInfo = containerRequestContext.getUriInfo();
        System.out.println("请求方法："+containerRequestContext.getMethod());
        System.out.println("访问路径："+uriInfo.getAbsolutePath());
    }

    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        System.out.println("response过滤");
    }
}
