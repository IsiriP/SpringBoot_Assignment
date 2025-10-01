package com.thoughtclan.todo_movies.controller;

import com.thoughtclan.todo_movies.dto.MovieDto;
import com.thoughtclan.todo_movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired private MovieService movieService;

    // GET /api/movies?minRating=50&sort=asc
    @GetMapping
    public List<MovieDto> listMovies(@RequestParam(required=false) Integer minRating,
                                     @RequestParam(required=false, defaultValue="desc") String sort) {
        return movieService.listMovies(minRating, sort);
    }

    @GetMapping("/{id}")
    public MovieDto getMovie(@PathVariable Long id) {
        MovieDto dto = movieService.getMovie(id);
        if (dto == null) throw new ResourceNotFoundException("Movie not found");
        return dto;
    }
}
