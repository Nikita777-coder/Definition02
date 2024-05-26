package ru.Nikita777coder.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.Nikita777coder.RestService;
import ru.Nikita777coder.dto.JwtResponse;
import ru.Nikita777coder.dto.UserData;

@Service
@RequiredArgsConstructor
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class AuthService {
    private final RestService restService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public JwtResponse signUp(UserData userData) {
        String userCreatUrl = "http://localhost:8080/users/create";
        UserDetails resultUserDetails = restService.post(userCreatUrl, userData, UserDetails.class);

        JwtResponse response = new JwtResponse();
        response.setToken(jwtService.generateToken(resultUserDetails));

        return response;
    }
    public JwtResponse signIn(UserData userData) {
        String userGetUrl = "http://localhost:8080/users/" + userData.getUsername();
        UserDetails resultUser = restService.get(userGetUrl, UserDetails.class);

        if (!passwordEncoder.matches(userData.getPassword(), resultUser.getPassword())) {
            throw new IllegalArgumentException("password is invalid!");
        }

        JwtResponse response = new JwtResponse();
        response.setToken(jwtService.generateToken(resultUser));

        return response;
    }
}
