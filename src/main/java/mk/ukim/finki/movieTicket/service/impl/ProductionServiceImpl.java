package mk.ukim.finki.movieTicket.service.impl;

import mk.ukim.finki.movieTicket.model.Production;
import mk.ukim.finki.movieTicket.repository.jpa.ProductionRepository;
import mk.ukim.finki.movieTicket.service.ProductionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    private final ProductionRepository productionRepository;

    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Production> findAll() {
        return productionRepository.findAll();
    }
}
