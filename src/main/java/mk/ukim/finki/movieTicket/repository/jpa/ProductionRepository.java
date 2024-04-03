package mk.ukim.finki.movieTicket.repository.jpa;

import mk.ukim.finki.movieTicket.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long > {


}
