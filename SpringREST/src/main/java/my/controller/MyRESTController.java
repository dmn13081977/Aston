package my.controller;

import my.entity.Person;
import my.exception_hendling.NoPersonException;
import my.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MyRESTController {
    private PersonService personService;

    @Autowired
    public MyRESTController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/people")
    public List<Person> showAllPeople() {
        List<Person> allPeople = personService.getAllPeople();
        return allPeople;
    }

    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        Person person = personService.getPerson(id);
        if (person == null) throw new NoPersonException("No Person with id = " + id);
        return person;
    }

    @PostMapping("/people")
    public Person addNewPerson(@RequestBody Person person) {
        personService.savePerson(person);
        return person;
    }

    @PutMapping("/people")
    public Person updatePerson(@RequestBody Person person) {
        personService.savePerson(person);
        return person;
    }

    @DeleteMapping("/people/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        Person person = personService.getPerson(id);
        if (person == null) throw new NoPersonException("No Person with id =  " + id);
        personService.deletePerson(id);
        return "Deleted Person with id = " + id;
    }
}
