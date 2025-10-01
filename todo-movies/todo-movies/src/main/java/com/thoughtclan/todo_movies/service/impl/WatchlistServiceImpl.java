package com.thoughtclan.todo_movies.service.impl;

import com.thoughtclan.todo_movies.dto.MovieDto;
import com.thoughtclan.todo_movies.model.Movie;
import com.thoughtclan.todo_movies.model.User;
import com.thoughtclan.todo_movies.model.Watchlist;
import com.thoughtclan.todo_movies.repository.MovieRepository;
import com.thoughtclan.todo_movies.repository.UserRepository;
import com.thoughtclan.todo_movies.repository.WatchlistRepository;
import com.thoughtclan.todo_movies.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    @Autowired private UserRepository userRepository;
    @Autowired private MovieRepository movieRepository;
    @Autowired private WatchlistRepository watchlistRepository;

    @Transactional
    public void addToWatchlist(String username, Long movieId) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        if (watchlistRepository.existsByUserAndMovie(user, movie)) return;
        Watchlist w = new Watchlist();
        w.setUser(user);
        w.setMovie(movie);
        watchlistRepository.save(w);
    }

    @Transactional
    public void removeFromWatchlist(String username, Long movieId) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found"));
        watchlistRepository.findByUserAndMovie(user, movie).ifPresent(watchlistRepository::delete);
    }

    @Transactional(readOnly = true)
    public List<MovieDto> getUserWatchlist(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        return watchlistRepository.findByUser(user).stream().map(w -> {
            Movie m = w.getMovie();
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
        }).collect(Collectors.toList());
    }
}
