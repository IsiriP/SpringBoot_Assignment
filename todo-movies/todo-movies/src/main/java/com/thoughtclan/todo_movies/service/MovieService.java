package com.thoughtclan.todo_movies.service;

import com.thoughtclan.todo_movies.dto.MovieDto;
import java.util.List;

public interface MovieService {
    List<MovieDto> listMovies(Integer minRating, String sortOrder);
    MovieDto getMovie(Long id);
}
