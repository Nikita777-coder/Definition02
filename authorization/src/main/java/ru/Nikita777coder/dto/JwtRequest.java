package ru.Nikita777coder.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
public class JwtRequest {
    private String token;
    private UserDetails userDetails;
}
