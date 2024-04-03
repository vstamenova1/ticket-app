package mk.ukim.finki.movieTicket.service.impl;


import mk.ukim.finki.movieTicket.model.ShoppingCart;
import mk.ukim.finki.movieTicket.model.TicketOrder;
import mk.ukim.finki.movieTicket.model.User;
import mk.ukim.finki.movieTicket.repository.jpa.ShoppingCartRepository;
import mk.ukim.finki.movieTicket.repository.jpa.UserRepository;
import mk.ukim.finki.movieTicket.service.ShoppingCartService;
import mk.ukim.finki.movieTicket.service.TicketOrderService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final TicketOrderService ticketOrderService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository,TicketOrderService ticketOrderService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository= userRepository;
        this.ticketOrderService = ticketOrderService;
    }

    @Override
    public List<TicketOrder> listAllOrdersInShoppingCart(Long cartId) {
         return this.shoppingCartRepository.findById(cartId).get().getTicketOrders();
    }

    @Override
    public ShoppingCart addOrderToShoppingCart(String username, Long orderId) {
        User user = userRepository.findUserByUsername(username);
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user);
        TicketOrder ticketOrder = ticketOrderService.findById(orderId);
        if (shoppingCart != null )
            shoppingCart.getTicketOrders().add(ticketOrder);
        else {
            ShoppingCart cart = new ShoppingCart(user);
            return shoppingCartRepository.save(cart);
        }

       return shoppingCartRepository.save(shoppingCart);
    }


    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
      User user= userRepository.findUserByUsername(username);
      ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user);
      if (shoppingCart != null )
          return shoppingCart;
      else{
          ShoppingCart cart = new ShoppingCart(user);
          return shoppingCartRepository.save(cart);
      }
    }

}
