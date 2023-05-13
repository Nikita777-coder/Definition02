package ru.screbber.DefinitionApplication.dao;

import org.springframework.stereotype.Repository;
import ru.screbber.DefinitionApplication.models.CategoryDefinition;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Transactional
public class CategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public CategoryDefinition getDefinitionById(int id) {
        return entityManager.find(CategoryDefinition.class, id);
    }
}
