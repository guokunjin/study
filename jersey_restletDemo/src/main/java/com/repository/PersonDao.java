package com.repository;

import com.repository.entity.Person;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PersonDao {
    private static List<Person> personList;
    static {
        personList=new LinkedList<Person>();
        personList.add(new Person(1,"Joker",20));
        personList.add(new Person(2,"Jack",19));
        personList.add(new Person(3,"Tom",20));
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
            Iterator<Person> iterator = personList.iterator();
            while(iterator.hasNext()){
                Person p=iterator.next();
                if(p.getId().equals(person.getId())){
                    iterator.remove();
                    personList.add(person);
                }
            }
        }
    }

}
