package com.ranjit.shinde.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String name;
    private LocalDate releaseDate;
    private long length;

}
