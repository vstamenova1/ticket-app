package mk.ukim.finki.movieTicket.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String summary;

    private Double rating;

    @ManyToOne
    private Production production;

    public Movie(String title, String summary, Double rating,Production production) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production = production;
    }

    public Movie() { }
}
