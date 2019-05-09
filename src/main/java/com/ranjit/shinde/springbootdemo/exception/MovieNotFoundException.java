package com.ranjit.shinde.springbootdemo.exception;

public class MovieNotFoundException extends RuntimeException {
    private String id;

    public MovieNotFoundException(String movieId) {
        this.id = movieId;
    }

    @Override
    public String getMessage() {
        return String.format("Movie With id: %s not present", this.id);
    }
}
