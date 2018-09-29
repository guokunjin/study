package com.resources;

import com.repository.PersonDao;
import com.repository.PersonDaoImpl;
import com.repository.entity.Person;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
//import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Singleton
@Path("person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    public PersonResource() {
        System.out.println("实例一个PersonResource");
    }

//    @Autowired
    PersonDao personDao=new PersonDaoImpl();


    @Consumes({MediaType.MULTIPART_FORM_DATA})  //指定接受类型
    @Path("uploadImg")
    @POST
    public Person upload(@FormDataParam("id") int id,
                         @FormDataParam("file") InputStream fileInputStream,
                         @FormDataParam("file") FormDataContentDisposition fileMetaData){
        File f=new File(id+".jpg");
        try {
            FileUtils.copyInputStreamToFile(fileInputStream,f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personDao.changeHeadImg(id,"http://127.0.0.1/person/headImg/"+id);
    }

    @GET
    @Path("headImg/{id}")
    @Produces("image/jpeg")
    public Response getHeadImg(@PathParam("id") String id){
        File f = new File(id+".jpg");
        if (!f.exists()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(f)
                    .header("Cache-Control", "no-cache").build();
        }
    }


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
        System.out.println("是否拥有admin角色："+ SecurityUtils.getSubject().hasRole("admin"));
        return "hello";
    }

}
