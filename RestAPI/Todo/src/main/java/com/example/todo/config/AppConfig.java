package com.example.todo.config;

import com.example.todo.enity.TodoVadilator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TodoVadilator todoVadilator(){
        return new TodoVadilator();
    }
}
