package mk.ukim.finki.movieTicket.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductionNotFoundException extends RuntimeException{

    public ProductionNotFoundException(Long id){
        super(String.format("Production with id: %d is not found", id));
    }

}

