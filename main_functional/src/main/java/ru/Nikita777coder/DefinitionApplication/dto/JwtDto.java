package ru.Nikita777coder.DefinitionApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@AllArgsConstructor
public class JwtDto {
    private String jwt;
    private UserDetails userDetails;
}
