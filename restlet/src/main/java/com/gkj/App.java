package com.gkj;

import com.gkj.resources.PersonResource;
import com.gkj.resources.TestResource;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class App  extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> rrcs = new HashSet<Class<?>>();
        rrcs.add(PersonResource.class);
        return rrcs;
    }
//    @Override
//    public Restlet createInboundRoot() {
//        System.out.println("sssssssssssssssssssss");
//        Router router = new Router(getContext());
//        router.attach("/test",TestResource.class);
//        return router;
//    }

}
