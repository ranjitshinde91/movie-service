package com.ranjit.shinde.springbootdemo.config;

import com.ranjit.shinde.springbootdemo.model.Movie;
import com.ranjit.shinde.springbootdemo.service.MovieService;
import org.springframework.context.annotation.*;

import java.time.LocalDate;

@Configuration
@Import({InfrastructureConfig.class})
@ComponentScan()
public class AppConfig {

    @Bean @Scope("prototype")
    public Movie ddlj(){
        return new Movie("DDLJ", LocalDate.now(), 178);
    }
}
