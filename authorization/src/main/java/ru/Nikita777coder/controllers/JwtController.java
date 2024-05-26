package ru.Nikita777coder.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.Nikita777coder.dto.JwtRequest;
import ru.Nikita777coder.services.JwtService;

@RestController
@RequestMapping("/jwt")
@RequiredArgsConstructor
public class JwtController {
    private final JwtService jwtService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isTokenValid(@Valid @RequestBody JwtRequest jwtRequest) {
        return jwtService.isTokenValid(jwtRequest.getToken(), jwtRequest.getUserDetails());
    }
}
