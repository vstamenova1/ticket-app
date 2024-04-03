package mk.ukim.finki.movieTicket.service;

import mk.ukim.finki.movieTicket.model.TicketOrder;

import java.util.List;

public interface TicketOrderService {

    //TicketOrder placeOrder(String movieTitle,  int numberOfTickets, User user);
    TicketOrder placeOrder(TicketOrder ticketOrder);
    TicketOrder findById (Long id);
    void deleteById(Long id);
    List<TicketOrder> listAll();
}
