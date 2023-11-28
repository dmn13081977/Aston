package my.dao;

import my.entity.Person;

import java.util.List;


public interface PersonDAO {
    public List<Person> getAllPeople();

    public void savePerson(Person person);

    public Person getPerson(int id);

    public void deletePerson(int id);
}
