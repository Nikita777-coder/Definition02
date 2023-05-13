package ru.screbber.DefinitionApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.screbber.DefinitionApplication.dao.DefinitionDAO;
import ru.screbber.DefinitionApplication.dao.PersonDAO;
import ru.screbber.DefinitionApplication.models.Definition;
import ru.screbber.DefinitionApplication.models.Person;
import ru.screbber.DefinitionApplication.security.PersonDetails;

import java.util.List;

@Controller
public class FavoriteController {

    private final PersonDAO personDAO;

    @Autowired
    public FavoriteController(DefinitionDAO definitionDAO, PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/favorites")
    public String handleCategoriesRequest(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person person = personDetails.getPerson();
        List<Definition> definitionList = person.getDefinitions();
        model.addAttribute("definitions", definitionList);

        return "favorite";
    }

    @Transactional
    @PostMapping("/favorites")
    public String addToFavorites(@ModelAttribute("definition") Definition definition) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person person = personDetails.getPerson();

        if (definition != null) {
            List<Definition> definitions = person.getDefinitions();
            if (!definitions.contains(definition)) {
                definitions.add(definition);
                person.setDefinitions(definitions);
                personDAO.save(person);
            }
        }

        return "redirect:/home";
    }

    @Transactional
    @PostMapping("/favorites/delete")
    public String deleteFavorite(@ModelAttribute("definition") Definition definition) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person person = personDetails.getPerson();
        person.getDefinitions().remove(definition);
        personDAO.save(person);

        return "redirect:/favorites";
    }
}