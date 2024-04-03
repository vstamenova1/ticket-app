package mk.ukim.finki.movieTicket.web.controller;

import mk.ukim.finki.movieTicket.model.TicketOrder;
import mk.ukim.finki.movieTicket.model.User;
import mk.ukim.finki.movieTicket.service.ShoppingCartService;
import mk.ukim.finki.movieTicket.service.TicketOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/orderConfirm")
public class TicketOrderController {

    private final TicketOrderService ticketOrderService;
    private final ShoppingCartService shoppingCartService;

    public TicketOrderController(TicketOrderService ticketOrderService,ShoppingCartService shoppingCartService) {
        this.ticketOrderService = ticketOrderService;
        this.shoppingCartService=shoppingCartService;
    }

    @PostMapping("/showOrder")
    public String orderConfirmation(@RequestParam  String selectMovie,
                                    @RequestParam Integer numTickets,
                                    @RequestParam String dateOrder, HttpServletRequest request,Model model){
        model.addAttribute("selectMovie", selectMovie);
        model.addAttribute("numTickets", numTickets);
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        model.addAttribute("dateOrder",dateOrder);
        TicketOrder ticketOrder = new TicketOrder(selectMovie,numTickets,user);
        ticketOrderService.placeOrder(ticketOrder);
        shoppingCartService.addOrderToShoppingCart(user.getUsername(),ticketOrder.getId() );
        return "orderConfirmation";
    }

    @GetMapping("/delete/{id}")
    public String deleteTicket(@PathVariable Long id, Model model){
        model.addAttribute("ticket",ticketOrderService.findById(id));
        this.ticketOrderService.deleteById(id);
        return "redirect:/orderConfirm";
    }

    @GetMapping("/edit/{id}")
    public String editTicket(@PathVariable Long id, Model model){
        model.addAttribute("ticket",ticketOrderService.findById(id));
        this.ticketOrderService.deleteById(id);
        return "redirect:/orderConfirm";
    }
}
