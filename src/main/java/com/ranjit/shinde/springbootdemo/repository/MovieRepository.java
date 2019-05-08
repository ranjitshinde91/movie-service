package com.ranjit.shinde.springbootdemo.repository;


import com.ranjit.shinde.springbootdemo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface MovieRepository extends JpaRepository<Movie, String> {


}


