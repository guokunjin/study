package com.gkj.resources;

import com.gkj.repository.PersonDao;
import com.gkj.repository.PersonDaoImpl;
import com.gkj.repository.entity.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    public PersonResource() {
        System.out.println("实例一个PersonResource");
    }

    PersonDao personDao=new PersonDaoImpl();

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
//    @Consumes(MediaType.APPLICATION_JSON)
    public Person edit(Person person){
        personDao.edit(person);
        return person;
    }

    @Path("delete")
    @DELETE
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