package my.controller;

import my.entity.Person;
import my.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    private PersonService personService;

    @Autowired
    public MyController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/")
    public String showAllPeople(Model model) {
        List<Person> allPeople = personService.getAllPeople();
        model.addAttribute("allPeople", allPeople);
        return "allPeople";
    }

    @RequestMapping("/addPerson")
    public String addNewPerson(Model model) {
        Person person = new Person();
        model.addAttribute("newPerson", person);
        return "person-info";
    }

    @RequestMapping("/savePerson")
    public String savePerson(@ModelAttribute("newPerson") Person person) {
        personService.savePerson(person);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updatePerson(@RequestParam("personId") int id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("newPerson", person);
        return "person-info";
    }

    @RequestMapping("/deletePerson")
    public String deletePerson(@RequestParam("personId") int id) {
        personService.deletePerson(id);
        return "redirect:/";
    }
}
