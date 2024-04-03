package mk.ukim.finki.movieTicket.service;

import mk.ukim.finki.movieTicket.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> listAll();
    Optional<Movie> findById(Long id);
    Movie create (String title, String summary, Double rating, Long productionId);
    Movie update (Long id, String title, String summary, Double rating, Long productionId);
    Movie save (String title, String summary, Double rating, Long productionId);
    void deleteById(Long id);
    List<Movie> filter (String text, Double rating);

}
