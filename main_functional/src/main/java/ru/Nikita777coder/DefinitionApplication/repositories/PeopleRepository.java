package ru.Nikita777coder.DefinitionApplication.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Nikita777coder.DefinitionApplication.entity.Person;

import java.util.Optional;

@Repository
public interface PeopleRepository extends CassandraRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);
}
