package dev.shraman.movies.controller;

import dev.shraman.movies.manager.MovieManager;
import dev.shraman.movies.data.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static dev.shraman.movies.MovieConstants.BASE_URL;
import static dev.shraman.movies.MovieConstants.IMDB_ID_KEY;

@RestController
@RequestMapping(BASE_URL)
public class MovieController {

    @Autowired
    private MovieManager movieManager;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieManager.getAllMovies());
    }

    @GetMapping(value = "/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable(value = IMDB_ID_KEY) final String imdbId) {
        return ResponseEntity.ok(movieManager.getMovieByImdbId(imdbId));
    }

}
