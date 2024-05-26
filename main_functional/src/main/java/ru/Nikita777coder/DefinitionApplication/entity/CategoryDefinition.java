package ru.Nikita777coder.DefinitionApplication.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table
@Getter
@Setter
@NoArgsConstructor
public class CategoryDefinition {

    @PrimaryKey
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private List<Integer> definitions;

}
