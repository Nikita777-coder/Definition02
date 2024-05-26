package ru.Nikita777coder.DefinitionApplication.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Nikita777coder.DefinitionApplication.entity.Definition;

@Repository
public interface DefinitionRepository extends CassandraRepository<Definition, Integer> {
}
