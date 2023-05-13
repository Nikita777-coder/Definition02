package ru.screbber.DefinitionApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.screbber.DefinitionApplication.dao.DefinitionDAO;
import ru.screbber.DefinitionApplication.models.Definition;

import java.util.List;

@Controller
public class HomeController {

    private final DefinitionDAO definitionDAO;

    @Autowired
    public HomeController(DefinitionDAO definitionDAO) {
        this.definitionDAO = definitionDAO;
    }

    @GetMapping("/home")
    public String sayHello(Model model) {
        List<Definition> allDefinitions = definitionDAO.getAllDefinitions();
        model.addAttribute("definitions", allDefinitions);

        return "home";
    }

}
