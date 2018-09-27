package com.gkj.resources;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class TestResource extends ServerResource {
    @Get
    public String test(){
        System.out.println("run test");
        return "success";
    }
}
