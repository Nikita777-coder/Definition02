package ru.Nikita777coder.DefinitionApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table
@Getter
@Setter
@NoArgsConstructor
public class Definition {
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String info;

    @Column
    private List<Integer> person;
}