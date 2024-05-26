package ru.Nikita777coder.DefinitionApplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.Nikita777coder.DefinitionApplication.entity.Definition;
import ru.Nikita777coder.DefinitionApplication.repositories.DefinitionRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final DefinitionRepository definitionRepository;

    @GetMapping("/search")
    public String handleSearchRequest(@RequestParam("search") String searchQuery, Model model) {
        List<Definition> matchingDefinitions = definitionRepository.findAll()
                .stream()
                .filter(definition -> definition.getName().trim().toLowerCase().startsWith(searchQuery.toLowerCase()))
                .toList();
        model.addAttribute("definitions", matchingDefinitions);

        return "home";
    }
}
