package com.site;

import com.site.data.Person;
import com.site.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QueryController {
    private final PersonRepository personRepository;

    @Autowired
    public QueryController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/query", params = {"name"}, method = RequestMethod.GET)
    public ModelAndView query(@RequestParam String name) {
        ModelAndView model = new ModelAndView();
        model.setViewName("person");

        model.addObject("name", name);

        Person person = personRepository.findByName(name);
        if (person != null) {
            model.addObject("email", person.getEmail());
            model.addObject("age", person.getAge());
        }

        return model;
    }
}