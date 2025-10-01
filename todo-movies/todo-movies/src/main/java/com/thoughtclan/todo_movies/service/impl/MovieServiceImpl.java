package com.thoughtclan.todo_movies.service.impl;

import com.thoughtclan.todo_movies.dto.MovieDto;
import com.thoughtclan.todo_movies.model.Movie;
import com.thoughtclan.todo_movies.repository.MovieRepository;
import com.thoughtclan.todo_movies.repository.WatchlistRepository;
import com.thoughtclan.todo_movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired private MovieRepository movieRepository;
    @Autowired private WatchlistRepository watchlistRepository;

    @Override
    public List<MovieDto> listMovies(Integer minRating, String sortOrder) {
        Sort sort = Sort.by("releaseYear");
        sort = "asc".equalsIgnoreCase(sortOrder) ? sort.ascending() : sort.descending();

        List<Movie> movies;
        if (minRating != null) movies = movieRepository.findByRottenTomatoesGreaterThanEqual(minRating, sort);
        else movies = movieRepository.findAll(sort);

        return movies.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovie(Long id) {
        Movie m = movieRepository.findById(id).orElse(null);
        return m == null ? null : toDto(m);
    }

    private MovieDto toDto(Movie m) {
        MovieDto dto = new MovieDto();
        dto.id = m.getId();
        dto.title = m.getTitle();
        dto.genre = m.getGenre();
        dto.studio = m.getStudio();
        dto.rottenTomatoes = m.getRottenTomatoes();
        dto.releaseYear = m.getReleaseYear();
        dto.posterUrl = m.getPosterUrl();
        dto.watchersCount = watchlistRepository.countByMovie(m);
        return dto;
    }
}
