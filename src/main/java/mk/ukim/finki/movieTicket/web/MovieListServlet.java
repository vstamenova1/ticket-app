//package mk.ukim.finki.lab.web.servlet;
//
//import mk.ukim.finki.lab.model.Movie;
//import mk.ukim.finki.lab.model.TicketOrder;
//import mk.ukim.finki.lab.service.MovieService;
//import mk.ukim.finki.lab.service.TicketOrderService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@WebServlet(name="movieListServlet", urlPatterns = "/list")
//public class MovieListServlet extends HttpServlet {
//
//    private final MovieService movieService;
//    private final SpringTemplateEngine templateEngine;
//    private final TicketOrderService ticketOrderService;
//
//    public MovieListServlet(MovieService movieService,SpringTemplateEngine templateEngine,TicketOrderService ticketOrderService
//    ) {
//        this.movieService = movieService;
//        this.templateEngine=templateEngine;
//        this.ticketOrderService= ticketOrderService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        WebContext context= new WebContext(req,resp,req.getServletContext());
//
//        String text = req.getParameter("searchText");
//        String rating = req.getParameter("rating");
//
//        List<Movie> searchMovies;
//
//        if ((text!=null && !text.isEmpty()) && (rating!=null && !rating.isEmpty())){
//            searchMovies=movieService.searchByTitleAndRating(text,Double.parseDouble(rating));
//        }
//
//        else if (text!=null && !text.isEmpty())  {
//            searchMovies=movieService.searchByTitle(text);
//        }
//
//         else if (rating!=null && !rating.isEmpty()) {
//            searchMovies = movieService.searchByRating(Double.parseDouble(rating));
//        }
//
//        else
//            searchMovies = movieService.listAll();
//            context.setVariable("movies", searchMovies);
//            templateEngine.process("listMovies.html",context,resp.getWriter());
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String title = req.getParameter("selectMovie");
//        int numOfTickets = Integer.parseInt(req.getParameter("numTickets"));
//        String address= req.getRemoteAddr();
//
////        TicketOrder ticketOrder = ticketOrderService.placeOrder(title,"Viktorija",address,numOfTickets);
////
////        req.getSession().setAttribute("ticket",ticketOrder);
////        resp.sendRedirect("/ticketOrder");
//    }
//
//
//}
//
