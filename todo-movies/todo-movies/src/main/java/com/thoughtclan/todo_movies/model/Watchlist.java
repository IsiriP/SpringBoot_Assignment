package com.thoughtclan.todo_movies.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "watchlist")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "added_at")
    private LocalDateTime addedAt = LocalDateTime.now();

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public LocalDateTime getAddedAt() { return addedAt; }
    public void setAddedAt(LocalDateTime addedAt) { this.addedAt = addedAt; }
}
