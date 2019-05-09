package com.ranjit.shinde.springbootdemo.controller;


import com.ranjit.shinde.springbootdemo.exception.MovieNotFoundException;
import com.ranjit.shinde.springbootdemo.model.Movie;
import com.ranjit.shinde.springbootdemo.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/movies")
@Validated
@Slf4j
public class MovieController {

    @Autowired
    private MovieService movieService;

    @ResponseBody
    @GetMapping("/")
    public List<Movie> all(){
        return  movieService.list();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Movie byId(@PathVariable("id") @NotBlank @Size(min = 2) String id ){
       try {
        return  movieService.get(id);
       }
        catch (MovieNotFoundException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found");
        }
    }

    @ResponseBody
    @PostMapping("/")
    public String create(@RequestBody Movie movie) {
        movieService.saveOrUpdate(movie);
        return movie.getName();
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String name) {
        movieService.delete(name);
        return name;
    }

}
