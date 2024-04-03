package mk.ukim.finki.movieTicket.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private mk.ukim.finki.movieTicket.model.User user;

    @DateTimeFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private LocalDateTime dateCreated;

    @ManyToMany
    private List<TicketOrder> ticketOrders;


    public ShoppingCart() { }

    public ShoppingCart(mk.ukim.finki.movieTicket.model.User user) {
        this.user = user;
        this.dateCreated = LocalDateTime.now();
        this.ticketOrders = new ArrayList<>();
    }
}
