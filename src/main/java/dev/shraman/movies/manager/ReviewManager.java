package dev.shraman.movies.manager;

import dev.shraman.movies.repository.ReviewRepository;
import dev.shraman.movies.data.Movie;
import dev.shraman.movies.data.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static dev.shraman.movies.MovieConstants.IMDB_ID_KEY;
import static dev.shraman.movies.MovieConstants.REVIEW_IDS_KEY;

@Service
public class ReviewManager {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public String createReview(final String reviewBody, final String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where(IMDB_ID_KEY).is(imdbId))
                .apply(new Update().push(REVIEW_IDS_KEY, review)).first();

        return review.getId().toHexString();
    }

}
