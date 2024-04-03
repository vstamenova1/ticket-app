package mk.ukim.finki.movieTicket.repository.jpa;

import mk.ukim.finki.movieTicket.model.ShoppingCart;
import mk.ukim.finki.movieTicket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    ShoppingCart findByUser(User user);

}
