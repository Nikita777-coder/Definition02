package ru.Nikita777coder.DefinitionApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Column
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private List<Integer> definitions;
}