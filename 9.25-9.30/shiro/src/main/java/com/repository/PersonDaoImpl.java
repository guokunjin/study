package com.repository;

import com.repository.entity.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * -Dspring.profiles.active="env1"
 * 运行时指定使用的环境
 */
@Profile("env1")
@Repository("pd")
public class PersonDaoImpl implements com.repository.PersonDao {
    public PersonDaoImpl() {
        System.out.println("实例化PersonDaoImpl");
    }

    private static List<Person> personList;
    static {
        personList=new LinkedList<Person>();
        personList.add(new Person(1,"Joker",20,"http://127.0.0.1/person/headImg/moren"));
        personList.add(new Person(2,"Jack",19,"http://127.0.0.1/person/headImg/moren"));
        personList.add(new Person(3,"Tom",20,"http://127.0.0.1/person/headImg/moren"));
    }

    public List<Person> getAll(){
        return personList;
    }

    public Person get(Integer id){
        Iterator<Person> iterator = personList.iterator();
        while(iterator.hasNext()){
            Person p=iterator.next();
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    public void add(Person p){
        synchronized(personList) {
            personList.add(p);
        }
    }

    public void delete(Integer id){
        synchronized(personList){
            Iterator<Person> iterator = personList.iterator();
            while(iterator.hasNext()){
                Person p=iterator.next();
                if(p.getId().equals(id)){
                    iterator.remove();
                }
            }
        }
    }

    public void edit(Person person){
        synchronized(personList){
           for(Person p:personList){
                if(p.getId().equals(person.getId())){
                    p.setAge(person.getAge());
                    p.setName(person.getName());
                    return ;
                }
            }
        }
    }

    public Person changeHeadImg(int id, String s) {
        for(Person p:personList){
            if(p.getId().equals(id)){
                p.setHeadImg(s);
                return p;
            }
        }
        return null;
    }
}
