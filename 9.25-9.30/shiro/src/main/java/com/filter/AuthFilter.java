//package com.filter;
//
//import com.error.AppException;
//import com.error.ExceptionType;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.LockedAccountException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.config.IniSecurityManagerFactory;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.Subject;
//
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.container.ContainerResponseContext;
//import javax.ws.rs.container.ContainerResponseFilter;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.Cookie;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.NewCookie;
//import javax.ws.rs.ext.Provider;
//import java.io.IOException;
//import java.util.Map;
//import java.util.UUID;
//
//@Provider
//public class AuthFilter implements ContainerRequestFilter,ContainerResponseFilter{
//    ThreadLocal<Boolean> hasSessionId=new ThreadLocal<Boolean>();
//    ThreadLocal<String> sessionId=new ThreadLocal<String>();
//    static{
//        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
//    }
//
//    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
//        Cookie c=null;
//        if((c=containerRequestContext.getCookies().get("JSESSIONID"))==null){
//            hasSessionId.set(false);
//            sessionId.set(UUID.randomUUID().toString());
//        }else{
//            sessionId.set(c.getValue());
//        }
////        MultivaluedMap<String, String> headers = containerRequestContext.getHeaders();
////        Subject sub=SecurityUtils.getSubject();
////        UsernamePasswordToken token = new UsernamePasswordToken(headers.get("username").get(0),headers.get("password").get(0));
////        try {
////            sub.login(token);
////        } catch (UnknownAccountException uae) {
////            System.out.println("用户名不存在:" + token.getPrincipal());
////        } catch (IncorrectCredentialsException ice) {
////            System.out.println("账户密码 " + token.getPrincipal() + " 不正确!");
////        } catch (LockedAccountException lae) {
////            System.out.println("用户名 " + token.getPrincipal() + " 被锁定 !");
////        }
////        sub.getSession().getAttribute("a");
////        // 认证成功后
////        if (sub.isAuthenticated()) {
////            System.out.println("用户 " + sub.getPrincipal() + " 登陆成功！");
////            //测试角色
////            System.out.println("是否拥有 manager 角色：" + sub.hasRole("manager"));
////            //测试权限
////            System.out.println("是否拥有 user:create 权限" + sub.isPermitted("user:create"));
////        }else{
////            throw new AppException(ExceptionType.NO_PERM);
////        }
//
//    }
//
//    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
//        if(hasSessionId.get()==false){
//            containerResponseContext.getCookies().put("JSESSIONID",new NewCookie("JSESSIONID",sessionId.get()));
//        }
//    }
//}
