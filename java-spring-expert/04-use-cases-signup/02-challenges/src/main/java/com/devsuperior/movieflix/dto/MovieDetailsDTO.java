package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;

public class MovieDetailsDTO extends MovieCardDTO {

    private String synopsis;
    private GenreDTO genre;

    public MovieDetailsDTO() {
    }

    public MovieDetailsDTO(Movie entity) {
        super(entity); 
        this.synopsis = entity.getSynopsis();
        this.genre = new GenreDTO(entity.getGenre()); 
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }
}