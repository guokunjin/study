package com.repository;

import com.repository.entity.Person;

import java.util.List;

public interface PersonDao {
    List<Person> getAll();
    Person get(Integer id);
    void add(Person p);
    void delete(Integer id);
    void edit(Person person);
    Person changeHeadImg(int id, String s);

}
