package mk.ukim.finki.movieTicket.service.impl;

import mk.ukim.finki.movieTicket.model.TicketOrder;

import mk.ukim.finki.movieTicket.repository.jpa.TicketOrderRepository;
import mk.ukim.finki.movieTicket.service.TicketOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {

    private final TicketOrderRepository ticketOrderRepository;

    public TicketOrderServiceImpl(TicketOrderRepository ticketOrderRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
    }

    @Override
    public TicketOrder placeOrder(TicketOrder ticketOrder) {
        //TicketOrder ticketOrder = new TicketOrder(movieTitle,numberOfTickets,user);
        ticketOrderRepository.save(ticketOrder);
        return ticketOrder;
    }


    @Override
    public TicketOrder findById(Long id) {
        return ticketOrderRepository.findById(id).get();
    }

//    @Override
//    public TicketOrder save(String movieTitle, String clientName, String clientAddress, int numberOfTickets) {
//        return ticketOrderRepository.save(new TicketOrder(movieTitle,clientName,clientAddress,numberOfTickets));
//    }

    @Override
    public void deleteById(Long id) {
       this.ticketOrderRepository.deleteById(id);
    }

    @Override
    public List<TicketOrder> listAll() {
        return ticketOrderRepository.findAll();
    }
}
