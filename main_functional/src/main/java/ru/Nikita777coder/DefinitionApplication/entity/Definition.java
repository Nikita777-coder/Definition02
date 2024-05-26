package ru.Nikita777coder.DefinitionApplication.entity;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "definition")
public class Definition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "info")
    private String info;

    @ManyToMany(mappedBy = "definitions")
    private List<Person> person;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryDefinition category;

    public Definition() {
    }

    public Definition(String name, String info, List<Person> person, CategoryDefinition category) {
        this.name = name;
        this.info = info;
        this.person = person;
        this.category = category;
    }

    public CategoryDefinition getCategory() {
        return category;
    }

    public void setCategory(CategoryDefinition category) {
        this.category = category;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Definition)) return false;

        Definition that = (Definition) o;

        if (getId() != that.getId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getInfo() != null ? getInfo().equals(that.getInfo()) : that.getInfo() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getInfo() != null ? getInfo().hashCode() : 0);
        return result;
    }
}