package com.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal(); //得到用户名
        String password = new String((char[])authenticationToken.getCredentials()); //得到密码
        if(!"joker".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123456".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个 AuthenticationInfo 实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username= (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(username.equals("joker")){
            info.addStringPermission("person:*");
        }
        return info;
    }
}
