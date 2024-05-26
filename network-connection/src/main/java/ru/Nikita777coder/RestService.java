package ru.Nikita777coder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class RestService {
    private final RestTemplate restTemplate = new RestTemplate();
    public <T> T get(String uri, Class<T> typeKey) {
        return restTemplate.getForObject(uri, typeKey);
    }

    public <T, V> T get(String uri, V body, Class<T> typeKey) {
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(body), typeKey).getBody();
    }

    public <T, V> T post(String uri, V body, Class<T> response) {
        return restTemplate.postForObject(uri, body, response);
    }
}
