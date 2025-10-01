package com.thoughtclan.todo_movies.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private String studio;

    @Column(name = "rotten_tomatoes")
    private Integer rottenTomatoes;

    // changed field name to avoid reserved keyword issues
    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "poster_url")
    private String posterUrl;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }

    public Integer getRottenTomatoes() { return rottenTomatoes; }
    public void setRottenTomatoes(Integer rottenTomatoes) { this.rottenTomatoes = rottenTomatoes; }

    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }
}
