package com.resources;

import com.repository.PersonDao;
import com.repository.entity.Person;
import com.sun.jersey.spi.resource.Singleton;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    PersonDao personDao=new PersonDao();

    @Path("get/{id}")
    @GET
    public Person getById(@PathParam("id") Integer id){
        return personDao.get(id);
    }

    @Path("getAll")
    @GET
    public List<Person> getAll(){
        return personDao.getAll();
    }
    @Path("edit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Person edit(Person person){
        personDao.edit(person);
        return person;
    }

    @Path("delete")
    @POST
    public String delete(@QueryParam("id") Integer id){
        personDao.delete(id);
        return "success";
    }

    @Path("test")
    @GET
    public String test(){
        return "hello";
    }

}
