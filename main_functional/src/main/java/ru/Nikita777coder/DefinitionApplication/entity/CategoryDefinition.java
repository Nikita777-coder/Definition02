package ru.Nikita777coder.DefinitionApplication.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category_definition")
public class CategoryDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Definition> definitions;

    public CategoryDefinition() {
    }

    public CategoryDefinition(String name, List<Definition> definitions) {
        this.name = name;
        this.definitions = definitions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

}
