package mk.ukim.finki.movieTicket.service;

import mk.ukim.finki.movieTicket.model.ShoppingCart;
import mk.ukim.finki.movieTicket.model.TicketOrder;

import java.util.List;

public interface ShoppingCartService {

    List<TicketOrder> listAllOrdersInShoppingCart(Long cartId);

    ShoppingCart addOrderToShoppingCart(String username, Long orderId);

    ShoppingCart getActiveShoppingCart(String username);

}

