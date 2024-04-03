package mk.ukim.finki.movieTicket.web.controller;

import mk.ukim.finki.movieTicket.model.Movie;
import mk.ukim.finki.movieTicket.model.Production;
import mk.ukim.finki.movieTicket.service.MovieService;
import mk.ukim.finki.movieTicket.service.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller

public class MovieController {

    private final MovieService movieService;
    private final ProductionService productionService;

    public MovieController(MovieService movieService, ProductionService productionService) {
        this.movieService = movieService;
        this.productionService=productionService;
    }

    @GetMapping({"/movies", "/"})
    public String getMoviesPage(@RequestParam(required = false) String searchText,
                                @RequestParam (required = false) Double rating, Model model) {
        List<Movie> movies;
        if(searchText==null && rating == null){
            movies = movieService.listAll();
        }
        else {
            movies=movieService.filter(searchText, rating);
        }
        model.addAttribute("movies",movies);
        return "listMovies.html";
    }

    @GetMapping("/movies/delete/{id}")
    public String deleteMovie (@PathVariable Long id){
        this.movieService.deleteById(id);
        return "redirect:/movies";

    }

    @GetMapping("/movies/edit-form/{id}")
    public String editMovie(@PathVariable Long id, Model model) {
        if (this.movieService.findById(id).isPresent()) {
            Movie movie = movieService.findById(id).get();
            List<Production> productions = productionService.findAll();
            model.addAttribute("movie", movie);
            model.addAttribute("productions", productions);
            return "add-movie";
        }
         return "redirect:/movies?error=MovieNotFound";
    }

    @GetMapping("/movies/add-form")
    public String getAddMoviePage(Model model) {
        List<Production> productions = this.productionService.findAll();
        model.addAttribute("productions", productions);
        return "add-movie";
    }


    @PostMapping("/movies/add")
    public String saveMovie(
            @RequestParam String title,
            @RequestParam String summary,
            @RequestParam double rating,
            @RequestParam Long productions) {
        this.movieService.save(title, summary, rating, productions);
        return "redirect:/movies";
    }


}
