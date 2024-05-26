package ru.Nikita777coder.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestService {
    private final RestTemplate restTemplate;
    public <T> T get(String uri, Class<T> typeKey) {
        return restTemplate.getForObject(uri, typeKey);
    }

    public <T, V> T post(String uri, V body, Class<T> response) {
        return restTemplate.postForObject(uri, body, response);
    }
}
