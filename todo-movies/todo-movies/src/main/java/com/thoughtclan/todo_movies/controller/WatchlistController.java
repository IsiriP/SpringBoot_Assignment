package com.thoughtclan.todo_movies.controller;

import com.thoughtclan.todo_movies.dto.MovieDto;
import com.thoughtclan.todo_movies.service.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/watchlist")
public class WatchlistController {

    @Autowired private WatchlistService watchlistService;

    // Add to watchlist for authenticated user
    @PostMapping("/{movieId}")
    public void add(@PathVariable Long movieId, Authentication auth) {
        watchlistService.addToWatchlist(auth.getName(), movieId);
    }

    // Get current user's watchlist
    @GetMapping
    public List<MovieDto> list(Authentication auth) {
        return watchlistService.getUserWatchlist(auth.getName());
    }

    // Remove from watchlist
    @DeleteMapping("/{movieId}")
    public void remove(@PathVariable Long movieId, Authentication auth) {
        watchlistService.removeFromWatchlist(auth.getName(), movieId);
    }
}
