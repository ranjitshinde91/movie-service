package com.ranjit.shinde.springbootdemo.service;

import com.ranjit.shinde.springbootdemo.model.Movie;
import com.ranjit.shinde.springbootdemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public List<Movie> list() {
        return movieRepository.findAll();
    }

    public void saveOrUpdate(Movie movie){
        movieRepository.save(movie);
    }

    public void delete(String name){
        movieRepository.deleteById(name);
    }

    public List<Movie> getPage(int pageNo) {
        Page<Movie> all = movieRepository.findAll(PageRequest.of(pageNo, 1));
        return all.map(page -> page).stream().collect(toList());
    }
}