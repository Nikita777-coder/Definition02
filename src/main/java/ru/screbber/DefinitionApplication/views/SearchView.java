package ru.screbber.DefinitionApplication.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.screbber.DefinitionApplication.dao.DefinitionDAO;
import ru.screbber.DefinitionApplication.models.Definition;

import java.util.List;

@Controller
public class SearchView {

    private final DefinitionDAO definitionDAO;

    @Autowired
    public SearchView(DefinitionDAO definitionDAO) {
        this.definitionDAO = definitionDAO;
    }


    @GetMapping("/search")
    public String handleSearchRequest(@RequestParam("search") String searchQuery, Model model) {
        List<Definition> matchingDefinitions = definitionDAO.getAllDefinitions()
                .stream()
                .filter(definition -> definition.getName().trim().toLowerCase().startsWith(searchQuery.toLowerCase()))
                .toList();
        model.addAttribute("definitions", matchingDefinitions);

        return "home";
    }


}
