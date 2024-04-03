package mk.ukim.finki.movieTicket.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    private String address;

    public Production( String name, String country, String address) {
        this.name = name;
        this.country = country;
        this.address = address;
    }

    public Production() { }
}
