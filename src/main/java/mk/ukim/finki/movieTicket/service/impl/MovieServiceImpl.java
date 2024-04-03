package mk.ukim.finki.movieTicket.service.impl;
import mk.ukim.finki.movieTicket.model.Movie;
import mk.ukim.finki.movieTicket.model.Production;
import mk.ukim.finki.movieTicket.model.exceptions.ProductionNotFoundException;
import mk.ukim.finki.movieTicket.repository.jpa.MovieRepository;
import mk.ukim.finki.movieTicket.repository.jpa.ProductionRepository;
import mk.ukim.finki.movieTicket.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return this.movieRepository.findById(id);
    }

    @Override
    public Movie save(String title, String summary, Double rating, Long productionId) {
        Production prod = productionRepository.findById(productionId).orElseThrow(() -> new ProductionNotFoundException(productionId));
        return movieRepository.save(new Movie(title,summary,rating,prod));
    }

    @Override
    public Movie create( String title, String summary, Double rating, Long productionId){
        Production prod = productionRepository.findById(productionId).get();
        Movie movie = new Movie(title,summary,rating,prod);
        return movieRepository.save(movie);
    }
    @Override
    public Movie update (Long id, String title, String summary, Double rating, Long productionId){
        Movie movie = movieRepository.findById(id).get();
        movie.setTitle(title);
        movie.setSummary(summary);
        movie.setRating(rating);
        Production production = productionRepository.findById(productionId).get();
        movie.setProduction(production);
        return movieRepository.save(movie);
    }

    @Override
    public void deleteById(Long id) {
        this.movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> filter(String text, Double rating){
        if(text != null && rating != null){
            return movieRepository.findAllByTitleContainingAndRatingEquals(text,rating);
        }
        else if(text != null){
            return movieRepository.findAllByTitleContaining(text);
        }
        else if (rating != null ){
            return movieRepository.findMoviesByRatingGreaterThan(rating);
        }
        return listAll();
    }

}
