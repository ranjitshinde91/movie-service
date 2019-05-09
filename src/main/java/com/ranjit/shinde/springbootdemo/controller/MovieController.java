package com.ranjit.shinde.springbootdemo.controller;


import com.ranjit.shinde.springbootdemo.exception.MovieNotFoundException;
import com.ranjit.shinde.springbootdemo.model.Movie;
import com.ranjit.shinde.springbootdemo.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/movies")
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
    public Movie byId(@PathVariable("id") String id){
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
