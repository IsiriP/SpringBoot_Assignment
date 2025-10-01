package com.thoughtclan.todo_movies.service;

import com.thoughtclan.todo_movies.dto.MovieDto;
import java.util.List;

public interface WatchlistService {
    void addToWatchlist(String username, Long movieId);
    void removeFromWatchlist(String username, Long movieId);
    List<MovieDto> getUserWatchlist(String username);
}
