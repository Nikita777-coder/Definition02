package ru.Nikita777coder.DefinitionApplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Nikita777coder.DefinitionApplication.entity.Definition;
import ru.Nikita777coder.DefinitionApplication.entity.Person;
import ru.Nikita777coder.DefinitionApplication.repositories.PeopleRepository;
import ru.Nikita777coder.DefinitionApplication.security.PersonDetails;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FavoriteController {
    private final PeopleRepository peopleRepository;

    @GetMapping("/favorites")
    public String handleCategoriesRequest(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        Person person = personDetails.getPerson();
        List<Integer> definitionList = person.getDefinitions();
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
            List<Integer> definitions = person.getDefinitions();
            if (!definitions.contains(definition.getId())) {
                definitions.add(definition.getId());
                person.setDefinitions(definitions);
                peopleRepository.save(person);
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
        person.getDefinitions().remove(definition.getId());
        peopleRepository.save(person);

        return "redirect:/favorites";
    }
}