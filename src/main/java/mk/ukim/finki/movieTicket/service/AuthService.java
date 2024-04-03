package mk.ukim.finki.movieTicket.service;

import mk.ukim.finki.movieTicket.model.User;

public interface AuthService {
    User login(String username, String password);
}
