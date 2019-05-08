package com.ranjit.shinde.springbootdemo.controller;


import com.ranjit.shinde.springbootdemo.model.Movie;
import com.ranjit.shinde.springbootdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
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
        return  movieService.get(id);
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
