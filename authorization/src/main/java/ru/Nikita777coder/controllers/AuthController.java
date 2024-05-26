package ru.Nikita777coder.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.Nikita777coder.dto.JwtResponse;
import ru.Nikita777coder.dto.UserData;
import ru.Nikita777coder.services.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    public JwtResponse signUp(@Valid @RequestBody UserData newUserData) {
        return authService.signUp(newUserData);
    }

    @PostMapping("/signIn")
    @ResponseStatus(HttpStatus.OK)
    public JwtResponse signIn(UserData userData) {
        return authService.signIn(userData);
    }
}
