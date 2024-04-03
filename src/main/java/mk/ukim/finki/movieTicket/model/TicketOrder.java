package mk.ukim.finki.movieTicket.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TicketOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieTitle;

    private int numberOfTickets;

    @ManyToOne
    private User user;

    public TicketOrder(String movieTitle, int numberOfTickets) {
        this.movieTitle = movieTitle;
        this.numberOfTickets = numberOfTickets;

    }

    public TicketOrder(String movieTitle, int numberOfTickets, User user) {
        this.movieTitle = movieTitle;
        this.numberOfTickets = numberOfTickets;
        this.user = user;
    }

    public TicketOrder(String movieTitle, String clientName, String clientAddress, int numberOfTickets) {
        this.movieTitle = movieTitle;
        this.numberOfTickets = numberOfTickets;

    }

    public TicketOrder() { }
}
