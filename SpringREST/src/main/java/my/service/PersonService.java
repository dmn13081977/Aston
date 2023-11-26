package my.service;

import my.entity.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getAllPeople();

    public void savePerson(Person person);

    public Person getPerson(int id);

    public void deletePerson(int id);
}
