package mk.ukim.finki.movieTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MovieTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieTicketApplication.class, args);
    }

}
