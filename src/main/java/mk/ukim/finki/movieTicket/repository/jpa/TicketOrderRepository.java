package mk.ukim.finki.movieTicket.repository.jpa;

import mk.ukim.finki.movieTicket.model.TicketOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketOrderRepository extends JpaRepository<TicketOrder, Long> {


}
