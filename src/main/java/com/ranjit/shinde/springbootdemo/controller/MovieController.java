package com.ranjit.shinde.springbootdemo.controller;


import com.ranjit.shinde.springbootdemo.model.Movie;
import com.ranjit.shinde.springbootdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @ResponseBody
    @GetMapping("/movies")
    public List<Movie> list(){
        return  movieService.list();
    }

    @ResponseBody
    @GetMapping("/moviepage")
    public List<Movie> getPagedList(@RequestHeader("pageNo") int pageNo){
        return  movieService.getPage(pageNo);
    }

    @ResponseBody
    @PostMapping("/movie")
    public String saveMovie(@RequestBody Movie movie) {
        movieService.saveOrUpdate(movie);
        return movie.getName();
    }

    @ResponseBody
    @DeleteMapping("/movie/{id}")
    public String deleteMovie(@PathVariable("id") String name) {
        movieService.delete(name);
        return name;
    }
}
