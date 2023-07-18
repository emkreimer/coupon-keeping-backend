package br.emkreimer.coupon.repository;

import br.emkreimer.coupon.domain.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.supply != 0")
    public List<Product> findAllAvailable();

    @Query("SELECT p FROM Product p WHERE p.id = ?1 AND p.supply != 0")
    public Product findOneWhileAvailable(Long id);
}
