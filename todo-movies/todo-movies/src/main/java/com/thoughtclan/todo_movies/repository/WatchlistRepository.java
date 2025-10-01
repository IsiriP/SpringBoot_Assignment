package com.thoughtclan.todo_movies.repository;

import com.thoughtclan.todo_movies.model.Movie;
import com.thoughtclan.todo_movies.model.User;
import com.thoughtclan.todo_movies.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    boolean existsByUserAndMovie(User user, Movie movie);
    Optional<Watchlist> findByUserAndMovie(User user, Movie movie);
    List<Watchlist> findByUser(User user);
    long countByMovie(Movie movie);
    void deleteByUserAndMovie(User user, Movie movie);
}
