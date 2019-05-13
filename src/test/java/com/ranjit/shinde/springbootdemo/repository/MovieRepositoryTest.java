package com.ranjit.shinde.springbootdemo.repository;

import com.ranjit.shinde.springbootdemo.model.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private MovieRepository movieRepository;


    @Test
    @DisplayName("Should Return movies with given name")
    public void getByMovieNameShouldFetchMatchingMovies() {
        Movie movie = new Movie("COCO", LocalDate.now(), 120);
        testEntityManager.persist(movie);
        testEntityManager.flush();

        Movie result = movieRepository.findByName("COCO");

        assertThat(result.getName()).isEqualTo("COCO");
        assertThat(result.getLength()).isEqualTo(120);
        assertThat(result.getReleaseDate()).isEqualTo(LocalDate.now());
    }


}