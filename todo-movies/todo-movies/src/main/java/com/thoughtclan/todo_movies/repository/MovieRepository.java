package com.thoughtclan.todo_movies.repository;

import com.thoughtclan.todo_movies.model.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByRottenTomatoesGreaterThanEqual(Integer minRating, Sort sort);
}
