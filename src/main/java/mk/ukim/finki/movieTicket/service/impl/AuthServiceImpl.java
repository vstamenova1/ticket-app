package mk.ukim.finki.movieTicket.service.impl;

import mk.ukim.finki.movieTicket.model.User;
import mk.ukim.finki.movieTicket.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.movieTicket.repository.jpa.UserRepository;
import mk.ukim.finki.movieTicket.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

}
