package dev.shraman.movies.controller;

import dev.shraman.movies.manager.ReviewManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static dev.shraman.movies.MovieConstants.BASE_URL;
import static dev.shraman.movies.MovieConstants.REVIEW_BODY_KEY;
import static dev.shraman.movies.MovieConstants.IMDB_ID_KEY;


@RestController
@RequestMapping(BASE_URL)
public class ReviewController {

    @Autowired
    private ReviewManager reviewManager;

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody final Map<String, String> requestBody) {

        final String reviewBody = requestBody.getOrDefault(REVIEW_BODY_KEY, "");
        final String imdbId = requestBody.getOrDefault(IMDB_ID_KEY, "");

        return ResponseEntity.ok(reviewManager.createReview(reviewBody, imdbId));

    }
}
