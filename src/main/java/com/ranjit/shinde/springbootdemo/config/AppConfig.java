package com.ranjit.shinde.springbootdemo.config;

import com.ranjit.shinde.springbootdemo.model.Movie;
import com.ranjit.shinde.springbootdemo.service.MovieService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;

@Configuration
@Import({InfrastructureConfig.class})
public class AppConfig {

    @Bean
    public Movie ddlj(){
        return new Movie("DDLJ", LocalDate.now(), 178);
    }
}
