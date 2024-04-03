package mk.ukim.finki.movieTicket.repository.jpa;

import mk.ukim.finki.movieTicket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByUsername (String username);
}
