package com.gkj;

import org.restlet.Component;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.ext.jaxrs.JaxRsApplication;

public class JaxRsMain extends JaxRsApplication {

    public JaxRsMain() {
        this.add(new App());
    }

    public static void main(String[] args) {
        try{
            Component component = new Component();
            component.getServers().add(Protocol.HTTP, 80);
            component.getDefaultHost().attach(new JaxRsMain());
            component.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}