package com.example.prueba;

import com.example.prueba.dao.PersonDAO;
import com.example.prueba.entity.Person;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MainController {
 
    @Autowired
    private PersonDAO personDAO;
 
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index() {
        Iterable<Person> all = personDAO.findAll();
 
        StringBuilder sb = new StringBuilder();
 
        all.forEach(p -> sb.append(p.getFullName() + "<br>"));
 
        System.out.println("Estoy aqui");
        System.out.println(sb);
        System.out.println(personDAO.count());
        personDAO.count();
        
        return "index";
    }
    
    @RequestMapping(value="/person/{name}", method=RequestMethod.GET)
    public String deleteStyles(
            @PathVariable("name") String name,
            Model model) {
        
    	
        Person p1 = new Person();
        
        p1.setFullName("John");

        personDAO.save(p1);
        
        return "added";
    }
 
}
