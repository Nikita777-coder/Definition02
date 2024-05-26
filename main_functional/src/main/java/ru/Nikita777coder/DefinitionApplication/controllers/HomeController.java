package ru.Nikita777coder.DefinitionApplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Nikita777coder.DefinitionApplication.entity.Definition;
import ru.Nikita777coder.DefinitionApplication.repositories.DefinitionRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final DefinitionRepository definitionRepository;

    @GetMapping("/home")
    public String sayHello(Model model) {
        List<Definition> allDefinitions =definitionRepository.findAll();
        model.addAttribute("definitions", allDefinitions);

        return "home";
    }

}
