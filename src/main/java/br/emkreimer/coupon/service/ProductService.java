package br.emkreimer.coupon.service;

import br.emkreimer.coupon.domain.model.Product;
import br.emkreimer.coupon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository pRepository;

    public List<Product> listAll() {
        return pRepository.findAllAvailable();
    }

    public void save(Product product) {
        // validator
        pRepository.save(product);
    }
}
