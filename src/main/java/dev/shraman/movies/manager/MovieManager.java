package dev.shraman.movies.manager;

import dev.shraman.movies.repository.MovieRepository;
import dev.shraman.movies.data.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieManager {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieByImdbId(final String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }
}
