package mk.ukim.finki.movieTicket.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String name;
    private String surname;
    private String password;


    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List <ShoppingCart> carts;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        this.dateOfBirth = LocalDate.parse(dateOfBirth.format(dateTimeFormatter));
    }
}
