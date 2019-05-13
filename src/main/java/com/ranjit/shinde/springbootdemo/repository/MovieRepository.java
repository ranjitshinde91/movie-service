package com.ranjit.shinde.springbootdemo.repository;


import com.ranjit.shinde.springbootdemo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository()
public interface MovieRepository extends JpaRepository<Movie, String> {

    List<Movie> findByName(String name);
}


