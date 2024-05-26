package ru.screbber.DefinitionApplication.dto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.screbber.DefinitionApplication.models.Person;

@Repository
@Transactional
public class PersonDTO {
    @PersistenceContext
    private EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public void save(Person person) {
        entityManager.merge(person);
    }

    public void delete(Person person) {
        entityManager.remove(person);
    }
}