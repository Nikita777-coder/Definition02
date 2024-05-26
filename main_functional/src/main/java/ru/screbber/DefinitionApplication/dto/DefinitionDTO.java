package ru.screbber.DefinitionApplication.dto;

import org.springframework.stereotype.Repository;
import ru.screbber.DefinitionApplication.models.Definition;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DefinitionDTO {

    @PersistenceContext
    private EntityManager entityManager;

    public Definition getDefinitionById(int id) {
        return entityManager.find(Definition.class, id);
    }

    public List<Definition> getAllDefinitions() {
        String jpql = "SELECT d FROM Definition d ORDER BY category.id DESC";
        TypedQuery<Definition> query = entityManager.createQuery(jpql, Definition.class);
        return query.getResultList();
    }

    public void deleteById(int id) {
        Definition definition = entityManager.find(Definition.class, id);
        if (definition != null) {
            entityManager.remove(definition);
        }
    }
}
