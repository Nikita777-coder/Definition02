package ru.Nikita777coder.DefinitionApplication.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.Nikita777coder.RestService;

@Configuration
public class AppElementsSetup {
    @Bean
    public RestService restService() {
        return new RestService();
    }
}
