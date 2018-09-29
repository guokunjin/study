package com.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlPermissionsFilter extends AuthorizationFilter {

    public static Map<String,String> urlPermMap=new HashMap<String, String>();
    static{
        urlPermMap.put("/person/getAll","person:getAll");
        urlPermMap.put("/person/get/[0-9]*","person:get:(1)");
        urlPermMap.put("/person/delete","person:delete");
        urlPermMap.put("/person/edit","person:edit");
    }
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        String requestURI = WebUtils.getPathWithinApplication(WebUtils.toHttp(servletRequest));
        String perm=null;
        for(HashMap.Entry<String,String> entry:urlPermMap.entrySet()){
            Pattern compile = Pattern.compile(entry.getKey());
            Matcher matcher = compile.matcher(requestURI);
            if(matcher.matches()){
                perm=entry.getValue();
                int count = matcher.groupCount();
                for(int i=1;i<count+1;i++){
                    perm.replace("("+i+")",matcher.group(i));
                }
            }
        }
        Subject subject = this.getSubject(servletRequest, servletResponse);
        //超级管理员无阻
        if(subject.hasRole("admin")) return true;
        //通过subject判断用户有没有些url权限
        return subject.isPermitted(perm);
    }
}
